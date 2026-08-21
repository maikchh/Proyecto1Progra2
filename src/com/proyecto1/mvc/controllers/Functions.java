package com.proyecto1.mvc.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Functions {
	public void addSearch(JTextField input, JTable tabla, int... cols) {
		input.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String buscar = input.getText().trim();
				buscar(tabla, buscar, cols);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}

	public void buscar(JTable tabla, String buscar, int... cols) {

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
		tabla.setRowSorter(sorter);
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + buscar, cols));
		// (?i) = case-insensitive

	}

	public int getSelectedID(JTable tabla) {

		int row = tabla.getSelectedRow();
		if (row >= 0) {
			return (int) tabla.getValueAt(row, 0);
		} else {
			return -1;
		}

	}

}
