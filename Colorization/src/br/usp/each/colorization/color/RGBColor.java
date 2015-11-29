package br.usp.each.colorization.color;

public class RGBColor {

	public final double red;
	public final double green;
	public final double blue;

	public RGBColor(double r, double g, double b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public String toString() {
		return "(R=" + this.red
			+ ", G=" + this.green
			+ ", B=" + this.blue + ")";
	}
}
