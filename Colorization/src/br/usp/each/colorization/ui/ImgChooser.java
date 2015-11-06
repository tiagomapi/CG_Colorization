package br.usp.each.colorization.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ImgChooser implements ActionListener {

	private JFileChooser chooser;

	public ImgChooser(JPanel canvas) {
		this.chooser = new JFileChooser();
		this.chooser.setMultiSelectionEnabled(false);
	}

	public JButton getButton(String label) {
		JButton button = new JButton(label);
		button.addActionListener(this);

		return button;
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
			System.out.println(this.selectFile(button.getParent()));
		} catch (ClassCastException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
