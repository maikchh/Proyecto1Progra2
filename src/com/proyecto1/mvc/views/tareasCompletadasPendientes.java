package com.proyecto1.mvc.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class tareasCompletadasPendientes extends JPanel {
	private JComboBox cbxCategTareaP;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);

	}

}
