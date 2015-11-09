package br.usp.each.colorization.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;

public class Window implements ColorPickerCallback {

	private JFrame frmColorirImagem;
	private ImageCanvas canvas;
	private Color color;

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

		this.canvas = new ImageCanvas();
		this.canvas.setBounds(12, 12, 800, 600);
		this.canvas.setBackground(Color.WHITE);
		panel.add(this.canvas);

		ColorPicker colorPicker = new ColorPicker(this);
		JButton btnColor = colorPicker.getButton("Escolher cor");
		btnColor.setBounds(10, 620, 120, 25);
		panel.add(btnColor);
		
		PencilTool pencil = new PencilTool(this.canvas);
		JToggleButton btnPencil = pencil.getButton("Lapis");
		btnPencil.setBounds(140, 620, 80, 25);
		panel.add(btnPencil);

		ImageChooser chooser = new ImageChooser(this.canvas);
		JButton btnChooseImg = chooser.getButton("Abrir imagem");
		btnChooseImg.setBounds(590, 620, 130, 25);
		panel.add(btnChooseImg);

		JButton btnColorir = new JButton("Colorir");
		btnColorir.setBounds(731, 620, 81, 25);
		panel.add(btnColorir);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void onColorSelected(Color color) {
		this.setColor(color);
		System.out.println(this.color);
	}
}
