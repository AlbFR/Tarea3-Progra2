    package tarea3.progra2;

import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito{
    private ArrayList<Bebida> a;
    private int count;
    public Deposito(){
        a = new ArrayList<Bebida>();
        count = 0;
    }
    public int llenarDeposito(int capacidad, int serie_inicial, int tipo) {
        Bebida b = null;
        if (this.a.size() >= capacidad)
            return 0;
        int start = this.a.size();
        for (int i=start;i<capacidad;++i) {
            switch (tipo) {
                case 0:
                    b = new CocaCola(serie_inicial+i-start);
                    break;
                case 1:
                    b = new Sprite(serie_inicial+i-start);
                    break;
                case 2:
                    b = new Fanta(serie_inicial+i-start);
                    break;
            }
            this.addBebida(b);
        }
        return capacidad - start;
    }
    public void addBebida(Bebida b){
        a.add(b);
    }
    public int size() {
        return a.size();
    }
    public boolean paintComponent(Graphics g, int k, int x, int y) {
        try {
            for (int i=0;i<a.size();++i) {
                if (!a.get(i).paintComponent(g, x+k*75, y - i*75))
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
    public int getCount(){
        int auxcount = count;
        count++;
        return auxcount;
    }
    public Boolean isEmpty(){
        return a.isEmpty();
    }
    
    public String toString() {
        String r = new String();
        for (int i=0;i<a.size();++i) {
            r += a.get(i).beber() + ", ";
        }
        return r;
    }
}