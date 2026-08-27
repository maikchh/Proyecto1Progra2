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
	private int estadoActual = 0;
	
	public TareasController(ViewPrincipal vp, Almacenamiento<Tarea> listaTareas, Almacenamiento<Categoria> listaCategorias) {
		tcp = new tareasCompletadasPendientes();
		this.vp = vp;
		this.listaTareas = listaTareas;
		this.listaCategorias = listaCategorias;
	}
		
	/*
	 *VISTAS 
	 */
	
	public void init() {
		index();
	}
	
	
	public void index() {
		estadoActual = 0;
		llenarComboBox(tcp.cbxCategTareaP);
		tcp.buttonsPanel.setVisible(true);
		actualizarTablaTareas();
		initTareasEventos();
		vp.setContent(tcp, "Tareas - Pendientes");
		
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
	}
	
	
	public void create() {
		tareasRegistrarEditar tre = new tareasRegistrarEditar();
		llenarComboBox(tre.cbCategoria);
		vp.setContent(tre, "Tareas - Registrar/Editar");
		
		tre.btnGuardar.addActionListener(e->{
			/*
			 *FALTA TERMINAR 
			 */
			/*String nombre = tre.txtName.getText();
			String descripcion = tre.txtDescripcion.getText();
			Categoria item = listaCategorias.find(id)
			int idCategoria =;*/
		});
		
		tre.btnRegresar.addActionListener(e->{
			vp.setContent(tcp, "Tareas - Pendientes");
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
	
	private void actualizarTablaTareas() {
		String categoria = (String) tcp.cbxCategTareaP.getSelectedItem();
		if (categoria != null) {
			int idCategoria = buscarCategoria(categoria);
			tcp.model.setDataVector(tcp.getData(listaTareas.all(), estadoActual, idCategoria), tcp.getColumns());
		}
	}

	public void llenarComboBox(JComboBox item) {
		item.removeAllItems();
		for(Categoria c: listaCategorias.all()) {
			item.addItem(c.getNombre());
		}
	}
	
	
	public int buscarCategoria(String nombre) {
		int id = -1;
		ArrayList<Categoria> categorias = listaCategorias.all();
		for(Categoria c: categorias) {

			if(c.getNombre().equalsIgnoreCase(nombre)) {
				id= c.getId();
				return id;
			}
		}
		return id;
	}
	
	public void initTareasEventos() {
		tcp.cbxCategTareaP.addActionListener(e -> {
			if (tcp.cbxCategTareaP.getSelectedIndex() != -1) {
				actualizarTablaTareas();
			}
		});
	}
	
	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE", "DESCRIPCION"};
	}

	public Object[][] getData(int estado, int categoria){
		ArrayList<Tarea> listaTareas = tcp.filtrarTareas(this.listaTareas.all(),  estado,  categoria);
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
	
	public void refrestTableComplete() {
		estadoActual = 1;
		llenarComboBox(tcp.cbxCategTareaP);
		tcp.buttonsPanel.setVisible(false);
		actualizarTablaTareas();
		initTareasEventos();
		vp.setContent(tcp, "Tareas - Completadas");
	}
	
	
}
