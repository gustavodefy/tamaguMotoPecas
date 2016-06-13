/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.dao.elastic;

import br.com.tmgmotopeca.biblioteca.ConexaoES;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ResVUT42
 */
public class GerarNewId {

    private static GerarNewId instance = new GerarNewId();

    private AtomicInteger count = null;
    private ConexaoES conexaoES = null;

    private GerarNewId() {
        conexaoES = ConexaoES.getInstance();

        try {

            Map<String, Object> map = conexaoES.get("motopeca", "contador", "1");
            if (map != null) {
                this.count = new AtomicInteger(Integer.parseInt(map.get("lastValue").toString()));
            } else {
                this.count = new AtomicInteger(1);
            }
        } catch (IOException ex) {
            Logger.getLogger(GerarNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized int getNextNumber() {
       
        int newValue = this.count.incrementAndGet();
        
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("lastValue", newValue);
        try {
            conexaoES.add(map, "motopeca", "contador", "1");
        } catch (IOException ex) {
            Logger.getLogger(GerarNewId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newValue;
    }

    public static GerarNewId getInstance() {
        return instance;
    }

}
