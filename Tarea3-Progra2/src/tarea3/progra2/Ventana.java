package tarea3.progra2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {
   public Ventana() {
      super();
      this.setLayout(new BorderLayout());
      this.setTitle("Expendedor de Bebidas");

      // this.add(new JButton("Sur"), BorderLayout.SOUTH);
      JButton but = new JButton("xd");
      // but.addActionListener(new ActionListener() {
      //    @Override
      //    public void actionPerformed(ActionEvent e) {
      //       System.out.println("Button Pressed :D");
      //    }
      // });
      but.addActionListener(event -> {
         System.out.println("Button Pressed :D");
         System.out.println("On coords "+event);
      });
      this.add(but, BorderLayout.SOUTH);
      // this.add(new JButton("Centro"), BorderLayout.CENTER);
      // this.add(new JButton("Norte"), BorderLayout.NORTH);
      // this.add(new JButton("Este"), BorderLayout.EAST);
      // this.add(new JButton("Oeste"), BorderLayout.WEST);
      this.add(new PanelPrincipal());

      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(800, 500);
      this.setVisible(true);
   }
}
