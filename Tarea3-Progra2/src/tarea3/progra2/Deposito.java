package tarea3.progra2;
import java.util.ArrayList;

public class Deposito{
    private ArrayList<Bebida> a;
    public Deposito(){
        a = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida b){
        a.add(b);
    }
    public Bebida getBebida() {
        if (this.a.size() > 0) {
            Bebida b = this.a.get(0);
            this.a.remove(0);
            return b;
        }
        return null;
    }
    public String toString() {
        String r = new String();
        for (int i=0;i<a.size();++i) {
            r += a.get(i).beber() + ", ";
        }
        return r;
    }
}