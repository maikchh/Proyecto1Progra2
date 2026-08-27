package com.proyecto1.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.proyecto1.mvc.models.Almacenamiento;
import com.proyecto1.mvc.models.Categoria;
import com.proyecto1.mvc.views.CategoriaRegitsrarEdit;
import com.proyecto1.mvc.views.CategoriaView;
import com.proyecto1.mvc.views.ViewPrincipal;


public class CategoriaController extends Functions {
	
	private CategoriaView cv;
	private ViewPrincipal vp;
	private Almacenamiento<Categoria> listaCategorias;


	public CategoriaController(ViewPrincipal vp, Almacenamiento<Categoria> listaCategorias) {
		cv = new CategoriaView();
		this.vp = vp;
		this.listaCategorias = listaCategorias;
	}
	
	public void init() {
		index();
	}
	
	public void index() {
		vp.setContent(cv, "Categorias - Listas");
		cv.model.setDataVector(getData(), getColumns());
		
		cv.btnNueva.addActionListener(e->{
			create();
			
		});

		cv.btnEditar.addActionListener(e->{
			int id = getSelectedID(cv.table);
			if(id > 0) {
				edit(id);
			}
		});
		
		cv.btnEliminar.addActionListener(e->{
			int id = getSelectedID(cv.table);
			if(id > 0) {
				int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?");
				if(option == 0) {
					listaCategorias.destroy(id);
					index();
				}
			}
		});
	}
	
	
	public void create() {
		CategoriaRegitsrarEdit cre = new CategoriaRegitsrarEdit();
		vp.setContent(cre, "Categorias - Registrar/Editar");
		
		cre.btnGuardar.addActionListener(e->{
			String name = cre.txtNombreCategoria.getText();
			listaCategorias.store(new Categoria(name));
			
			index();
		});
		
		cre.btnRegresar.addActionListener(e->{
			vp.setContent(cv, "Categorias - Listas");
		});
	}
	
	
	public void edit(int id) {
		CategoriaRegitsrarEdit cre = new CategoriaRegitsrarEdit();
		vp.setContent(cre, "Categorias - Registrar/Editar");
		
		Categoria item = listaCategorias.find(id);
		cre.txtNombreCategoria.setText(item.getNombre());
		
		cre.btnGuardar.addActionListener(e->{
			String name = cre.txtNombreCategoria.getText();
			Categoria updated = new Categoria(name);
			listaCategorias.update(updated, id);
			index();
		});
		
		cre.btnRegresar.addActionListener(e->{
			vp.setContent(cv, "Categorias - Listas");
		});
	}
	
	
	
	
	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE"};
	}
	
	public Object[][] getData(){
		
		Object[][] data = new Object[listaCategorias.all().size()][getColumns().length];
		int i = 0;
		for(Categoria item : listaCategorias.all()) {
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			i++;
		}
		return data;
	}

}
