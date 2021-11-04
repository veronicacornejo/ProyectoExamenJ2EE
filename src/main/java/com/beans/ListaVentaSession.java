/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package com.beans;

import com.model.Producto;
import com.model.Venta;
import jakarta.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Verito
 */
@Singleton
public class ListaVentaSession implements ListaVentaSessionLocal {

    private List<Venta> ventas = new LinkedList();

    @Override
    public void agregarVenta(Venta e) {
        ventas.add(e);
    }

    @Override
    public String obtenerVentas() {
        int total = 0;
        String cad = "<tbody>";
        for (Venta v : ventas) {
            for (Producto p : v.getProductos(v.getNit())) {
                cad += "				      <tr>\r\n"
                        + "				        <td>" + v.getFecha() + "</td>\r\n"
                        + "				        <td>" + v.getNit() + "</td>\r\n"
                        + "				        <td>" + v.getCliente() + "</td>\r\n";
                cad += "				        <td>" + p.getNombre() + "</td>\r\n"
                        + "				        <td>" + p.getPrecio() + "</td>\r\n"
                        + "				        <td>" + p.getCantidad() + "</td>\r\n"
                        + "				        <td>" + (p.getPrecio() * p.getCantidad()) + "</td>\r\n"
                        + "				      </tr>";
            }
            cad += "<tr>\n"
                    + "				        <td colspan=\"6\" align=\"right\"><b>SubTotal</b></td>\n"
                    + "				        <td><b>" + v.obtenerTotal() + "</b></td>\n"
                    + "				      </tr>";
            total += v.obtenerTotal();
        }
        cad += "<tr>\n"
                + "				        <td colspan=\"6\" align=\"right\"><b>Total</b></td>\n"
                + "				        <td><b>" + total + "</b></td>\n"
                + "				      </tr></tbody>";
        return cad;
    }
    
    @Override
    public String obtenerVentasSP() {
        int total = 0;
        String cad = "<tbody>";
        for (Venta v : ventas) {
            
                cad += "				      <tr>\r\n"
                        + "				        <td>" + v.getFecha() + "</td>\r\n"
                        + "				        <td>" + v.getNit() + "</td>\r\n"
                        + "				        <td>" + v.getCliente() + "</td>\r\n";
                cad += v.getProductosSV()
                        + "				      </tr>";
           
            cad += "<tr>\n"
                    + "				        <td colspan=\"6\" align=\"right\"><b>SubTotal</b></td>\n"
                    + "				        <td><b>" + v.getTotal() + "</b></td>\n"
                    + "				      </tr>";
            total += v.getTotal();
        }
        cad += "<tr>\n"
                + "				        <td colspan=\"6\" align=\"right\"><b>Total</b></td>\n"
                + "				        <td><b>" + total + "</b></td>\n"
                + "				      </tr></tbody>";
        return cad;
    }

    @Override
    public void agregarVenta(int nit, String cliente, List<Producto> product, String fecha, String prods, int tot) {
        Venta ven = new Venta(nit, cliente, product, fecha, prods, tot);
        this.ventas.add(ven);
    }

    @Override
    public List<Producto> obtenerProductosLC(int nit) {
        List<Producto> prods = new LinkedList();
        for (Venta v : ventas) {
            if (v.getNit() == nit) {
                prods = v.getProductosV();
            }
        }
        return prods;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Venta> obtenerVentasL() {
        return ventas;
    }
    @Override
    public String toString() {
        String cad="";
        for (Venta v : ventas) {
            cad += v.toString()+" "+ v.getProductosV().toString();
            }
        return cad;
    }
      
}
