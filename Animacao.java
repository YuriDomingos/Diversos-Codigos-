/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animacao;
import Objecto.Estrelas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Utilitarios.Utilitarios;
import java.awt.geom.GeneralPath;
import Objecto.Planeta;
import Utilitarios.Utilitarios;
import java.security.SecureRandom;
import java.awt.geom.AffineTransform;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author yuri
  * Data 16-05-020
 */
public class Animacao extends JPanel implements Runnable
{
    Utilitarios utilitario = new Utilitarios();
    SecureRandom random = new SecureRandom();
    ArrayList<Planeta> planetas;
    ArrayList<Estrelas> estrelas;
    float[] dash1 = {2f, 0f, 2f};
    float[] dash2 = {1f, 1f, 1f};
    float[] dash3 = {4f, 0f, 2f};
    float[] dash4 = {4f, 4f, 1f};
    int []posicoesX;
    int []posicoesY;
    int velocidadeX = 0, velocidade = 5, velX = 800, velY= 800;
    int []velocidadesX;
    int []velocidadesY;
    
    
    
    public Animacao()
    {
        this.setBackground(Color.BLACK);
        new Thread(this).start();
        posicoesX = new int[1000];
        posicoesY = new int[1000];
        utilitario.inicializarPosicoes(posicoesX);
        utilitario.inicializarPosicoes(posicoesY);
        velocidadesX = new int[5];
        velocidadesY = new int[5];
        planetas = new ArrayList();
        estrelas = new ArrayList();
        planetas.add(new Planeta("Mercurio",15, 30, 1, 12));
        planetas.add(new Planeta("Venus",30, 50, 1, 2));
        planetas.add(new Planeta("Terra",32, 90, 2, 2));
        planetas.add(new Planeta("Marte",28, 120, 4, 2));
        planetas.add(new Planeta("Jupiter",40, 150, 2, 2));
        planetas.add(new Planeta("Saturno",35, 180, 1, 2));
        planetas.add(new Planeta("Uranos",34, 210, 2, 2));
        planetas.add(new Planeta("Neptuno",33, 240, 3, 2));
        planetas.add(new Planeta("Pluto",15, 270, 1, 2));
        
        estrelas.add(new Estrelas(20, "Pedra"));
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHints(utilitario.getQualidade());  
        int centroLargura = getWidth()/2;
        int centroAltura = getHeight()/2;
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 50));
        
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 30));
        g2d.setColor(new Color(255,69,0));
       
        g2d.setColor(Color.ORANGE);
        
        estrelas.forEach((estrela) -> {estrela.doEstrela(g2d, velX, velY);});
        
        
        //estrelas.forEach((estrela) -> {estrela.doEstrela(g2d, velocidade, velocidade);});
        g2d.setColor(Color.ORANGE);
        
        
        g2d.setComposite(utilitario.getTransparencia(false));
        g2d.fillOval(velocidadeX, velocidadeX, 10, 10);
        g2d.setComposite(utilitario.getTransparencia(true));
        g2d.fillOval(velocidadeX - 20/2, velocidadeX - 20/2, 30, 30);
        g2d.setColor(Color.WHITE);
        for(int i=0; i < 1000; i++)
        {
            g2d.setComposite(utilitario.getTransparencia(false));
            g2d.fillOval(posicoesX[i], posicoesY[i], 6, 6);
            g2d.setComposite(utilitario.getTransparencia(true));
            g2d.fillOval(posicoesX[i] - 9/2, posicoesY[i] - 9/2, 15, 15);
        }
        g2d.setComposite(utilitario.getTransparencia(false));
        g2d.setColor(new Color(255,89,0));
        g2d.fillOval(centroLargura, centroAltura, 50, 50);
        g2d.setComposite(utilitario.getTransparencia(true));
        g2d.fillOval(centroLargura - 30/2, centroAltura - 30/2, 80, 80);
        g2d.setComposite(utilitario.getTransparencia(false));
        planetas.forEach((planeta) -> {planeta.doPlanet(g2d, centroLargura, centroAltura);});
        
        
        //
    }

    public void update()
    {
        velocidadeX = velocidadeX + 1;
        velocidade = velocidade - 1;
        velX++;
        velY--;
    }
    
    @Override
    public void run() 
    {
        while(true)
        {
            update();
            repaint();
            try
            {
                //Thread.sleep(1000/24);
                Thread.sleep(73);
            }catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
}
