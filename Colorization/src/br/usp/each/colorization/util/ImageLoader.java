package br.usp.each.colorization.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageLoader {

	public static BufferedImage load(String fileName)
			throws FileNotFoundException, IOException {
		if (fileName == null || (fileName != null && fileName.isEmpty())) {
			return null;
		}

		return ImageIO.read(new File(fileName));
	}
}
