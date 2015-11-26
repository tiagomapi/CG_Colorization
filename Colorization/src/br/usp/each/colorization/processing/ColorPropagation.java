package br.usp.each.colorization.processing;

import java.awt.Color;

import br.usp.each.colorization.ui.ImageCanvas;
import br.usp.each.colorization.ui.geometry.BresenhamsLine;
import br.usp.each.colorization.ui.geometry.Point;

public class ColorPropagation {

	public ColorPropagation() {
		// TODO Auto-generated constructor stub
	}

	public static void propagate(ImageCanvas canvas) {
		Point p1 = new Point(0, 10, Color.BLUE);
		Point p2 = new Point(50, 30, Color.BLUE);

		BresenhamsLine line = new BresenhamsLine(p1, p2, Color.BLUE);
		line.calculateAllPoints();
	}
}
