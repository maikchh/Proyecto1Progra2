package com.proyecto1.mvc.models;

public interface Entidad {
	
	/*Esta interface es para poder utilizar el
	 * almacenamiento generico, trae el metodo de getId necesario para el find
	 * y el update necesario para el update de cada clase, aunque solo vamos a 
	 * modificar la tarea creo*/
	int getId();
	
	
	void update(Entidad nueva);
}
