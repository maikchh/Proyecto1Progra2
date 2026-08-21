package com.proyecto1.mvc.models;

public class Categoria implements Entidad{

	private static int contador = 1;
	private int id;
	private String nombre;
	public Categoria( String nombre) {
		super();
		this.id = contador++;
		this.nombre = nombre;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Categoria.contador = contador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void update(Entidad nueva) {
        Categoria c = (Categoria) nueva; 
        this.nombre = c.getNombre(); 
    }
	
	
	
	
}
