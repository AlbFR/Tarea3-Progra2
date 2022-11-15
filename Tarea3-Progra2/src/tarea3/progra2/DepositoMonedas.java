package tarea3.progra2;

import java.util.ArrayList;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DepositoMonedas{
    private ArrayList<Moneda> a;
    private BufferedImage img;

    public DepositoMonedas(){
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

    public void paint(Graphics g) {
        g.drawImage(this.img, 200, 100, null);
    }

    public Moneda getMoneda(){
        if (a.isEmpty()){
            return null;
        }else{
            return a.remove(0);
        }
    }
}
