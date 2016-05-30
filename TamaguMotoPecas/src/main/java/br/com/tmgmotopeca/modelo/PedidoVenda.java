/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ResVUT42
 */
public class PedidoVenda {
    private PVHeader header;
    private ArrayList<PVItem> item;

    public PedidoVenda() {
    }

    public PVHeader getHeader() {
        return header;
    }

    public void setHeader(PVHeader header) {
        this.header = header;
    }

    public Iterator<PVItem> getItens() {
        return item.iterator();
    }

    public void setItens(ArrayList<PVItem> item) {
        this.item = item;
    }
    
    public void addItem(PVItem item){
        this.header.setTotalPedido(this.header.getTotalPedido() + item.getVlrTotal());
        this.item.add(item);
    }
        
}
