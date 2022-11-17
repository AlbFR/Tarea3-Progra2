package tarea3.progra2;
import java.awt.Color;
import javax.swing.JButton;

public class Buttons{
    private PanelPrincipal pp;
    private JButton m100;
    private JButton m500;
    private JButton m1000;
    
    public Buttons(PanelPrincipal ppaux){
        pp = ppaux;
        pp.setLayout(null);
        
        JButton coke = new JButton("A");
        coke.setBounds(626, 130, 45, 15);
        coke.setBackground(Color.black);
        pp.add(coke);
        coke.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("\nBuying Coke. . .\n");
                pp.getExp().comprarBebida(pp.getM(), 0);
                pp.repaint();
            }
        });
        
        JButton fanta = new JButton("B");
        fanta.setBounds(626, 146, 45, 15);
        fanta.setBackground(Color.orange);
        pp.add(fanta);
        fanta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("\nBuying Fanta. . .\n");
                pp.getExp().comprarBebida(pp.getM(), 1);
                pp.repaint();
            }
        });
        
        JButton sprite = new JButton("C");
        sprite.setBounds(626, 162, 45, 15);
        sprite.setBackground(Color.green);
        pp.add(sprite);
        sprite.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("\nBuying Sprite. . .");
                pp.getExp().comprarBebida(pp.getM(), 2);
                pp.repaint();
            }
        });
        
        JButton depo = new JButton("Refill");
        depo.setBounds(500, 400, 50, 70);
        depo.setOpaque(false);
        depo.setContentAreaFilled(false);
        pp.add(depo);
        depo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Refilling. . .");
                pp.getExp().refillDepo();
                pp.repaint();
            }
        });
        
        JButton buy = new JButton("Buy");
        buy.setBounds(600,450,70,100);
        buy.setOpaque(false);
        buy.setContentAreaFilled(false);
        pp.add(buy);
        buy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                pp.getC().takeChange(pp.getExp());
                pp.repaint();
            }
        });
        
        JButton clearChange = new JButton("Clear Change");
        clearChange.setBounds(100,150,10,10);
        clearChange.setOpaque(false);
        clearChange.setContentAreaFilled(false);
        pp.add(clearChange);
        clearChange.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                if(!pp.getC().getSencillo().isEmpty()){
                    pp.getC().getSencillo().remove(0);
                }
                pp.repaint();
            }
        });
        
        JButton clearSodas = new JButton("Clear Soda");
        clearSodas.setBounds(200,250,10,10);
        clearSodas.setOpaque(false);
        clearSodas.setContentAreaFilled(false);
        pp.add(clearSodas);
        clearSodas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                if(!pp.getC().getSabor().isEmpty()){
                    pp.getC().getSodas().remove(0);
                }
                pp.repaint();
            }
        });
        
        
        //JButton coin = new JButton();
    }
}