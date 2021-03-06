package br.usp.each.colorization.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import br.usp.each.colorization.ui.geometry.BresenhamsLine;
import br.usp.each.colorization.ui.geometry.Point;

public class ImageCanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	
	private ArrayList<BresenhamsLine> lines;
	private Point points[];

	public ImageCanvas() {
		this.lines = new ArrayList<BresenhamsLine>();
		this.points = new Point[2];
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		if (image == null) return;

		this.image = image;
		this.clearPointsList();
		this.clearLinesList();
		this.repaint();
	}

	public ArrayList<BresenhamsLine> getPaintedLines() {
		return (ArrayList<BresenhamsLine>) Collections.unmodifiableList(
			this.lines
		);
	}

	public void addLine(BresenhamsLine line) {
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

	public void drawLine(Graphics g, BresenhamsLine line) {
		if (g == null || line == null) return;
		g.setColor(line.color);
		
		Point[] points = line.getPoints();
		if (points == null) return;

		for (int i = 0; i < points.length; i++) {
			g.fillRect(points[i].x, points[i].y, 1, 1);
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

			g.setColor(Color.BLACK);
			g.fillRect(x, y, 5, 5);
		}

		for (BresenhamsLine line : this.lines) {
			this.drawLine(g, line);
		}
	}
}
