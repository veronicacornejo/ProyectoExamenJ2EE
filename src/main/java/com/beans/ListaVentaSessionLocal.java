/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.beans;

import com.model.Producto;
import com.model.Venta;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Verito
 */
@Local
public interface ListaVentaSessionLocal {
    
    public void agregarVenta(Venta e);

    public String obtenerVentas();
    
    public String obtenerVentasSP();

    public void agregarVenta(int nit, String cliente, List<Producto> productos, String fecha, String prods, int tot);
    
    public List<Venta> obtenerVentasL();
    
    public List<Producto> obtenerProductosLC(int nit);
    
    @Override
    public String toString();
    
}