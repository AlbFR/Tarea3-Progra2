package tarea3.progra2;

import java.util.ArrayList;
import tarea3.progra2.exceptions.PagoIncorrectoException;
import tarea3.progra2.exceptions.NoHayBebidaException;
import tarea3.progra2.exceptions.PagoInsuficienteException;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Expendedor {
   private int precios[];
   private int capacidad;
   private int ultima_bebida;
   private DepositoMonedas vuelto;
   private DepositoMonedas monedas;
   private ArrayList<Deposito> depositos;
   private BufferedImage img;
   public Bebida bebidaComprada;
   private static final int x = 400;
   private static final int y = 0;

   public Expendedor (int capacidad, int precios[]) {
      this.ultima_bebida = 0;
      this.precios = precios;
      this.capacidad = capacidad;
      this.depositos = new ArrayList<Deposito>();
      this.depositos.add(new Deposito());
      this.depositos.add(new Deposito());
      this.depositos.add(new Deposito());
      bebidaComprada = null;
      vuelto =  new DepositoMonedas();
      monedas = new DepositoMonedas();
      try {
         img = ImageIO.read(getClass().getResource("assets/maquina.png"));
      }
      
      catch (java.io.IOException e) {
         System.out.println(e);
      }
      this.llenarDepositosBebida();
   }
   public boolean paintComponent (Graphics g) {
      try {
         vuelto.paintComponent(g, 750, 50);
         g.drawImage(this.img, x, y, null); // Draw Expendedor image
         for (int i=0;i<depositos.size();++i) { // Draw Sodas Deposit
            if (!depositos.get(i).paintComponent(g, i, 425, 258))
               return false;
         }
         if (bebidaComprada != null) {
            bebidaComprada.paintComponent(g, 630, 340);
         }
         return true;
      }
      catch (Exception e) {
         System.out.println(e);
         return false;
      }
   }
   public void llenarDepositosBebida() {
      for (int i=0;i<3;++i) {
         this.ultima_bebida += this.depositos.get(i).llenarDeposito(this.capacidad, ultima_bebida, i);
      }
   }
   public void comprarBebida(Moneda m, int tipo) {
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
            if (bebidaComprada == null) {
               bebidaComprada = b;
               System.out.println("Bebida comprada exitosamente");
               monedas.addMoneda(m);
            }
         }
         else if (m.getValor() < precios[tipo]) {
            vuelto.addMoneda(m);
            throw new PagoInsuficienteException();
         }
      }
      catch (PagoIncorrectoException ex) {
         System.out.println(ex.getMessage());
      }
      catch (PagoInsuficienteException ex) {
         System.out.println(ex.getMessage());
      }
      catch (NoHayBebidaException ex) {
         System.out.println(ex.getMessage());
      }
   }
   public Moneda getVuelto(){
       return vuelto.getMoneda();
   }
   public Bebida getBebida () {
      Bebida b = bebidaComprada;
      bebidaComprada = null;
      return b;
   }
}