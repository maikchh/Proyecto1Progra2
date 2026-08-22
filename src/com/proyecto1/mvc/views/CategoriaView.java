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
import javax.swing.UIManager;

public class CategoriaView extends JPanel {
	public JButton btnNueva;
	public JButton btnEditar;
	public JButton btnEliminar;
	public DefaultTableModel model;
	private JTable table;

	
	public CategoriaView() {
		setLayout(new BorderLayout(0, 0));
		this.setBackground(new Color(18, 19, 42));
		
		JScrollPane scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		table.getTableHeader().setFont(new Font("Yu Gothic", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(UIManager.getColor("Tree.hash"));
		FlowLayout flowLayout = (FlowLayout) buttonsPanel.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonsPanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		add(buttonsPanel, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva");
		btnNueva.setForeground(Color.WHITE);
		btnNueva.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnNueva.setBackground(new Color(46, 53, 50));
		buttonsPanel.add(btnNueva);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnEditar.setBackground(new Color(46, 53, 50));
		buttonsPanel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Yu Gothic", Font.BOLD, 26));
		btnEliminar.setBackground(new Color(46, 53, 50));
		buttonsPanel.add(btnEliminar);
	}

	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE"};
	}
	
	public Object[][] getData(/*AQUI VA EL ARRAYLIST DE CATEGORIA*/){
		
		Object[][] data = new Object[5][getColumns().length];
		return data;
	}
}
