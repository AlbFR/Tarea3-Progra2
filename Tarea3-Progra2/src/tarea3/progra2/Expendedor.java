package tarea3.progra2;

import java.util.ArrayList;
import tarea3.progra2.exceptions.PagoIncorrectoException;
import tarea3.progra2.exceptions.NoHayBebidaException;
import tarea3.progra2.exceptions.PagoInsuficienteException;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
// import javax.swing.*;

public class Expendedor {
   private int precios[];
   private int capacidad;
   private DepositoMonedas vuelto;
   private ArrayList<Deposito> depositos;
   private BufferedImage img;
   private static final int x = 400;
   private static final int y = 0;

   public Expendedor (int capacidad, int precios[]) {
      this.precios = precios;
      this.capacidad = capacidad;
      this.depositos = new ArrayList<Deposito>();
      vuelto =  new DepositoMonedas();
      Deposito d = null;
      Bebida b = null;
      try {
         img = ImageIO.read(getClass().getResource("assets/maquina.png"));
      }
      catch (java.io.IOException e) {
         System.out.println(e);
      }
      for (int i=0;i<3;++i) {
         d = new Deposito();
         for (int j=0;j<capacidad;++j) {
            switch (i) {
               case 0:
                  b = new CocaCola(i*j + j);
                  break;
               case 1:
                  b = new Sprite(i*j + j);
                  break;
               case 2:
                  b = new Fanta(i*j + j);
                  break;
            }
            d.addBebida(b);
         }
         depositos.add(d);
      }
   }
   public boolean paint (Graphics g) {
      try {
         g.drawImage(this.img, this.x, this.y, null);
         return true;
      }
      catch (Exception e) {
         return false;
      }
   }
   public Bebida atender(Moneda m, int tipo) {
      try {
         if (m == null) {
            throw new PagoIncorrectoException();
         }
         else if (tipo < 0 || 2 < tipo) {
            vuelto.addMoneda(m);
            throw new NoHayBebidaException();
         }
         else if (m.getValor() >= precios[tipo]) {
            Bebida b = depositos.get(tipo).getBebida();
            if (b == null) {
               vuelto.addMoneda(m);
               throw new NoHayBebidaException();
            }
            Moneda c;
            for (int i=precios[tipo]/100; i<m.getValor()/100; i++){
               c = new Moneda100();
               vuelto.addMoneda(c);
            }
            return b;
         }
         else if (m.getValor() < precios[tipo]) {
            vuelto.addMoneda(m);
            throw new PagoInsuficienteException();
         }
         return null;
      }
      catch (PagoIncorrectoException ex) {
         System.out.println(ex.getMessage());
         return null;
      }
      catch (PagoInsuficienteException ex) {
         System.out.println(ex.getMessage());
         return null;
      }
      catch (NoHayBebidaException ex) {
         System.out.println(ex.getMessage());
         return null;
      }
   }
   public Moneda getVuelto(){
       return vuelto.getMoneda();
   }
   // private ArrayList<Figura> inicializarGraficoExpendedor () {
   //    ArrayList<Figura> r = new ArrayList<Figura>();
   //    Figura f = new Rectangulo(capacidad, capacidad, capacidad, capacidad, null);
   //    return r;
   // }
   public void paint () {

   }
}
