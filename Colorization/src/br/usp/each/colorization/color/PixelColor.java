package br.usp.each.colorization.color;

public class PixelColor {

	private YCbCrColor color;
	public BaseColors baseColors;

	public PixelColor(YCbCrColor color) {
		this.color = color;
		this.baseColors = new BaseColors();
	}

	public YCbCrColor getColor() {
		return this.color;
	}

	public void updateColor() {
		double[] chrominances = baseColors.calculateResultantColor();

		this.color = new YCbCrColor(
			this.color.y,
			chrominances[0],
			chrominances[1]
		);
	}

	public String toString() {
		return this.color.toString();
	}
}
