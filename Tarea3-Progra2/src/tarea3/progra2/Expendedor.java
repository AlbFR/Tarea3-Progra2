package tarea3.progra2;

import java.util.ArrayList;
import tarea3.progra2.exceptions.PagoIncorrectoException;
import tarea3.progra2.exceptions.NoHayBebidaException;
import tarea3.progra2.exceptions.PagoInsuficienteException;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
// import javax.swing.JButton;

public class Expendedor {
   private int precios[];
   private int capacidad;
   private DepositoMonedas vuelto;
   private DepositoMonedas monedas;
   //<private DepositoMonedas money2buy;
   private ArrayList<Deposito> depositos;
   private BufferedImage img;
   public Bebida bebidaComprada;
   private static final int x = 400;
   private static final int y = 0;
   private Deposito coke;
   private Deposito sprite;
   private Deposito fanta;

   public Expendedor (int capacidad, int precios[]) {
      coke = new Deposito();
      sprite = new Deposito();
      fanta = new Deposito();
      //money2buy = new DepositoMonedas();
      this.precios = precios;
      this.capacidad = capacidad;
      this.depositos = new ArrayList<Deposito>();
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
      this.depositos = new ArrayList<Deposito>();
      Bebida b = null;
      int serie = 0;
      for (int i=0;i<3;++i) {
         Deposito d = new Deposito();
         for (int j=0;j<capacidad;++j) {
            switch (i) {
               case 0 -> b = new CocaCola(serie);
               case 1 -> b = new Sprite(serie);
               case 2 -> b = new Fanta(serie);
            }
            d.addBebida(b);
            serie++;
         }
         depositos.add(d);
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
   public void refillDepo(){
       if(coke.isEmpty()){
           for(int i=0; i<capacidad; i++){
               Bebida auxsoda = new CocaCola(coke.getCount());
               coke.addBebida(auxsoda);
           }
       }else{
           System.out.println("There is still coke in the machine.");
       }
       if(fanta.isEmpty()){
           for(int i=0; i<capacidad; i++){
               Bebida auxsoda = new Fanta(fanta.getCount());
               fanta.addBebida(auxsoda);
           }
       }else{
           System.out.println("There is still fanta in the machine.");
       }
       if(sprite.isEmpty()){
           for(int i=0; i<capacidad; i++){
               Bebida auxsoda = new Sprite(sprite.getCount());
               sprite.addBebida(auxsoda);
           }
       }else{
           System.out.println("There is still sprite in the machine.");
       }
   }
}
