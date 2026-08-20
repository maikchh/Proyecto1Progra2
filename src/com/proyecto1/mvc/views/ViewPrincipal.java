package com.proyecto1.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewPrincipal extends JFrame {

	public JPanel contentPane;
	public JButton btnTareasPendientes;
	public JButton btnTareasCompletadas;
	public JButton btnCategorias;
	public JPanel panelContenido;
	public JLabel lblTitulo;

	
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(18, 19, 42));
		buttonsPanel.setBorder(new EmptyBorder(20, 25, 400, 25));
		contentPane.add(buttonsPanel, BorderLayout.WEST);
		buttonsPanel.setLayout(new GridLayout(3, 1, 0, 70));
		
		btnTareasPendientes = new JButton("Tareas Pendientes");
		btnTareasPendientes.setForeground(Color.WHITE);
		btnTareasPendientes.setBackground(new Color(46, 53, 50));
		btnTareasPendientes.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		buttonsPanel.add(btnTareasPendientes);
		
		btnTareasCompletadas = new JButton("Tareas Completadas");
		btnTareasCompletadas.setForeground(Color.WHITE);
		btnTareasCompletadas.setBackground(new Color(46, 53, 50));
		btnTareasCompletadas.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		buttonsPanel.add(btnTareasCompletadas);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setForeground(Color.WHITE);
		btnCategorias.setBackground(new Color(46, 53, 50));
		btnCategorias.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		buttonsPanel.add(btnCategorias);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(25, 25, 25, 25));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblTitulo = new JLabel("Sistema Gestor de Tareas");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		panel_1.add(lblTitulo);
		
		panelContenido = new JPanel();
		panel.add(panelContenido, BorderLayout.CENTER);
		panelContenido.setLayout(new BorderLayout(0, 0));
	}
	
	
	public void init() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema Gestor de Tareas");
	}
	
	public void setContent(JComponent c, String tittle) {
		panelContenido.removeAll();
		panelContenido.add(c);
		panelContenido.repaint();
		panelContenido.revalidate();
		this.lblTitulo.setText(tittle);
	}

}
