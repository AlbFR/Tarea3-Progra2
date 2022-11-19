package tarea3.progra2;

import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
   public Expendedor exp;
   public Moneda m;
   public Comprador c;
   public PanelPrincipal() {
      this.setBackground(Color.white);
      int precios[] = {700, 700, 700};
      exp = new Expendedor(4, precios);
      m = new Moneda1000();
      c = new Comprador(m, 1, exp);
   }
   public void paintComponent(Graphics g) {
      try {
         super.paintComponent(g);
         exp.paintComponent(g);
         c.paintComponent(g);
      }
      catch (Exception e) {
         System.out.println(e);
      }
   }
    public Expendedor getExp() {
        return exp;
    }

    public Moneda getM() {
        return m;
    }

    public Comprador getC() {
        return c;
    }
   
}