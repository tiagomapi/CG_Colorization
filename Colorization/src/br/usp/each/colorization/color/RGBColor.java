package br.usp.each.colorization.color;

public class RGBColor {

	public final long red;
	public final long green;
	public final long blue;

	public RGBColor(double r, double g, double b) {
		this.red = Math.round(r);
		this.green = Math.round(g);
		this.blue = Math.round(b);
	}

	public RGBColor(int argb) {
		int[] components = this.fromSingleValue(argb);
		this.red = components[1];
		this.green = components[2];
		this.blue = components[3];
	}

	private int[] fromSingleValue(int argb) {
		int[] components = new int[4];
		int temp = argb;

		for (int i = 3; i >= 0; i--) {
			components[i] = temp & 255;
			temp >>= 8;
		}

		return components;
	}

	public int toSingleValue() {
		long[] components = {255, this.red, this.green, this.blue};

		int argb = 0;
		int places = 24;

		for (int i = 0; i < 4; i++) {
			argb |= components[i] << places;
			places -= 8;
		}

		return argb;
	}

	public String toString() {
		return "(R=" + this.red
			+ ", G=" + this.green
			+ ", B=" + this.blue + ")";
	}
}
