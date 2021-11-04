/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Verito
 */
public class Venta implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int nit;
    private String cliente;
    private List<Producto> productosV = new LinkedList();
    private String fecha;
    private String productosSV;
    private int total;

    public String getProductosSV() {
        return productosSV;
    }

    public void setProductosSV(String productosSV) {
        this.productosSV = productosSV;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Venta(int nit, String cliente, List<Producto> productos, String fecha, String prod, int tot) {
        super();
        this.nit = nit;
        this.cliente = cliente;
        this.setProductosV(productos);
        this.fecha = fecha;
        this.productosSV = prod;
        this.total = tot;
    }

    public List<Producto> getProductos(int nit) {
        if (this.nit == nit) {
            return productosV;
        } else {
            return null;
        }
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductosV() {
        return productosV;
    }

    public void setProductosV(List<Producto> productosV) {
        this.productosV = productosV;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int obtenerTotal() {
        int suma = 0;
        for (Producto p : productosV) {
            suma += (p.getPrecio() * p.getCantidad());
        }
        return suma;
    }
    
    @Override
    public String toString() {
        String cad="";
        cad +=fecha+"   "+nit+"    "+cliente+"     "+productosV.toString();
        
        return cad;
    }
}
