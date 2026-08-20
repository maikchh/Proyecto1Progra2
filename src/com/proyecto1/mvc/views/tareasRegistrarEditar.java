package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class tareasRegistrarEditar extends JPanel {
	
	public JTextField tNombreTareas;
	public JTextField tDescripcionTareas;
	public JButton btnGuardarTareas;
	public JButton btnRegresarTareas;
	public JComboBox cbxCategTareasR;

	/**
	 * Create the panel.
	 */
	public tareasRegistrarEditar() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 24, 56, 16);
		add(lblNombre);
		
		tNombreTareas = new JTextField();
		tNombreTareas.setBounds(43, 53, 303, 22);
		add(tNombreTareas);
		tNombreTareas.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(43, 88, 73, 16);
		add(lblDescripcion);
		
		tDescripcionTareas = new JTextField();
		tDescripcionTareas.setBounds(43, 117, 303, 61);
		add(tDescripcionTareas);
		tDescripcionTareas.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(43, 191, 56, 16);
		add(lblCategoria);
		
		cbxCategTareasR = new JComboBox();
		cbxCategTareasR.setBounds(43, 218, 303, 22);
		add(cbxCategTareasR);
		
		btnGuardarTareas = new JButton("Guardar");
		btnGuardarTareas.setBounds(43, 253, 97, 25);
		add(btnGuardarTareas);
		
		btnRegresarTareas = new JButton("Regresar");
		btnRegresarTareas.setBounds(152, 253, 97, 25);
		add(btnRegresarTareas);

	}
}
