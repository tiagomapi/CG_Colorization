package br.usp.each.colorization.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImageCanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		if (image == null) return;

		this.image = image;
		this.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.image != null) {
			g.drawImage(this.image, 0, 0, null);
		}
	}
}
