package br.usp.each.colorization.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import br.usp.each.colorization.util.ImageLoader;
import br.usp.each.colorization.util.Resource;

public class ImageChooser implements ActionListener {

	private JFileChooser chooser;
	private ImageCanvas canvas;
	
	private JButton button;

	public ImageChooser(ImageCanvas canvas) {
		this.canvas = canvas;
		this.chooser = new JFileChooser();
		this.chooser.setMultiSelectionEnabled(false);
	}

	public JButton getButton(String text) {
		if (this.button == null) {
			String iconPath = Resource.getIconPath("document-open.png");
			this.button = new JButton(new ImageIcon(iconPath));
			this.button.setToolTipText(text);
			this.button.addActionListener(this);
		}

		return this.button;
	}

	public String selectFile(Component parent) {
		int returnVal = this.chooser.showOpenDialog(parent);
		if (returnVal != JFileChooser.APPROVE_OPTION) return null;

		File selectedFile = this.chooser.getSelectedFile();
		return selectedFile.getPath();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JButton button = (JButton) e.getSource();
			String imgName = this.selectFile(button.getParent());

			this.canvas.setImage(ImageLoader.load(imgName));
		} catch (ClassCastException ex) {
			System.err.println(ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
