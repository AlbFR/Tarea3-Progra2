package tarea3.progra2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public abstract class Bebida {
    protected static final int marginx = 8;
    protected static final int marginy = 40;
    private int serie;
    public Bebida(int serie) {
        this.serie = serie;
    }
    public int getSerie() {
        return this.serie;
    }
    public String beber() {
        return "sabor: ";
    }
    public abstract boolean paint(Graphics g, int x, int y);
}

class Sprite extends Bebida{
    private static BufferedImage img;
    public Sprite(int serie){
        super(serie);
        try {
            img = ImageIO.read(getClass().getResource("assets/greenSoda.png"));
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
    @Override
    public String beber(){
        return super.beber() + "sprite";
    }
    public boolean paint(Graphics g, int x, int y) {
        try {
            g.drawImage(img, x, y, null);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 14));
            g.drawString(String.valueOf(String.valueOf(this.getSerie())), x+Bebida.marginx, y+Bebida.marginy);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
class Fanta extends Bebida{
    private static BufferedImage img;
    public Fanta(int serie){
        super(serie);
        try {
            img = ImageIO.read(getClass().getResource("assets/blueSoda.png"));
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
    @Override
    public String beber(){
        return super.beber() + "fanta";
    }
    public boolean paint(Graphics g, int x, int y) {
        try {
            g.drawImage(img, x, y, null);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 14));
            g.drawString(String.valueOf(String.valueOf(this.getSerie())), x+Bebida.marginx, y+Bebida.marginy);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
class CocaCola extends Bebida{
    private static BufferedImage img;
    public CocaCola(int serie){
        super(serie);
        try {
            // Image pn = new ImageIcon("assets/rsz_lata_coca.png").getImage();
            // System.out.println(pn.getWidth(null));
            // img = new BufferedImage(pn.getWidth(null), pn.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            // img = ImageIO.read(getClass().getResource("assets/rsz_lata_coca.png"));
            img = ImageIO.read(getClass().getResource("assets/redSoda.png"));
            // img = Thumbnails.of(img).size(20, 40).asBufferedImage();
        }
        catch (Exception e) {
            System.out.println("La wea esta al mostrar la coca :/" + e);
        }
        // catch (java.io.IOException e) {
        //     System.out.println(e);
        // }
    }
    @Override
    public String beber(){
        return super.beber() + "cocacola";
    }
    public boolean paint(Graphics g, int x, int y) {
        try {
            g.drawImage(img, x, y, null);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 14));
            g.drawString(String.valueOf(String.valueOf(this.getSerie())), x+Bebida.marginx, y+Bebida.marginy);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}