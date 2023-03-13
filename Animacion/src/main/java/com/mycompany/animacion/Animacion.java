
package com.mycompany.animacion;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
 // @author FAMILY

public class Animacion extends JFrame implements Runnable {
    int AltoV = 500;
    int AnchoV = 500;
    Image img;
    Thread hilo;
    int incremento=0;
    BufferedImage bi;
    
    public static void main(String[] args) {
        new  Animacion().setVisible(true);
    }
    
    public Animacion(){
        setSize(AltoV,AnchoV);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Animacion");
        hilo= new Thread(this);
        bi= new BufferedImage(AnchoV,AltoV,BufferedImage.TYPE_INT_RGB);
        Toolkit herramienta= Toolkit.getDefaultToolkit();
        img=herramienta.getImage(getClass().getResource("Animacion/correcone.png"));
        hilo.start();
    } 
    
  @Override
    public void paint(Graphics g){
        Graphics2D g2D;
        g.drawImage(bi,0,0,this);
        g2D =bi.createGraphics();
        g2D.fillRect(0, 0, AnchoV, AltoV);
        int mx=(incremento%5)*113;
        g2D.drawImage(img,200,200,200+113,200+140,mx,0,mx+113,140,null,this);
        repaint();
    }
    
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            incremento=incremento+1;
            if(incremento>=5){
                incremento=0;
            }else{
            
            }
        }
    }
}
