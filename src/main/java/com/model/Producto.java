/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Verito
 */
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String nombre;
	private int precio;
	private int cantidad;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, int precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
        
        @Override
        public String toString() { 
            String cad="";
		cad += nombre+"   "+precio+" "+cantidad+ "   "+(precio*cantidad);
            return cad;
	}
}
