package br.usp.each.colorization.graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import br.usp.each.colorization.color.PixelColor;
import br.usp.each.colorization.color.RGBColor;
import br.usp.each.colorization.color.YCbCrColor;

public class PixelMatrix {

	private BufferedImage image;
	private Pixel[] pixels;

	public final int width;
	public final int height;

	public final int lastCol;
	public final int lastRow;

	public PixelMatrix(BufferedImage image) {
		this.height = image.getHeight();
		this.width = image.getWidth();

		this.pixels = new Pixel[this.width * this.height];	
		this.lastCol = this.width - 1;
		this.lastRow = this.height - 1;
		this.populateMatrix();
	}

	private void populateMatrix() {
		if (this.image == null) return;

		for (int i = 0; i < this.pixels.length; i++) {
			int row = i / this.height;
			int col = i % this.height;

			RGBColor color = new RGBColor(this.image.getRGB(row, col));
			this.pixels[i] = new Pixel(row, col, new YCbCrColor(color));
		}		
	}

	public void updateBufferedImage() {
		if (this.image == null) return;

		for (int i = 0; i < this.pixels.length; i++) {
			PixelColor color = this.pixels[i].color;
			color.updateColor();

			int x = this.pixels[i].x;
			int y = this.pixels[i].y;
			RGBColor rgbColor = color.getColor().toRGB();

			this.image.setRGB(x, y, rgbColor.toSingleValue());			
		}
	}

	public Pixel getPixel(int x, int y) {
		return this.pixels[(x * this.height) + y];
	}

	public Pixel getPixel(int index) {
		return this.pixels[index];
	}

	public Pixel[] get8Neighborhood(Pixel pixel) {
		if (pixel == null) return null;		

		int[][] moviments = {
			{ -1, -1 },
			{ -1,  0 },
			{ -1,  1 },
			{  0, -1 },
			{  0,  1 },
			{  1, -1 },
			{  1,  0 },
			{  1,  1 }
		};

		ArrayList<Pixel> neighbors = new ArrayList<Pixel>();

		for (int i = 0; i < moviments.length; i++) {
			int row = pixel.x + moviments[i][0];
			int col = pixel.y + moviments[i][1];

			if (col < 0 || col > this.lastCol) continue;
			if (row < 0 || row > this.lastRow) continue;

			neighbors.add(this.getPixel(row, col));
		}

		return (Pixel[]) neighbors.toArray();
	}
}
