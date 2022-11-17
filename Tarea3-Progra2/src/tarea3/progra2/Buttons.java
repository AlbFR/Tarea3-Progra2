package tarea3.progra2;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons extends JFrame{
    private PanelPrincipal pp;
    private JButton m100;
    private JButton m500;
    private JButton m1000;
    
    public Buttons(PanelPrincipal ppaux){
        pp = ppaux;
        JButton cola = new JButton();
        JButton fanta = new JButton();
        JButton sprite = new JButton();    
        JButton depo = new JButton();
        JButton buy = new JButton();
        JButton coin = new JButton();
        JButton clearChange = new JButton();
        JButton clearSodas = new JButton();   
        
        cola.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("\nBuying Coke. . .\n");
                pp.getExp().comprarBebida(pp.getM(), 0);
                pp.repaint();
            }
        });
        cola.setBounds(600, 400, 20, 10);
        cola.setBackground(Color.black);
        pp.add(cola);
        
        fanta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("\nBuying Fanta. . .\n");
                pp.getExp().comprarBebida(pp.getM(), 1);
                pp.repaint();
            }
        });
        fanta.setBounds(600, 410, 20, 10);
        fanta.setBackground(Color.orange);
        pp.add(fanta);
        
        sprite.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("\nBuying Sprite. . .");
                pp.getExp().comprarBebida(pp.getM(), 2);
                pp.repaint();
            }
        });
        sprite.setBounds(600, 420, 20, 10);
        sprite.setBackground(Color.green);
        pp.add(sprite);
        
        depo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Refilling. . .");
                pp.getExp().refillDepo();
                pp.repaint();
            }
        });
        depo.setBounds(500, 400, 50, 70);
        depo.setOpaque(false);
        depo.setContentAreaFilled(false);
        pp.add(depo);
        
        buy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                pp.getC().takeChange(pp.getExp());
                pp.repaint();
            }
        });
        buy.setBounds(600,450,70,100);
        buy.setOpaque(false);
        buy.setContentAreaFilled(false);
        pp.add(buy);
        
        clearChange.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                if(!pp.getC().getSencillo().isEmpty()){
                    pp.getC().getSencillo().remove(0);
                }
                pp.repaint();
            }
        });
        clearChange.setBounds(100,150,10,10);
        clearChange.setOpaque(false);
        clearChange.setContentAreaFilled(false);
        pp.add(clearChange);
        
        clearSodas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                if(!pp.getC().getSabor().isEmpty()){
                    pp.getC().getSodas().remove(0);
                }
                pp.repaint();
            }
        });
        clearSodas.setBounds(200,250,10,10);
        clearSodas.setOpaque(false);
        clearSodas.setContentAreaFilled(false);
        pp.add(clearSodas);
    
        m100.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                System.out.println("100$ Coin.");
                pp.getC().
                this.m100.setEnabled(false);
            }
            pp.repaint();
            }
        });
    }
}