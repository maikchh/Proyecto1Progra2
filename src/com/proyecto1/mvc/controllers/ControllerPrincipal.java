package com.proyecto1.mvc.controllers;

import com.proyecto1.mvc.views.CategoriaEditar;
import com.proyecto1.mvc.views.CategoriaView;
import com.proyecto1.mvc.views.ViewPrincipal;
import com.proyecto1.mvc.views.tareasCompletadasPendientes;
import com.proyecto1.mvc.views.tareasRegistrarEditar;

public class ControllerPrincipal {
	
	private ViewPrincipal vp;
	private CategoriaView cv;
	private tareasCompletadasPendientes tcp;
	private tareasRegistrarEditar tre;
	private CategoriaEditar ce;
	
	public ControllerPrincipal() {
		 vp = new ViewPrincipal();
		 cv = new CategoriaView();
		 tcp = new tareasCompletadasPendientes();
		 tre = new tareasRegistrarEditar();
		 ce = new CategoriaEditar();
	}
	
	public void starting() {
		vp.init();
		principalButtons();
		tareasButtons();
		categoriasButtons();
	}
	
	
	public void principalButtons() {
		vp.btnCategorias.addActionListener(e->{
			vp.setContent(cv, "Categorias - Listas");
			cv.model.setDataVector(cv.getData(), cv.getColumns());
		});
		
		vp.btnTareasPendientes.addActionListener(e->{
			tcp.buttonsPanel.setVisible(true);
			vp.setContent(tcp, "Tareas - Pendientes");
		});
		
		vp.btnTareasCompletadas.addActionListener(e->{
			tcp.buttonsPanel.setVisible(false);
			tcp.model.setDataVector(tcp.getData(), tcp.getColumns());
			vp.setContent(tcp, "Tareas Completadas");
			
		});
	}

	
	public void tareasButtons() {
		tcp.btnNueva.addActionListener(e->{
			vp.setContent(tre, "Tareas - Registrar/Editar");
		});
		
		tcp.btnEditar.addActionListener(e->{
			vp.setContent(tre, "Tareas - Registrar/Editar");
		});
		
		tre.btnRegresar.addActionListener(e->{
			vp.setContent(tcp, "Tareas - Pendientes");
		});
	}
	
	
	public void categoriasButtons() {
		cv.btnNueva.addActionListener(e->{
			vp.setContent(ce, "Categorias - Registrar/Editar");
		});
		
		cv.btnEditar.addActionListener(e->{
			vp.setContent(ce, "Categorias - Registrar/Editar");
		});
		
		ce.btnRegresar.addActionListener(e->{
			vp.setContent(cv, "Categorias - Listas");
		});
	}
}
