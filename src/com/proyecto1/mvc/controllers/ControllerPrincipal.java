package com.proyecto1.mvc.controllers;

import java.util.ArrayList;

import com.proyecto1.mvc.models.Almacenamiento;
import com.proyecto1.mvc.models.Categoria;
import com.proyecto1.mvc.models.Tarea;
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
	private Almacenamiento<Categoria> listaCategorias;
	private Almacenamiento<Tarea> listaTareas;
	private int estadoActual = 0;

	public ControllerPrincipal() {
		vp = new ViewPrincipal();
		cv = new CategoriaView();
		tcp = new tareasCompletadasPendientes();
		tre = new tareasRegistrarEditar();
		ce = new CategoriaEditar();

		listaCategorias = new Almacenamiento<>(new ArrayList<>());
		listaTareas = new Almacenamiento<>(new ArrayList<>());
	
	}

	public void starting() {
		loadData();
		initTareasEventos();
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
			estadoActual = 0;
			refrescarComboBox();
			tcp.buttonsPanel.setVisible(true);
			actualizarTablaTareas();
			vp.setContent(tcp, "Tareas - Pendientes");
		});

		vp.btnTareasCompletadas.addActionListener(e->{
			estadoActual = 1;
			refrescarComboBox();
			tcp.buttonsPanel.setVisible(false);
			actualizarTablaTareas();
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
	private void actualizarTablaTareas() {
		String categoria = (String) tcp.cbxCategTareaP.getSelectedItem();
		if (categoria != null) {
			int idCategoria = buscarCategoria(categoria);
			tcp.model.setDataVector(tcp.getData(listaTareas.all(), estadoActual, idCategoria), tcp.getColumns());
		}
	}
	public void initTareasEventos() {
		
		tcp.cbxCategTareaP.addActionListener(e -> {
			if (tcp.cbxCategTareaP.getSelectedIndex() != -1) {
				actualizarTablaTareas();
			}
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
	private void loadData() {
		// 1. Crear y almacenar 5 Categorías (IDs del 1 al 5)
	    listaCategorias.store(new Categoria("Trabajo"));
	    listaCategorias.store(new Categoria("Estudio"));
	    listaCategorias.store(new Categoria("Hogar"));
	    listaCategorias.store(new Categoria("Personal"));
	    listaCategorias.store(new Categoria("Proyectos"));

	    // --- CATEGORÍA 1: Trabajo ---
	    listaTareas.store(new Tarea("Revisar correos", "Bandeja de entrada principal", true, 1));
	    listaTareas.store(new Tarea("Reunión de equipo", "Planeación semanal del sprint", false, 1));
	    listaTareas.store(new Tarea("Actualizar reportes", "Informes de rendimiento mensual", true, 1));
	    listaTareas.store(new Tarea("Responder clientes", "Atender dudas sobre facturación", false, 1));
	    listaTareas.store(new Tarea("Planificar objetivos", "Metas para el próximo trimestre", false, 1));
	    listaTareas.store(new Tarea("Auditoría interna", "Revisar procesos del departamento", true, 1));
	    listaTareas.store(new Tarea("Firmar contratos", "Documentación con proveedores", false, 1));
	    listaTareas.store(new Tarea("Evaluación de personal", "Revisión de desempeño anual", true, 1));
	    listaTareas.store(new Tarea("Respaldo de archivos", "Guardar copias de seguridad en la nube", true, 1));
	    listaTareas.store(new Tarea("Cierre de caja", "Balance general de la semana", false, 1));

	    // --- CATEGORÍA 2: Estudio ---
	    listaTareas.store(new Tarea("Estudiar Java", "Repasar patrones de diseño MVC", false, 2));
	    listaTareas.store(new Tarea("Hacer tarea de BD", "Consultas multitabla en SQL", true, 2));
	    listaTareas.store(new Tarea("Leer artículo científico", "Investigación sobre Inteligencia Artificial", false, 2));
	    listaTareas.store(new Tarea("Práctica de Swing", "Crear formularios y eventos en Java", true, 2));
	    listaTareas.store(new Tarea("Ver video tutoriales", "Aprender sobre arquitectura limpia", false, 2));
	    listaTareas.store(new Tarea("Preparar exposición", "Diapositivas para la clase de redes", true, 2));
	    listaTareas.store(new Tarea("Resolver ejercicios", "Ecuaciones diferenciales avanzadas", false, 2));
	    listaTareas.store(new Tarea("Repasar inglés", "Vocabulario técnico de programación", true, 2));
	    listaTareas.store(new Tarea("Proyecto grupal", "Unir las partes del código en equipo", false, 2));
	    listaTareas.store(new Tarea("Simulacro de examen", "Preguntas tipo test de algoritmos", true, 2));

	    // --- CATEGORÍA 3: Hogar ---
	    listaTareas.store(new Tarea("Limpiar la sala", "Aspirar alfombras y ordenar muebles", false, 3));
	    listaTareas.store(new Tarea("Hacer el súper", "Comprar verduras, leche y café", true, 3));
	    listaTareas.store(new Tarea("Lavar ropa", "Separar ropa blanca y de color", true, 3));
	    listaTareas.store(new Tarea("Cocinar almuerzo", "Preparar comida para la semana", false, 3));
	    listaTareas.store(new Tarea("Sacar la basura", "Reciclar plástico y cartón", true, 3));
	    listaTareas.store(new Tarea("Pagar servicios", "Luz, agua e internet", false, 3));
	    listaTareas.store(new Tarea("Reparar llave de agua", "Cambiar empaque del grifo de la cocina", false, 3));
	    listaTareas.store(new Tarea("Bañar al perro", "Usar shampoo especial antipulgas", true, 3));
	    listaTareas.store(new Tarea("Organizar closet", "Donar ropa que ya no se usa", false, 3));
	    listaTareas.store(new Tarea("Regar las plantas", "Jardín delantero y trasero", true, 3));

	    // --- CATEGORÍA 4: Personal ---
	    listaTareas.store(new Tarea("Ir al gimnasio", "Rutina de pierna y cardio", true, 4));
	    listaTareas.store(new Tarea("Leer un libro", "Avanzar 30 páginas de lectura", false, 4));
	    listaTareas.store(new Tarea("Cita médica", "Chequeo general anual con el doctor", false, 4));
	    listaTareas.store(new Tarea("Meditar", "Sesión de relajación de 15 minutos", true, 4));
	    listaTareas.store(new Tarea("Comprar ropa", "Renovar zapatos deportivos", false, 4));
	    listaTareas.store(new Tarea("Llamar a mamá", "Preguntar cómo ha estado", true, 4));
	    listaTareas.store(new Tarea("Cortarse el cabello", "Ir a la barbería", false, 4));
	    listaTareas.store(new Tarea("Planear fin de semana", "Organizar salida al parque", true, 4));
	    listaTareas.store(new Tarea("Beber agua", "Cumplir la meta de 2 litros diarios", true, 4));
	    listaTareas.store(new Tarea("Escribir diario", "Reflexión personal del día", false, 4));

	    // --- CATEGORÍA 5: Proyectos ---
	    listaTareas.store(new Tarea("Diseñar interfaz", "Maquetar vistas en Swing", false, 5));
	    listaTareas.store(new Tarea("Subir repositorio", "Hacer push a GitHub", true, 5));
	    listaTareas.store(new Tarea("Definir base de datos", "Crear diagrama ER y tablas", true, 5));
	    listaTareas.store(new Tarea("Escribir documentación", "Manual de usuario del sistema", false, 5));
	    listaTareas.store(new Tarea("Pruebas unitarias", "Validar métodos del modelo", false, 5));
	    listaTareas.store(new Tarea("Corregir bugs", "Revisar errores en los botones", true, 5));
	    listaTareas.store(new Tarea("Optimizar código", "Limpiar imports y refactorizar clases", false, 5));
	    listaTareas.store(new Tarea("Crear instalador", "Generar archivo ejecutable JAR", false, 5));
	    listaTareas.store(new Tarea("Presentar avance", "Mostrar prototipo al cliente", true, 5));
	    listaTareas.store(new Tarea("Definir requerimientos", "Anotar nuevas funcionalidades pedidas", true, 5));
	
	}

	public void refrescarComboBox() {
		tcp.llenarComboBox(listaCategorias.all());
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
	
	

}
