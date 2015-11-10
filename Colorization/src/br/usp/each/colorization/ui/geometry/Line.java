package br.usp.each.colorization.ui.geometry;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line {

	public final Point p1, p2;
	public final Color color;

	private Line2D line2D;

	public Line(Point p1, Point p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}

	public Line2D getLine2D() {
		if (this.line2D == null) {
			Point2D p1 = this.p1.getPoint2D();
			Point2D p2 = this.p2.getPoint2D();
			this.line2D = new Line2D.Float(p1, p2);
		}
		
		return this.line2D;
	}
}
