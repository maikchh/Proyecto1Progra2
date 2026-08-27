package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class tareasRegistrarEditar extends JPanel {
	public JPanel buttonsPanel;
	public JPanel formPanel;
	public JButton btnGuardar;
	public JButton btnRegresar;
	public JPanel panelNombre;
	public JPanel panelDescripcion;
	public JPanel panelCategoria;
	public JLabel lblNombre;
	public JLabel lblDescripcin;
	public JLabel lblCategoria;
	public JTextField txtDescripcion;
	public JComboBox cbCategoria;
	public JTextField txtName;

	/**
	 * Create the panel.
	 */
	public tareasRegistrarEditar() {
		this.setBackground(new Color(18, 19, 42));
		setLayout(new BorderLayout(0, 0));
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		FlowLayout flowLayout = (FlowLayout) buttonsPanel.getLayout();
		flowLayout.setHgap(20);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(46, 53, 50));
		btnGuardar.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		buttonsPanel.add(btnGuardar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(new Color(46, 53, 50));
		btnRegresar.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		buttonsPanel.add(btnRegresar);
		
		formPanel = new JPanel();
		formPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		panelNombre = new JPanel();
		panelNombre.setBorder(new EmptyBorder(50, 50, 50, 50));
		formPanel.add(panelNombre);
		panelNombre.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelNombre.add(lblNombre);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelNombre.add(txtName);
		txtName.setColumns(10);
		
		panelDescripcion = new JPanel();
		panelDescripcion.setBorder(new EmptyBorder(50, 50, 50, 50));
		formPanel.add(panelDescripcion);
		panelDescripcion.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblDescripcin = new JLabel("Descripci\u00F3n");
		panelDescripcion.add(lblDescripcin);
		lblDescripcin.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelDescripcion.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		panelCategoria = new JPanel();
		panelCategoria.setBorder(new EmptyBorder(50, 50, 50, 50));
		formPanel.add(panelCategoria);
		panelCategoria.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelCategoria.add(lblCategoria);
		
		cbCategoria = new JComboBox();
		cbCategoria.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		panelCategoria.add(cbCategoria );

	}
}
