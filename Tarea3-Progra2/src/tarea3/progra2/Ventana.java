package tarea3.progra2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {    
    Buttons button;
    PanelPrincipal pp;
    
    public Ventana() {
      super();

      pp = new PanelPrincipal();
      this.setLayout(new BorderLayout());
      this.setTitle("Expendedor de Bebidas");

      button = new Buttons(pp, pp.exp, pp.c);
      this.getContentPane().add(pp);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(1000, 500);
      this.setVisible(true);
   }
}
