package br.usp.each.colorization.color;

public class YCbCrColor {
	
	public final double y;
	public final double cb;
	public final double cr;

	public YCbCrColor(double y, double cb, double cr) {
		this.y = y;
		this.cb = cb;
		this.cr = cr;
	}

	public YCbCrColor(RGBColor rgb) {
		double[] color = this.fromRGB(rgb);
		this.y = color[0];
		this.cb = color[1];
		this.cr = color[2];
	}

	private double[] fromRGB(RGBColor rgb) {
		if (rgb == null) return null;
		double[] color = new double[3];

		color[0] = (0.299 * rgb.red) + (0.587 * rgb.green) + (0.114 * rgb.blue);

		color[1] = (-0.169 * rgb.red) + (-0.331 * rgb.green)
			+ (0.499 * rgb.blue) + 128;

		color[2] = (0.499 * rgb.red) + (-0.418 * rgb.green)
			+ (-0.0813 * rgb.blue) + 128;

		return color;
	}

	public RGBColor toRGB() {
		double y = this.y;
		double cb = this.cb - 128.0;
		double cr = this.cr - 128.0;

		double[] color = new double[3];
		color[0] = y + (1.402 * cr);
		color[1] = y + (-0.344 * cb) + (-0.714 * cr);
		color[2] = y + (1.772 * cb);

		return new RGBColor(color[0], color[1], color[2]);
	}

	public String toString() {
		return "(Y=" + this.y
			+ ", Cb=" + this.cb
			+ ", Cr=" + this.cr + ")";
	}
}
