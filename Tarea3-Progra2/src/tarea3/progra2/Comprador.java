package tarea3.progra2;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Comprador {
   private String sabor;
   private int vuelto;
   private BufferedImage img;
   private static final int x = 100;
   private static final int y = 100;
   public Comprador(Moneda m, int tipo, Expendedor exp) {
      Bebida b = exp.atender(m, tipo);
      try {
         img = ImageIO.read(getClass().getResource("assets/stickman.png"));
      }
      catch (Exception e) {
         System.out.println(e);
      }
      if (b != null) {
         this.sabor = b.beber();
         this.vuelto = 0;
         Moneda c = exp.getVuelto();
         while (c != null) {
            vuelto += c.getValor();
            c = exp.getVuelto();
         }
      }
      else {
         Moneda m1 = exp.getVuelto();
         if (m1 != null)
            this.vuelto = m1.getValor();
      }
   }
   public boolean paint (Graphics g) {
      try {
         g.drawImage(this.img, x, y, null);
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
}