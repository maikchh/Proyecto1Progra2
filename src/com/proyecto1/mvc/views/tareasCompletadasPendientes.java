package com.proyecto1.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class tareasCompletadasPendientes extends JPanel {
	public JComboBox cbxCategTareaP;
	public JTable table;
	public JButton btnNueva;
	public JButton btnEditar;
	public JButton btnCompletada;
	public JButton btnEliminar;
	public JButton btnCargar;
	public JLabel lblVarCategoria;
	public JPanel buttonsPanel;
	public DefaultTableModel model;

	
	public tareasCompletadasPendientes() {
		setLayout(new BorderLayout(0, 0));
		this.setBackground(new Color(18, 19, 42));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(20, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(30, 50, 0, 0));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		panel_1.add(lblCategoria);
		
		cbxCategTareaP = new JComboBox();
		cbxCategTareaP.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		cbxCategTareaP.setPreferredSize(new Dimension(190, 30));
		panel_1.add(cbxCategTareaP);
		
		btnCargar = new JButton("Cargar");
		btnCargar.setBackground(new Color(46, 53, 50));
		btnCargar.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		panel_1.add(btnCargar);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		table.getTableHeader().setFont(new Font("Yu Gothic", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
		FlowLayout fl_buttonsPanel = (FlowLayout) buttonsPanel.getLayout();
		fl_buttonsPanel.setHgap(10);
		panel_2.add(buttonsPanel, BorderLayout.SOUTH);
		
		btnNueva = new JButton("Nueva");
		btnNueva.setForeground(Color.WHITE);
		btnNueva.setBackground(new Color(46, 53, 50));
		btnNueva.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		buttonsPanel.add(btnNueva);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(46, 53, 50));
		btnEditar.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		buttonsPanel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(46, 53, 50));
		btnEliminar.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		buttonsPanel.add(btnEliminar);
		
		btnCompletada = new JButton("Completada");
		btnCompletada.setBackground(new Color(46, 53, 50));
		btnCompletada.setForeground(Color.WHITE);
		btnCompletada.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		buttonsPanel.add(btnCompletada);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(5, 50, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblCategoria_1 = new JLabel("Categoria:");
		lblCategoria_1.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		panel_4.add(lblCategoria_1);
		
		lblVarCategoria = new JLabel(" Universidad");
		lblVarCategoria.setFont(new Font("Yu Gothic", Font.BOLD, 23));
		panel_4.add(lblVarCategoria);

	}
	
	public String[] getColumns() {
		return new String[] {"ID", "NOMBRE", "DESCRIPCION"};
	}
	
	public Object[][] getData(/*AQUI VA EL ARRAYLIST CORRESPONDIENTE*/){
		
		Object[][] data = new Object[5][getColumns().length];
		return data;
	}

}
