package br.usp.each.colorization.ui.geometry;

import java.awt.Color;

public class Line {

	public final Point p1, p2;
	public final Color color;

	public Line(Point p1, Point p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}
}
