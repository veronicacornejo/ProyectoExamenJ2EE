/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.beans;

import com.model.Producto;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Verito
 */
@Local
public interface ListaProductosSessionLocal {

    public void agregarProducto(Producto e);

    public String obtenerProductos();

    public void agregarProducto(String prod, int precio, int cant);
    
    public void vaciarProductos();
    
    public List<Producto> obtenerProductosL();
    
    public String obtenerProductosV();
    
    public int sumarProductos();
    
    @Override
    public String toString();

}
