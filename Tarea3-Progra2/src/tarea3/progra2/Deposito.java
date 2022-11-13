package tarea3.progra2;

import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito{
    private ArrayList<Bebida> a;
    public Deposito(){
        a = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida b){
        a.add(b);
    }
    public boolean paint(Graphics g, int k) {
        try {
            for (int i=0;i<a.size();++i) {
                if (!a.get(i).paint(g, 400+k*5, 500 - i*30))
                    return false;
            }
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
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