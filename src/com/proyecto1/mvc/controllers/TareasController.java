package com.proyecto1.mvc.controllers;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.proyecto1.mvc.models.Almacenamiento;
import com.proyecto1.mvc.models.Categoria;
import com.proyecto1.mvc.models.Tarea;
import com.proyecto1.mvc.views.ViewPrincipal;
import com.proyecto1.mvc.views.tareasCompletadasPendientes;
import com.proyecto1.mvc.views.tareasRegistrarEditar;

public class TareasController extends Functions{

	private tareasCompletadasPendientes tcp;
	private ViewPrincipal vp;
	private Almacenamiento<Tarea> listaTareas;
	private Almacenamiento<Categoria> listaCategorias;
	private boolean estadoActual;
	private String ultimaCatSelecionada;

	public TareasController(ViewPrincipal vp, Almacenamiento<Tarea> listaTareas, Almacenamiento<Categoria> listaCategorias, boolean estadoActual) {
		tcp = new tareasCompletadasPendientes();
		this.vp = vp;
		this.listaTareas = listaTareas;
		this.listaCategorias = listaCategorias;
		this.estadoActual = estadoActual;
	}

	/*
	 *VISTAS 
	 */

	public void init() {
		index();
	}


	public void index() {

		llenarComboBox(tcp.cbxCategTareaP);
		
		actualizarTablaTareas(ultimaCatSelecionada);

		changeWindow();

		tcp.btnNueva.addActionListener(e->{
			create();
		});

		tcp.btnEditar.addActionListener(e->{
			int id = getSelectedID(tcp.table);
			if(id > 0) {
				edit(id);
			}
		});

		tcp.btnEliminar.addActionListener(e->{
			int id = getSelectedID(tcp.table);
			if(id > 0) {
				int option = JOptionPane.showConfirmDialog(null, "Desea eliminar el registro?");
				if(option == 0) {
					listaTareas.destroy(id);
					index();
				}
			}
		});

		tcp.btnCompletada.addActionListener(e->{
			int id = getSelectedID(tcp.table);
			if(id > 0) {
				Tarea item = listaTareas.find(id);
				item.setEstado(true);
				listaTareas.update(item, id);
				index();
			}
		});

		tcp.btnCargar.addActionListener(e->{
			String categoria = (String) tcp.cbxCategTareaP.getSelectedItem();
			actualizarTablaTareas(categoria);
		});
	}


	public void create() {
		tareasRegistrarEditar tre = new tareasRegistrarEditar();
		llenarComboBox(tre.cbCategoria);
		vp.setContent(tre, "Tareas - Registrar/Editar");

		tre.btnGuardar.addActionListener(e->{

			String nombre = tre.txtName.getText();
			String descripcion = tre.txtDescripcion.getText();
			int idCategoria = getIdCategoria(tre.cbCategoria.getSelectedItem().toString());

			listaTareas.store(new Tarea(nombre, descripcion,false,idCategoria));

			index();
		});

		tre.btnRegresar.addActionListener(e->{
			changeWindow();
		});
	}

	public void edit(int id) {
		tareasRegistrarEditar tre = new tareasRegistrarEditar();
		tre.cbCategoria.setEnabled(false);;
		llenarComboBox(tre.cbCategoria);
		vp.setContent(tre, "Tareas - Registrar/Editar");

		Tarea item = listaTareas.find(id);
		tre.txtName.setText(item.getNombre());
		tre.txtDescripcion.setText(item.getDescripcion());
		Categoria selected = listaCategorias.find(item.getIdCategoria());
		tre.cbCategoria.setSelectedItem(selected.getNombre());

		tre.btnGuardar.addActionListener(e->{
			String nombre = tre.txtName.getText();
			String descripcion = tre.txtDescripcion.getText();
			boolean estado = item.getEstado();
			listaTareas.update(new Tarea(nombre, descripcion, estado, item.getIdCategoria()), id);

			index();																									
		});;

		tre.btnRegresar.addActionListener(e->{
			vp.setContent(tcp, "Tareas - Pendientes");
		});
	}

	private void actualizarTablaTareas(String categoria) {
		ultimaCatSelecionada= categoria;
		if (categoria != null) {
			tcp.model.setDataVector(getData(listaTareas.all(), estadoActual, getIdCategoria(categoria)), getColumns());
			tcp.cbxCategTareaP.setSelectedItem(categoria);
			tcp.lblVarCategoria.setText(categoria);
		}
	}

	public void llenarComboBox(JComboBox item) {
		item.removeAllItems();
		for(Categoria c: listaCategorias.all()) {
			item.addItem(c.getNombre());
		}
	}

	public int getIdCategoria(String nombre) {
		int id=-1;

		for (Categoria item:listaCategorias.all()) {
			if(item.getNombre().equals(nombre)) {
				id=item.getId();
			}

		}
		return id;
	}


	public void changeWindow() {

		if(estadoActual == false) {
			vp.setContent(tcp, "Tareas - Pendientes");
		}else {
			vp.setContent(tcp, "Tareas - Completas");
			tcp.buttonsPanel.setVisible(false);
		}
	}
	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE", "DESCRIPCION"};
	}

	public Object[][] getData(ArrayList<Tarea> tareas, boolean estado, int categoria){
		ArrayList<Tarea> listaTareas = filtrarTareas(tareas,  estado,  categoria);
		int i= 0;
		Object[][] data = new Object[listaTareas.size()][getColumns().length];
		for(Tarea item: listaTareas) {

			data[i][0]= item.getId();
			data[i][1]= item.getNombre();
			data[i][2]= item.getDescripcion();
			i++;
		}
		return data;
	}



	public ArrayList<Tarea> filtrarTareas(ArrayList<Tarea> listaTareas, boolean estado, int categoria){

		
		ArrayList<Tarea> lista = new ArrayList<>();
		
		for(Tarea item: listaTareas) {
			if(item.isEstado() == estado && item.getIdCategoria()==categoria) {

				lista.add(item);
			}
		}
		return lista;}





}
