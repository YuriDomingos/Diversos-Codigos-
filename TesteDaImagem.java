/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testedaimagem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author : Yuri Domingos
 * Data    : 14 - 01 - 2021
 * Objectivo  : Criar bem o cenárino
 */
public class TesteDaImagem extends JPanel  {

       private Graphics buffer;
       
JPanel dPanel;

	private BufferedImage offscreen;

	public TesteDaImagem() {
            save();
		this.offscreen = new BufferedImage(400, 300, 1);
		this.buffer = this.offscreen.getGraphics();
		this.setPreferredSize(new Dimension(800, 600));
	}

	@Override
	public void paint(Graphics g) {
            
		this.buffer.setColor(Color.WHITE);
		this.buffer.fillRect(0, 0, 800, 600);

		this.buffer.setColor(Color.BLACK);
		this.buffer.drawString("Double-buffered", 10, 10);

		this.buffer.setColor(Color.BLUE);
		this.buffer.fillOval(200, 150, 100, 50);

		g.drawImage(this.offscreen, 0, 0, this);

		try {
			ImageIO.write(offscreen, "png", new File("i.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
        public void save()
      {
        BufferedImage bImg = new BufferedImage(dPanel.getWidth(), dPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D cg = bImg.createGraphics();
        dPanel.paintAll(cg);
       try {
            if (ImageIO.write(bImg, "png", new File("./output_image.png")))
            {
                System.out.println("-- saved");
            }
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
}


	@Override
	public void update(Graphics g) {
		paint(g);
	}

    public static void main(String[] args) {
       
        
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JScrollPane(new TesteDaImagem()));
		frame.setSize(400, 300);
		frame.setVisible(true);
    }
    
}
