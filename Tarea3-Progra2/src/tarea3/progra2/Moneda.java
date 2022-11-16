// Ready!!
package tarea3.progra2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public abstract class Moneda {
   protected static final int marginx = 10;
   protected static final int marginy = 17;
   public Moneda() {}
   public abstract int getValor();

   public int getSerie() {
      return this.hashCode();
   }
   abstract public boolean paint(Graphics g, int x, int y);
   public String toString() {
      return "Moneda: {\n\tSerie: "+this.getSerie()+"\n\tValor: "+this.getValor()+"\n}\n";
   }
}
class Moneda1000 extends Moneda {
   private static BufferedImage img;
   public Moneda1000() {
      super();
      try {
         img = ImageIO.read(getClass().getResource("assets/moneda1000.png"));
      }
      catch (java.io.IOException e) {
         System.out.println(e);
      }
   }
   public boolean paint(Graphics g, int x, int y) {
      try {
         g.drawImage(img, x, y, null);
         g.setColor(Color.black);
         g.setFont(new Font("Arial", 1, 8));
         g.drawString(String.valueOf(this.getSerie()), x+Moneda.marginx, y+Moneda.marginy);
         return true;
      }
      catch (Exception e) {
         System.out.println(e);
         return false;
      }
   }
   public int getValor() {
      return 1000;
   }
}
class Moneda500 extends Moneda {
   private static BufferedImage img;

   public Moneda500() {
      super();
      try {
         img = ImageIO.read(getClass().getResource("assets/moneda500.png"));
      }
      catch (java.io.IOException e) {
         System.out.println(e);
      }
   }
   public int getValor() {
      return 500;
   }
   public boolean paint(Graphics g, int x, int y) {
      try {
         g.drawImage(img, x, y, null);
         g.setColor(Color.black);
         g.setFont(new Font("Arial", 1, 8));
         g.drawString(String.valueOf(this.getSerie()), x+Moneda.marginx, y+Moneda.marginy);
         return true;
      }
      catch (Exception e) {
         return false;
      }
   }
}
class Moneda100 extends Moneda {
   private static BufferedImage img;

   public Moneda100() {
      super();
      try {
         img = ImageIO.read(getClass().getResource("assets/moneda100.png"));
      }
      catch (java.io.IOException e) {
         System.out.println(e);
      }
   }
   public int getValor() {
      return 100;
   }
   public boolean paint(Graphics g, int x, int y) {
      try {
         g.drawImage(img, x, y, null);
         g.setColor(Color.black);
         g.setFont(new Font("Arial", 1, 8));
         g.drawString(String.valueOf(this.getSerie()), x+Moneda.marginx, y+Moneda.marginy);
         return true;
      }
      catch (Exception e) {
         return false;
      }
   }
}
