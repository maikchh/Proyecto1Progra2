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

public class tareasCompletadasPendientes extends JPanel {
	private JComboBox cbxCategTareaP;
	private JTable table;
	private final JButton btnEditar = new JButton("Editar");

	/**
	 * Create the panel.
	 */
	public tareasCompletadasPendientes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel_1.add(lblCategoria);
		
		cbxCategTareaP = new JComboBox();
		panel_1.add(cbxCategTareaP);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCategoria_1 = new JLabel("Categoria:");
		panel_2.add(lblCategoria_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNueva = new JButton("Nueva");
		panel_2.add(btnNueva, BorderLayout.SOUTH);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.add(btnEditar, BorderLayout.SOUTH);

	}

}
