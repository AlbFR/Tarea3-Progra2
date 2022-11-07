package tarea3.progra2;

public class Comprador {
   private String sabor;
   private int vuelto;
   public Comprador(Moneda m, int tipo, Expendedor exp) {
      Bebida b = exp.atender(m, tipo);
      if (b != null) {
         this.sabor = b.beber();
         this.vuelto = 0;
         Moneda c = exp.getVuelto();
         while (c != null) {
            vuelto += c.getValor();
            c = exp.getVuelto();
         }
      }
      else {
         Moneda m1 = exp.getVuelto();
         if (m1 != null)
            this.vuelto = m1.getValor();
      }
   }
   public String getSabor() {
      return this.sabor;
   }
   public int getVuelto() {
      return this.vuelto;
   }
}