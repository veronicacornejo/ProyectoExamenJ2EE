/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package com.beans;

import com.model.Producto;
import jakarta.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Verito
 */
@Singleton
public class ListaProductosSession implements ListaProductosSessionLocal {

    private List<Producto> productos = new LinkedList();

    /**
     * Default constructor.
     */
    public ListaProductosSession() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void agregarProducto(Producto e) {
        productos.add(e);
    }

    @Override
    public void agregarProducto(String prod, int precio, int cant) {
        Producto pro = new Producto(prod, precio, cant);
        this.productos.add(pro);

    }

    @Override
    public String obtenerProductos() {
        String cad = "<tbody>";

        for (Producto p : productos) {
            cad += "				      <tr>\r\n"
                    + "				        <td>" + p.getNombre() + "</td>\r\n"
                    + "				        <td>" + p.getPrecio() + "</td>\r\n"
                    + "				        <td>" + p.getCantidad() + "</td>\r\n"
                    + "				        <td>" + (p.getPrecio() * p.getCantidad()) + "</td>\r\n"
                    + "				      </tr>";
        }

        cad += "</tbody>";
        return cad;
    }
    
    @Override
    public String obtenerProductosV() {
        String cad = "<tbody>";

        for (Producto p : productos) {
            cad +="<tr>	<td colspan=3></td>			        <td>" + p.getNombre() + "</td>\r\n"
                    + "				        <td>" + p.getPrecio() + "</td>\r\n"
                    + "				        <td>" + p.getCantidad() + "</td>\r\n"
                    + "				        <td>" + (p.getPrecio() * p.getCantidad()) + "</td></tr>\r\n";
        }

        cad += "</tbody>";
        return cad;
    }
    
    @Override
    public List<Producto> obtenerProductosL() {
        return productos;
    }

    @Override
    public void vaciarProductos() {
        productos.clear();
    }
    @Override
    public int sumarProductos() {
        int suma = 0;
        for (Producto p : productos) {
            suma += (p.getPrecio() * p.getCantidad());
        }
        return suma;
    }
    @Override
    public String toString() {
        String cad="";
        for(Producto p : productos) {
            cad += p.toString()+"  ";
            }
        return cad;
    }
}
