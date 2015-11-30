package br.usp.each.colorization.ui;

import br.usp.each.colorization.color.PixelColor;
import br.usp.each.colorization.color.YCbCrColor;

public class Pixel {

	public final int x;
	public final int y;
	public PixelColor color;

	public Pixel(int x, int y, YCbCrColor color) {
		this.x = x;
		this.y = y;
		this.color = new PixelColor(color);
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")"
			+ " -> " + this.color.getColor().toString();
	}
}
