import java.awt.*;
import java.util.Random;
import java.awt.color.*;
import java.io.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.swing.*;
import javax.imageio.*;

	public class Colorir extends JFrame{		

		
		private BufferedImage imagem;
		  AreaImagem areaImagem;  

		  public Colorir(){
		    super("Abrir imagem");
		    
		    Container c = getContentPane();
		    c.setLayout(new BorderLayout());
		 
		    JButton btn = new JButton("Carregar Imagem");
		    btn.addActionListener(
		      new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		          JFileChooser fc = new JFileChooser();

		          int res = fc.showOpenDialog(null);
		          if(res == JFileChooser.APPROVE_OPTION){
		     File arquivo = fc.getSelectedFile();  
		          
		            imagem = null;
		          
		            try{
		              imagem = ImageIO.read(arquivo);
		            }
		            catch(IOException exc){
		              JOptionPane.showMessageDialog(null, 
		                "Erro ao carregar a imagem: " + 
		                exc.getMessage());
		            }

		            if(imagem != null){
		              areaImagem.imagem = imagem;
		              areaImagem.repaint();  
		            }
		          }
		        }
		      }
		    );

		    c.add(btn, BorderLayout.SOUTH);
		    
		    // Cria a área de exibição da imagem
		    areaImagem = new AreaImagem();
		    c.add(areaImagem, BorderLayout.CENTER);    
		 
		    setSize(400, 300);
		    setVisible(true);
		  }
		  
		  public static void main(String args[]){
		    Colorir app = new Colorir();
		    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		  }
		

		// Sub-classe de JPanel para exibir a imagem
		class AreaImagem extends JPanel{
		  public BufferedImage imagem;
		  

		  public void paintComponent(Graphics g){ 
		    super.paintComponent(g);
		    
		    // desenha a imagem no JPanel
		    g.drawImage(imagem, 0, 0, this);
		    /****************************************************************/
		    int w = imagem.getWidth();
		    int h = imagem.getHeight();
		    int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
		    Random r = new Random();
		    int i=0; //teste
		    for (int col = 0; col < w; col++) {
		      for (int lin = 0; lin < h; lin++) {
		        pixels[w * lin + col] =
		          new Color(r.nextInt(255), col % 255, lin % 255).getRGB();
		      }
		    }

		    imagem.setRGB(0, 0, w, h, pixels, 0, w);
		    try {
		    	System.out.println(i+1); //teste
				ImageIO.write(imagem, "PNG", new File("arteabstrata.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    /****************************************************************/
		    
		  } 
	}
	}	
	
