/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.biblioteca;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHits;

/**
 *
 * @author ResVUT42
 */
public class ConexaoES {

    private static ConexaoES instance = new ConexaoES();

    private Client client = null;

    private ConexaoES() {

        try {

            Settings settings = Settings.settingsBuilder().put("cluster.name", "tamagu").build();

            String ip = InetAddress.getLocalHost().getHostAddress();

            client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), 9300));

        } catch (UnknownHostException ex) {
            printStackTrace();
        }

    }

    public static ConexaoES getInstance() {
        return instance;
    }

    public boolean add(Map<String, Object> values, String indice, String table, String id) throws IOException {

        XContentBuilder startObject = jsonBuilder().startObject();

        for (Map.Entry<String, Object> en : values.entrySet()) {
            startObject.field(en.getKey(), en.getValue());
        }
        startObject.endObject();

        if (id != null) {
            IndexResponse response = client.prepareIndex(indice, table, id + "")
                    .setSource(startObject)
                    .get();
        } else {
            IndexResponse response = client.prepareIndex(indice, table)
                    .setSource(startObject)
                    .get();
        }

        return true;
    }

    public Map<String, Object> get(String indice, String table, String id) throws IOException {
        GetResponse response = client.prepareGet(indice, table, id)
                .setOperationThreaded(false)
                .get();

        Map<String, Object> source = response.getSource();

        return source;
    }

    public boolean delete(String indice, String table, String id) {
        DeleteRequest deleteRequest = new DeleteRequest(indice, table, id);
        client.delete(deleteRequest);
        return true;
    }

    public SearchHits matchQuery(String indice, String table, String field, String value) {

        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(field, value);

        SearchResponse response = client.prepareSearch(indice).setTypes(table) //
                .setQuery(matchQuery) // Query
                .execute().actionGet();

        SearchHits hits = response.getHits();

        return hits;
    }

    public SearchHits boolQuery(String indice, String table, ArrayList<Range> arrayRange) {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (arrayRange != null) {
            
            for (Range r : arrayRange) {

                ArrayList<String> conteudo = r.getConteudo();

                for (String c : conteudo) {
                    //boolQuery.must(QueryBuilders.matchQuery(r.getAtributo(), c));
                    boolQuery = boolQuery.must(new TermQueryBuilder(r.getAtributo(), c));
                }
                
            }
            
        } else {
            boolQuery = boolQuery.must(new MatchAllQueryBuilder());
        }

        SearchResponse response = client.prepareSearch(indice).setTypes(table) //
                .setQuery(boolQuery) // Query
                .execute().actionGet();

        SearchHits hits = response.getHits();

        return hits;

    }
}
