package tarea3.progra2;

import java.awt.*;
import javax.swing.*;


public abstract class Figura {
   private Polygon p;
   private int x;
   private int y;
   private int width;
   private int height;
   Color color;
   public Figura(int x, int y, int width, int height, Color color) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
   }
   abstract public void paint(Graphics g);
}

class Rectangulo extends Figura {
   private Polygon p;
   private int x;
   private int y;
   private int width;
   private int height;
   private Color color;
   public Rectangulo (int x, int y, int width, int height, Color color) {
      super(x, y, width, height, color);
      p = new Polygon();
      p.addPoint(x, y);
      p.addPoint(x+width, y);
      p.addPoint(x+width, y+height);
      p.addPoint(x, y+height);
   }
   public void paint (Graphics g) {
      g.setColor(this.color);
      g.drawPolygon(this.p);
      g.fillPolygon(this.p);
   }
}