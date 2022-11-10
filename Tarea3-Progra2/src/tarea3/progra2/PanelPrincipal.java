package tarea3.progra2;

import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
   Expendedor exp;
   Moneda m;
   Comprador c;
   public PanelPrincipal() {
      this.setBackground(Color.white);
      int precios[] = {700, 700, 700};
      exp = new Expendedor(5, precios);
      m = new Moneda500();
      c = new Comprador(m, 1, exp);
   }
   public void paint(Graphics g) {
      try {
         super.paint(g);
         // g.setColor(Color.black);
         // g.fillRect(40, 40, 50, 30);
         exp.paint(g);
         c.paint(g);
         // this.m.paint(g, 400, 100);
      }
      catch (Exception e) {
         System.out.println(e);
      }
   }
}