package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToggleButton;

public class PencilTool implements ActionListener, MouseListener {

	private boolean isEnabled;
	private JToggleButton button;
	private Color color;

	private float coordenates[][];
	private int nextPoint;

	public PencilTool() {
		this.color = Color.BLACK;
		this.coordenates = new float[2][2];
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

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!this.isEnabled) return;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!this.isEnabled) return;

		this.coordenates[this.nextPoint][0] = e.getX();
		this.coordenates[this.nextPoint][1] = e.getY();

		this.nextPoint = (this.nextPoint + 1) % 2;

		if (this.nextPoint == 0) {
			String lineDescription = "Line: "
				+ "(" + this.coordenates[0][0] + "; "
				+ this.coordenates[0][1] + ") -> ( "
				+ this.coordenates[1][0] + "; "
				+ this.coordenates[1][1] + ")";

			System.out.println(lineDescription);
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
