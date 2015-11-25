package br.usp.each.colorization.ui.geometry;

import java.awt.Color;

public class BresenhamsLine extends Line {
	private Point[] points;
	private final int dx;
	private final int dy;

	private final int dx2;
	private final int dy2;
	private final int difDyDx2;

	public BresenhamsLine(Point p1, Point p2, Color color) {
		super(p1, p2, color);

		this.dx = p2.x - p1.x;
		this.dy = p2.y - p1.y;

		this.dx2 = 2 * this.dx;
		this.dy2 = 2 * this.dy;
		this.difDyDx2 = this.dy2 - this.dx2;

		this.points = new Point[this.dx];
		this.points[0] = this.p1;
	}

	public void calculateAllPoints() {
		int currentPoint = 1;
		int loopEnd = this.dx - 1;
		int pk = this.dy2 - this.dx;

		while (currentPoint <  loopEnd) {
			int x = this.points[currentPoint - 1].x;
			int y = this.points[currentPoint - 1].y;

			if (pk > 0) {
				this.points[currentPoint++] = new Point(x + 1, y + 1, this.color);
				pk += this.difDyDx2;
				continue;
			}

			this.points[currentPoint++] = new Point(x + 1, y, this.color);
			pk += this.dy2;
		}

		for (int i = 0; i < this.points.length; i++) {
			System.out.println("(" + this.points[i].x + ", " + this.points[i].y + ")");
		}
	}
}
