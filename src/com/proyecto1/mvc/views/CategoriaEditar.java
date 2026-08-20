package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

public class CategoriaEditar extends JPanel {
	
	public JTextField txtNombre;
	public JLabel lblNombre;
	public JButton btnGuardar;
	public JButton btnRegresar;

	
	public CategoriaEditar() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setHgap(20);
		panelButtons.setBorder(new EmptyBorder(100, 0, 100, 0));
		add(panelButtons, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(46, 53, 50));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelButtons.add(btnGuardar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBackground(new Color(46, 53, 50));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelButtons.add(btnRegresar);
		
		JPanel panelForm = new JPanel();
		panelForm.setBorder(new EmptyBorder(140, 140, 140, 140));
		add(panelForm, BorderLayout.CENTER);
		panelForm.setLayout(new GridLayout(2, 1, 0, 15));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		panelForm.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setPreferredSize(new Dimension(0, 20));
		txtNombre.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		panelForm.add(txtNombre);
		txtNombre.setColumns(5);

	}

}
