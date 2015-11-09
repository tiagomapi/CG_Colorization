package br.usp.each.colorization.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class PencilTool implements ActionListener {

	private ImageCanvas canvas;
	private boolean isEnabled;
	private JToggleButton button;
	
	public PencilTool(ImageCanvas canvas) {
		this.canvas = canvas;
	}

	public JToggleButton getButton(String label) {
		if (this.button == null) {
			this.button = new JToggleButton(label);
			this.button.addActionListener(this);
		}

		return this.button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.button) {
			this.isEnabled = this.button.isSelected();
			System.out.println(this.isEnabled);
		}
	}
}
