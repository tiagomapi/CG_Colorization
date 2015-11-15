package br.usp.each.colorization.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;

import br.usp.each.colorization.ui.ImageCanvas;
import br.usp.each.colorization.ui.geometry.*;

public class ColorPropagation {

	public ColorPropagation() {
		// TODO Auto-generated constructor stub
	}

	
	public static void propagate(ImageCanvas canvas) {
		// TODO Image processing following the algorithm
		ArrayList<Line> l = canvas.getPaintedLines();
		Line j;
		Line2D p;
		PathIterator pit = p.getPathIterator(null);
		for(int i=0;i<l.size();i++){
			j=l.get(i);
			p=j.getLine2D();	
			canvas.setRGB(j.color);
			pit.next();
		}
		
				
			}
		
	}

