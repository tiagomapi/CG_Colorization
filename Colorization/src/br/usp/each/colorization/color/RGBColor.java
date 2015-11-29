package br.usp.each.colorization.color;

public class RGBColor {

	public final int red;
	public final int green;
	public final int blue;

	public RGBColor(int r, int g, int b) {
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
