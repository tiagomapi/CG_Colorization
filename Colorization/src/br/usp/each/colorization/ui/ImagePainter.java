package br.usp.each.colorization.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.usp.each.colorization.processing.ColorPropagation;

public class ImagePainter implements ActionListener {

	private final ImageCanvas canvas;
	private JButton button;

	public ImagePainter(ImageCanvas canvas) {
		this.canvas = canvas;
	}

	public JButton getButton(String label) {
		if (this.button == null) {
			this.button = new JButton(label);
			this.button.addActionListener(this);
		}

		return this.button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.canvas == null) return;
		ColorPropagation.propagate(this.canvas);
	}
}
