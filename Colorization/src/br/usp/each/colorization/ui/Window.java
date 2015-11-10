package br.usp.each.colorization.ui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import br.usp.each.colorization.util.ImageLoader;
import br.usp.each.colorization.util.Resource;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Window implements ColorPickerCallback {

	private JFrame frame;
	private ImageCanvas canvas;
	private PencilTool pencil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
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
		this.frame = new JFrame();
		this.frame.setTitle("Colorir Imagem - CG");
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, 830, 695);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String frameIconPath = Resource.getIconPath("painter-32.png");
		ImageIcon frameIcon = new ImageIcon(frameIconPath);
		this.frame.setIconImage(frameIcon.getImage());

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		this.canvas = new ImageCanvas();
		this.canvas.setBounds(12, 12, 800, 600);
		this.canvas.setImage(this.loadCanvasPlaceholder());
		panel.add(this.canvas);

		ImageChooser chooser = new ImageChooser(this.canvas);
		JButton btnChooseImg = chooser.getButton("Abrir imagem");
		btnChooseImg.setBounds(10, 620, 60, 40);
		panel.add(btnChooseImg);

		String saveIcon = Resource.getIconPath("document-save.png");
		JButton btnSave = new JButton(new ImageIcon(saveIcon));
		btnSave.setToolTipText("Salvar imagem");
		btnSave.setBounds(75, 620, 60, 40);
		panel.add(btnSave);

		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setBounds(145, 620, 1, 40);
		panel.add(separator);

		this.pencil = new PencilTool(this.canvas);
		String btnPencilTip = "Ferramenta de desenho";
		JToggleButton btnPencil = this.pencil.getPencilButton(btnPencilTip);
		btnPencil.setBounds(156, 620, 60, 40);
		this.canvas.addMouseListener(this.pencil);
		panel.add(btnPencil);

		ColorPicker colorPicker = new ColorPicker(this);
		JButton btnColor = colorPicker.getButton("Escolher cor");
		btnColor.setBounds(221, 620, 60, 40);
		panel.add(btnColor);

		JButton btnReset = this.pencil.getResetButton("Limpar");
		btnReset.setBounds(286, 620, 60, 40);
		panel.add(btnReset);

		JButton btnColorir = new JButton("Colorir");
		btnColorir.setBounds(727, 620, 85, 40);
		panel.add(btnColorir);
	}

	public BufferedImage loadCanvasPlaceholder() {
		String imgPath = Resource.getImagePath("placeholder-image.png");

		try {
			return ImageLoader.load(imgPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void onColorSelected(Color color) {
		if (this.pencil == null) return;
		this.pencil.setColor(color);
	}
}
