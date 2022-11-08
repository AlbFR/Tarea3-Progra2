package tarea3.progra2;

import java.awt.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
   Expendedor exp;
   Figura f;
   public PanelPrincipal() {
      int precios[] = {700, 700, 700};
      this.setBackground(Color.yellow);   
      exp = new Expendedor(5, precios);
      Color c = Color.black;
      f = new Rectangulo(100, 100, 100, 100, c);
   }
   public void paint(Graphics g) {
      try {
         g.setColor(Color.black);
         g.fillRect(40, 40, 50, 30);
         exp.paint(g);
         f.paint(g);
      }
      catch (Exception e) {}
   }
}