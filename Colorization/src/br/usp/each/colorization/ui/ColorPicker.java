package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import br.usp.each.colorization.util.Resource;

public class ColorPicker implements ActionListener {

	private ColorPickerCallback callback;
	private JButton button;
	
	public ColorPicker(ColorPickerCallback callback) {
		this.callback = callback;
	}

	public JButton getButton(String text) {
		if (this.button == null) {
			String iconPath = Resource.getIconPath("graphics.png");
			this.button = new JButton(new ImageIcon(iconPath));
			this.button.setToolTipText(text);
			this.button.addActionListener(this);
		}

		return this.button;
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
