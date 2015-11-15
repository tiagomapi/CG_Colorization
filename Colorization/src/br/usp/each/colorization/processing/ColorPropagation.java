package br.usp.each.colorization.processing;

import java.util.ArrayList;
import java.awt.Color;
import br.usp.each.colorization.ui.ImageCanvas;
import br.usp.each.colorization.ui.geometry.*;

public class ColorPropagation {

	public ColorPropagation() {
		// TODO Auto-generated constructor stub
	}

	public static void propagate(ImageCanvas canvas) {
		// TODO Image processing following the algorithm
		ArrayList<Line> l = new ArrayList<Line>(canvas.getPaintedLines());
		for(int i=0;i<l.size();i++){
			Line j;
			j=l.get(i);
			j=l.getRGB(Line.p1,Line.p2);
		}
				
			}
		
	}

