package br.usp.each.colorization.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;

import br.usp.each.colorization.ui.ImageCanvas;
import br.usp.each.colorization.ui.geometry.*;
import br.usp.each.colorization.util.ImageLoader;

public class ColorPropagation {

	public ColorPropagation() {
		// TODO Auto-generated constructor stub
	}

	
	public static void propagate(ImageCanvas canvas) {
		// TODO Image processing following the algorithm
		ArrayList<Line> l = canvas.getPaintedLines();
		Line j;

		Line2D p = null;
        BufferedImage image= canvas.getImage();


		Graphics2D g2=(Graphics2D)image.getGraphics();
		PathIterator pit = p.getPathIterator(null);
		
		for(int i=0;i<l.size();i++){
			j=l.get(i);
			p=j.getLine2D();

			
			dye(image,j.color);

			g2.drawLine(j.p1.x,j.p1.y,j.p2.x,j.p2.y);
			pit.next();

		}
		for(int i=0;i<l.size();i++){
			j=l.get(i);
			p=j.getLine2D();
			
		}
		
				
			}
		
	private static void dye(BufferedImage image, Color color)
    {
	 int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage dyed = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dyed.createGraphics();
        g.drawImage(image, 0,0, null);
        g.setComposite(AlphaComposite.SrcAtop);
        g.setColor(color);
        g.fillRect(0,0,w,h);
        g.dispose();
        return;
    }
	}
