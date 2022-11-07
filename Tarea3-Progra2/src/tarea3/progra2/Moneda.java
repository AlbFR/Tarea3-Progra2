// Ready!!
package tarea3.progra2;

public abstract class Moneda {
  public Moneda() {}
  public abstract int getValor();

  public int getSerie() {
    return this.hashCode();
  }
  public String toString() {
    return "Moneda: {\n\tSerie: "+this.getSerie()+"\n\tValor: "+this.getValor()+"\n}\n";
   }
}
class Moneda1000 extends Moneda {
   public Moneda1000() {
      super();
   }
   public int getValor() {
      return 1000;
   }
}
class Moneda500 extends Moneda {
   public Moneda500() {
      super();
   }
   public int getValor() {
      return 500;
   }
}
class Moneda100 extends Moneda {
   public Moneda100() {
      super();
   }
   public int getValor() {
      return 100;
   }
}
