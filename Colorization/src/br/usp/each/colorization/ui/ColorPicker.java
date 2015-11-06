package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorPicker implements ActionListener {

	private ColorPickerCallback callback;

	public ColorPicker(ColorPickerCallback callback) {
		this.callback = callback;
	}

	public JButton getButton(String label) {
		JButton button = new JButton(label);
		button.addActionListener(this);

		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JButton button = (JButton) e.getSource();
			Component parent = button.getParent();
			String title = "Escolha a cor";

			Color color = JColorChooser.showDialog(parent, title, Color.WHITE);
			this.callback.onColorSelected(color);
		} catch (ClassCastException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
