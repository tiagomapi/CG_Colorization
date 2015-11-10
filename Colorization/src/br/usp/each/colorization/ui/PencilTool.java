package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import br.usp.each.colorization.ui.geometry.Line;
import br.usp.each.colorization.ui.geometry.Point;
import br.usp.each.colorization.util.Resource;

public class PencilTool implements ActionListener, MouseListener {

	private boolean isEnabled;

	private final ImageCanvas canvas;
	private JToggleButton pencilButton;
	private JButton resetButton;
	private Cursor defaultCursor;
	private Cursor pencilCursor;

	private Point points[];
	private int nextPoint;
	private Color color;

	public PencilTool(ImageCanvas canvas) {
		this.canvas = canvas;
		this.color = Color.BLACK;
		this.points = new Point[2];
	}

	public JToggleButton getPencilButton(String text) {
		if (this.pencilButton == null) {
			String iconPath = Resource.getIconPath("pencil.png");
			this.pencilButton = new JToggleButton(new ImageIcon(iconPath));
			this.pencilButton.setToolTipText(text);
			this.pencilButton.addActionListener(this);
		}

		return this.pencilButton;
	}

	public JButton getResetButton(String text) {
		if (this.resetButton == null) {
			String iconPath = Resource.getIconPath("edit-clear.png");
			this.resetButton = new JButton(new ImageIcon(iconPath));
			this.resetButton.setToolTipText(text);
			this.resetButton.addActionListener(this);
		}

		return this.resetButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.pencilButton) {
			this.isEnabled = this.pencilButton.isSelected();
		} else if (e.getSource() == this.resetButton) {
			this.canvas.clearLinesList();
			this.canvas.clearPointsList();
			this.canvas.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (!this.isEnabled) return;
		
		if (this.pencilCursor == null) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			
			String name = "Pencil cursor";
			String iconFileName = "pencil-cursor-16.png";
			int iconY = 15;

			if (System.getProperty("os.name").startsWith("Windows")) {
				iconFileName = "pencil-cursor-32.png";
				iconY = 31;
			}

			String iconPath = Resource.getIconPath(iconFileName);
			ImageIcon icon = new ImageIcon(iconPath);
			Image img = icon.getImage();

			java.awt.Point point = new java.awt.Point(0, iconY);
			this.pencilCursor = toolkit.createCustomCursor(img, point, name);
		}

		e.getComponent().setCursor(this.pencilCursor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (!this.isEnabled) return;

		if (this.defaultCursor == null) {
			this.defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
		}

		e.getComponent().setCursor(this.defaultCursor);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!this.isEnabled) return;

		this.points[this.nextPoint] = new Point(e.getX(), e.getY(), this.color);

		this.canvas.addPoint(this.nextPoint, this.points[this.nextPoint]);

		this.nextPoint = (this.nextPoint + 1) % 2;

		if (this.nextPoint == 0) {
			Line line = new Line(this.points[0], this.points[1], this.color);
			this.canvas.addLine(line);
			this.canvas.clearPointsList();			
		}

		this.canvas.repaint();
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
