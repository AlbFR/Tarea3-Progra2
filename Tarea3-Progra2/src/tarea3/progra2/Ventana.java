package tarea3.progra2;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
   public Ventana() {
      super();
      this.setLayout(new BorderLayout());
      this.setTitle("Expendedor de Bebidas");

      // this.add(new JButton("Sur"), BorderLayout.SOUTH);
      // this.add(new JButton("Centro"), BorderLayout.CENTER);
      // this.add(new JButton("Norte"), BorderLayout.NORTH);
      // this.add(new JButton("Este"), BorderLayout.EAST);
      // this.add(new JButton("Oeste"), BorderLayout.WEST);
      this.add(new PanelPrincipal());

      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(800, 1000);
      this.setVisible(true);
   }
}
