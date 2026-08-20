package com.proyecto1.mvc.models;

import java.util.ArrayList;

public class Almacenamiento <T extends Entidad>{

	private ArrayList<T> lista;

	public Almacenamiento(ArrayList<T> lista) {
		this.lista = lista;
	}
	
	public void store(T item) {
		lista.add(item);
	}

	public void update(T updated, int id) {

		T item = find(id);

		if(item != null) {
			item.update(updated);
		}

	}

	public void destroy(int id) {
		T item = find(id);

		if(item != null) {
			lista.remove(item);
		}

	}


	public T find(int id) {

		return lista
				.stream()
				.filter(v ->v.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public ArrayList<T> all(){
		return lista;
	}



	public String toString() {

		String data = "";

		for (T item : lista) {
			data += item + "\n";
		}

		return data;

	}
	
}
