/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tmgmotopeca.modelo;

import java.util.ArrayList;

/**
 *
 * @author ResVUT42
 */
public class PedidoCompra {
 
    private PCHeader pcHeader;
    private ArrayList<PCItem> arrayPCItem;

    
    public PedidoCompra() {
        pcHeader = new PCHeader();
        arrayPCItem = new ArrayList<PCItem>();
    }

    public PCHeader getPCHeader() {
        return pcHeader;
    }

    public void setPCHeader(PCHeader pcHeader) {
        this.pcHeader = pcHeader;
    }

    public ArrayList<PCItem> getArrayPCItem() {
        return arrayPCItem;
    }

    public void setArrayPCItem(ArrayList<PCItem> arrayPCItem) {
        this.arrayPCItem = arrayPCItem;
    }
        
    public void addPCItem(PCItem pcItem){
        arrayPCItem.add(pcItem);    
    }
    
}
