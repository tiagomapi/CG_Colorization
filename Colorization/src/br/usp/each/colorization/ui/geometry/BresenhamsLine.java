package br.usp.each.colorization.ui.geometry;

import java.awt.Color;

public class BresenhamsLine extends Line {
	private final Point[] points;
	private final int dx;
	private final int dy;

	private final int dx2;
	private final int dy2;

	public BresenhamsLine(Point p1, Point p2, Color color) {
		super(p1, p2, color);

		this.dx = p2.x - p1.x;
		this.dy = p2.y - p1.y;

		this.dx2 = 2 * this.dx;
		this.dy2 = 2 * this.dy;

		this.points = this.calculateAllPoints();
	}

	private Point[] calculateAllPoints() {
		Point[] points = new Point[this.dx + 1];
		points[0] = this.p1;

		int currentPoint = 1;
		int pk = this.dy2 - this.dx;

		while (currentPoint <= this.dx) {
			int x = points[currentPoint - 1].x + 1;
			int y = points[currentPoint - 1].y;
			int pk1 = pk + this.dy2;

			if (pk > 0) pk1 -= this.dx2;
			if (pk1 > 0) y++;

			pk = pk1;
			points[currentPoint++] = new Point(x, y);
		}

		return points;
	}

	public Point[] getPoints() {
		return this.points;
	}
}
