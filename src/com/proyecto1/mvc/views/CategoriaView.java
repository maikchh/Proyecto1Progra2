package com.proyecto1.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CategoriaView extends JPanel {
	public JTable table;
	public JButton btnNueva;
	public JButton btnEditar;
	public JButton btnEliminar;
	public DefaultTableModel model;

	
	public CategoriaView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel buttonsPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonsPanel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonsPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		buttonsPanel.setBackground(Color.WHITE);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva");
		btnNueva.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnNueva.setBackground(Color.GRAY);
		buttonsPanel.add(btnNueva);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnEditar.setBackground(Color.GRAY);
		buttonsPanel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnEliminar.setBackground(Color.GRAY);
		buttonsPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		add(table, BorderLayout.CENTER);

	}

	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE"};
	}
	
	public Object[][] getData(/*AQUI VA EL ARRAYLIST DE CATEGORIA*/){
		
		return null;
	}
}
