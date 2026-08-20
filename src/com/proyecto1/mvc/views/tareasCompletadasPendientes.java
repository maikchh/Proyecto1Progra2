package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class tareasCompletadasPendientes extends JPanel {
	public JComboBox cbxCategTareaP;
	public JTable table;
	public JButton btnNueva;
	public JButton btnEditar;
	public JButton btnCompletada;
	public JButton btnEliminar;
	public JButton btnCargar;
	public JLabel lblVarCategoria;

	/**
	 * Create the panel.
	 */
	public tareasCompletadasPendientes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(20, 20));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel_1.add(lblCategoria);
		
		cbxCategTareaP = new JComboBox();
		cbxCategTareaP.setPreferredSize(new Dimension(180, 20));
		panel_1.add(cbxCategTareaP);
		
		btnCargar = new JButton("Cargar");
		panel_1.add(btnCargar);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva");
		panel_3.add(btnNueva);
		
		btnEditar = new JButton("Editar");
		panel_3.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);
		
		btnCompletada = new JButton("Completada");
		panel_3.add(btnCompletada);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblCategoria_1 = new JLabel("Categoria:");
		panel_4.add(lblCategoria_1);
		
		lblVarCategoria = new JLabel(" universidad");
		panel_4.add(lblVarCategoria);

	}

}
