/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testecicunferencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yuri
 */
public class implemnt extends JPanel implements Runnable{
    
    
    private Thread thread;
    private double angle;
    private int x = 10;
    private int y = 10;
    

    public implemnt() {
        
        init();
        thread = new Thread(this);
        thread.start();
    }
    
    
    public void init()
    {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500,500));
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        
         graphics2D.setColor(Color.RED);
        
        graphics2D.rotate(Math.toRadians(angle), 180, 180);
        graphics2D.fill(new Ellipse2D.Double(50,50,50,50));
        
        repaint();
    }
    
    

    @Override
    public void run() {
        
        while(true)
        {
            angle+=15;
            try {
                
                Thread.sleep(90);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(implemnt.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    
}
