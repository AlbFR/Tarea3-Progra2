package tarea3.progra2;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DepositoMonedas {
    private ArrayList<Moneda> a;
    private BufferedImage img;

    public DepositoMonedas() {
        a = new ArrayList<Moneda>();
        try {
            img = ImageIO.read(getClass().getResource("assets/deposito_monedas.png"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addMoneda(Moneda b){
        a.add(b);
    }

    public void paintComponent(Graphics g, int x, int y) {
        try {
            g.drawImage(this.img, x, y, null);
            for (int i=0;i<a.size();++i) {
                a.get(i).paint(g, x+19, y+310-i*10);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public Moneda getMoneda(){
        if (a.isEmpty()){
            return null;
        }else{
            return a.remove(0);
        }
    }
}
