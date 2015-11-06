package br.usp.each.colorization.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class Window {

	private JFrame frmColorirImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmColorirImagem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		this.initialize();
		this.openFileChooser();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmColorirImagem = new JFrame();
		frmColorirImagem.setTitle("Colorir Imagem - CG");
		frmColorirImagem.setResizable(false);
		frmColorirImagem.setBounds(100, 100, 830, 680);
		frmColorirImagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmColorirImagem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel imgCanvas = new JPanel();
		imgCanvas.setBounds(12, 12, 800, 600);
		imgCanvas.setBackground(Color.WHITE);
		panel.add(imgCanvas);
		
		JButton btnColorir = new JButton("Colorir");
		btnColorir.setBounds(731, 620, 81, 25);
		panel.add(btnColorir);
	}

	private void openFileChooser() {
		
	}
}
