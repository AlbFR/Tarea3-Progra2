package tarea3.progra2;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class Comprador {
   private String sabor;
   private int vuelto, coincount;
   private ArrayList<Moneda> sencillo;
   private ArrayList<Bebida> sodas;
   private BufferedImage img;
   private Moneda m1, m2, m3;
   private static final int x = 100, y = 100;
   public Comprador(Moneda m, int tipo, Expendedor exp) {
      m1 = new Moneda100();
      m2 = new Moneda500();
      m3 = new Moneda1000();
      try {
         img = ImageIO.read(getClass().getResource("assets/stickman.png"));
      }
      catch (Exception e) {
         System.out.println(e);
      }
      // if (b != null) {
      //    this.sabor = b.beber();
      //    this.vuelto = 0;
      //    Moneda c = exp.getVuelto();
      //    while (c != null) {
      //       vuelto += c.getValor();
      //       c = exp.getVuelto();
      //    }
      // }
      // else {
      //    Moneda m1 = exp.getVuelto();
      //    if (m1 != null)
      //       this.vuelto = m1.getValor();
      // }  
      
   }
   public boolean paintComponent (Graphics g) {
      try {
         g.drawImage(this.img, x, y, null);
         m1.paint(g, 265, 360);
         m2.paint(g, 265, 300);
         m3.paint(g, 265, 240);
         return true;
      }
      catch (Exception e) {
         System.out.println(e);
         return false;
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
   public ArrayList<Bebida> getSodas(){
       return sodas;
   }
   public void addSoda(Bebida b){
       this.sodas.add(b);
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
}