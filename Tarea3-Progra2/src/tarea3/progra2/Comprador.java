package tarea3.progra2;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Comprador {
   private String sabor;
   private int vuelto;
   private ArrayList<Moneda> sencillo;
   public Deposito sodas;
   private BufferedImage img;
   public Moneda m1, m2, m3;
   public Moneda selectedCoin;
   private static final int x = 100, y = 100;
   public Comprador(Moneda m, int tipo, Expendedor exp) {
      m1 = new Moneda100();
      m2 = new Moneda500();
      m3 = new Moneda1000();
      selectedCoin = null;
      sodas = new Deposito();
      try {
         img = ImageIO.read(getClass().getResource("assets/stickman.png"));
      }
      catch (Exception e) {
         System.out.println(e);
      }
   }
   public boolean paintComponent (Graphics g) {
    try {
        g.drawImage(this.img, x, y, null);
        m1.paint(g, 265, 360);
        m2.paint(g, 265, 300);
        m3.paint(g, 265, 240);
        sodas.paintComponent(g, 0, 30, 330);
        return true;
    }
    catch (Exception e) {
        System.out.println(e);
        return false;
        }
    }
    public void takeChange(Expendedor exp){
        Moneda auxchange = exp.getVuelto();
        if(auxchange != null){
            vuelto = vuelto +  auxchange.getValor();
            this.sencillo.add(auxchange);
        }else{
           System.out.println("There is not change to take.");
        }
    }
    
    public String getSabor() {
        return this.sabor;
    }
    public int getVuelto() {
        return this.vuelto;
    }
    public ArrayList<Moneda> getSencillo(){
        return sencillo;
    }
}