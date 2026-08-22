package com.proyecto1.mvc.models;

public class Tarea implements Entidad {
	private static int contador = 1;
	private int id;
	private String nombre;
	private String descripcion;
	private boolean estado;
	private int idCategoria;
	
	
	
	
	public Tarea(String nombre, String descripcion, boolean estado, int idCategoria) {
		
		this.id = contador++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idCategoria = idCategoria;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Tarea.contador = contador;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String conversorBooleanAString() { 
		if(isEstado() == true) {
			return "Completada";
		}
		
		return "Pendiente";
	}
	
	
	//Este metodo sobre escribe el metodo que le manda la interface y lo utiliza.
	@Override
	public void update(Entidad nueva) {
        Tarea t = (Tarea) nueva; 
        this.nombre = t.getNombre();
        this.descripcion = t.getDescripcion();
        this.estado = t.isEstado();
        this.idCategoria = t.getIdCategoria();
    }
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", idCategoria=" + idCategoria + "]";
	}
	
}
