package br.usp.each.colorization.color;

public class BaseColors {

	public final int maxColors;
	public double[] distances;
	public YCbCrColor[] colors;

	public BaseColors() {
		this.maxColors = 3;
		this.distances = new double[this.maxColors];
		this.colors = new YCbCrColor[this.maxColors];
	}

	public BaseColors(int maxColors) {
		if (maxColors <= 0) maxColors = 3;

		this.maxColors = maxColors;
		this.distances = new double[this.maxColors];
		this.colors = new YCbCrColor[this.maxColors];
	}

	public int hasColorFurtherThan(double distance, YCbCrColor color) {		
		if (color == null) return -1;

		for (int i = 0; i < this.maxColors; i++) {
			if (distance < this.distances[i]) return i;
			if (this.colors[i] == color) return -1;
		}

		return -1;
	}

	public void addColor(int index, YCbCrColor color, double distance) {
		if (index < 0 || index >= this.maxColors) return;
		if (color == null) return;

		for (int i = this.maxColors - 1; i > index; i--) {
			if (i - 1 < 0) break;
			if (this.colors[i - 1] == color) continue;

			this.distances[i] = this.distances[i - 1];
			this.colors[i] = this.colors[i - 1];
		}

		this.distances[index] = distance;
		this.colors[index] =  color;
	}

	public double[] calculateResultantColor() {
		return ColorsBlender.blend(this.colors, this.distances);
	}
}
