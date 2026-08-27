package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class CategoriaRegitsrarEdit extends JPanel {
	public JTextField txtNombreCategoria;
	public JButton btnGuardar;
	public JButton btnRegresar;

	
	public CategoriaRegitsrarEdit() {
		setLayout(null);
		//this.setBackground(new Color(18, 19, 42));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		lblNombre.setBounds(181, 100, 265, 30);
		add(lblNombre);
		
		txtNombreCategoria = new JTextField();
		txtNombreCategoria.setBounds(178, 168, 646, 46);
		add(txtNombreCategoria);
		txtNombreCategoria.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(46, 53, 50));
		btnGuardar.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		btnGuardar.setBounds(275, 273, 171, 38);
		add(btnGuardar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(new Color(46, 53, 50));
		btnRegresar.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		btnRegresar.setBounds(538, 273, 171, 38);
		add(btnRegresar);

	}
	
	public void cls() {
		txtNombreCategoria.setText(null);
	}
}
