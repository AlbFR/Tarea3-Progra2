package tarea3.progra2;

import java.util.ArrayList;
import tarea3.progra2.exceptions.PagoIncorrectoException;
import tarea3.progra2.exceptions.NoHayBebidaException;
import tarea3.progra2.exceptions.PagoInsuficienteException;

public class Expendedor {
   int precios[];
   int capacidad;
   DepositoMonedas vuelto;
   ArrayList<Deposito> depositos;

   public Expendedor (int capacidad, int precios[]) {
      this.precios = precios;
      this.capacidad = capacidad;
      this.depositos = new ArrayList<Deposito>();
      vuelto =  new DepositoMonedas();
      Deposito d = null;
      Bebida b = null;
      for (int i=0;i<3;++i) {
         d = new Deposito();
         for (int j=0;j<capacidad;++j) {
            if (i==0)
               b = new CocaCola(i*j + j);
            else if (i==1)
               b = new Sprite(i*j + j);
            else if (i==2)
               b = new Fanta(i*j + j);
            d.addBebida(b);
         }
         depositos.add(d);
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
}
