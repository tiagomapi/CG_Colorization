package br.usp.each.colorization.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import br.usp.each.colorization.ui.geometry.Line;
import br.usp.each.colorization.ui.geometry.Point;

public class ImageCanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	
	private ArrayList<Line> lines;
	private Point points[];

	public ImageCanvas() {
		this.lines = new ArrayList<Line>();
		this.points = new Point[2];
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		if (image == null) return;

		this.image = image;
		this.repaint();
	}

	public void addLine(Line line) {
		if (this.lines == null || line == null) return;
		this.lines.add(line);
	}

	public void addPoint(int index, Point point) {
		if (this.points == null) return;
		this.points[index] = point;
	}

	public void clearLinesList() {
		if (this.lines == null) return;
		this.lines.clear();
	}

	public void clearPointsList() {
		if (this.points == null) return;

		for (int i = 0; i < this.points.length; i++) {
			this.points[i] = null;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.image != null) {
			g.drawImage(this.image, 0, 0, null);
		}

		for (int i = 0; i < this.points.length; i++) {
			if (this.points[i] == null) continue;

			int x = this.points[i].x - 1;
			int y = this.points[i].y - 1;

			g.setColor(this.points[i].color);
			g.fillRect(x, y, 5, 5);
		}

		for (Line line : this.lines) {
			g.setColor(line.color);
			g.drawLine(line.p1.x, line.p1.y, line.p2.x, line.p2.y);
		}
	}
}
