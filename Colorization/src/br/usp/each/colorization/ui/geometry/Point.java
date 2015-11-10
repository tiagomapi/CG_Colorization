package br.usp.each.colorization.ui.geometry;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Point {

	public final int x, y;
	public final Color color;

	private Point2D point2D;

	public Point(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Point2D getPoint2D() {
		if (this.point2D == null) {
			this.point2D = new Point2D.Float(this.x, this.y);
		}

		return this.point2D;
	}
}
