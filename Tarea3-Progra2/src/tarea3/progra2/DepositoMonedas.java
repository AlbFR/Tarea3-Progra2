package tarea3.progra2;
import java.util.ArrayList;

public class DepositoMonedas{
    private ArrayList<Moneda> a;

    public DepositoMonedas(){
        a = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda b){
        a.add(b);
    }

    public Moneda getMoneda(){
        if (a.isEmpty()){
            return null;
        }else{
            return a.remove(0);
        }
    }
}
