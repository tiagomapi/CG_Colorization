package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToggleButton;

import br.usp.each.colorization.ui.geometry.Line;
import br.usp.each.colorization.ui.geometry.Point;

public class PencilTool implements ActionListener, MouseListener {

	private boolean isEnabled;
	private JToggleButton button;
	private Color color;

	private Point points[];
	private int nextPoint;

	public PencilTool() {
		this.color = Color.BLACK;
		this.points = new Point[2];
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
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!this.isEnabled) return;

		this.points[this.nextPoint] = new Point(e.getX(), e.getY(), this.color);

		ImageCanvas canvas = (ImageCanvas) e.getComponent();
		canvas.addPoint(this.nextPoint, this.points[this.nextPoint]);
		canvas.repaint();

		this.nextPoint = (this.nextPoint + 1) % 2;

		if (this.nextPoint == 0) {
			Line line = new Line(this.points[0], this.points[1], this.color);
			canvas.addLine(line);
			canvas.clearPointsList();
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
