package tarea3.progra2;
import java.awt.Color;
import javax.swing.JButton;

public class Buttons{
    private PanelPrincipal pp;
    private Expendedor exp;
    private Comprador com;
    private boolean retiredSoda;
    
    public Buttons(PanelPrincipal ppaux, Expendedor exp, Comprador com){
        this.exp = exp;
        pp = ppaux;
        pp.setLayout(null);
        retiredSoda = true;
        
        JButton m100 = new JButton("100$");
        m100.setBounds(260, 230, 100, 60);
        m100.setFocusable(false);
        m100.setOpaque(false);
        m100.setContentAreaFilled(false);
        pp.add(m100);
        m100.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("\n100$ coin selected. . .");
                com.selectedCoin = com.m1;
            }
        });
        
        JButton m500 = new JButton("500$");
        m500.setBounds(260, 290, 100, 60);
        m500.setFocusable(false);
        m500.setOpaque(false);
        m500.setContentAreaFilled(false);
        pp.add(m500);
        m500.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("\n500$ coin selected. . .");
                com.selectedCoin = com.m2;
            }
        });
        
        JButton m1000 = new JButton("1000$");
        m1000.setBounds(260, 350, 100, 60);
        m1000.setFocusable(false);
        m1000.setOpaque(false);
        m1000.setContentAreaFilled(false);
        pp.add(m1000);
        m1000.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("\n1000$ coin selected. . .");
                com.selectedCoin = com.m3;
            }
        });
        
        JButton coke = new JButton("A");
        coke.setBounds(626, 130, 45, 15);
        coke.setBackground(Color.black);
        coke.setFocusable(false);
        pp.add(coke);
        coke.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                if(retiredSoda == true){
                    System.out.println("\nBuying Coke. . .\n");
                    pp.getExp().comprarBebida(pp.getM(), 0);
                    pp.repaint();
                    retiredSoda = false;
                }else{
                    System.out.println("The soda hasnt been retired yet.");
                }
            }
        });
        
        JButton fanta = new JButton("B");
        fanta.setBounds(626, 146, 45, 15);
        fanta.setBackground(Color.green);
        fanta.setFocusable(false);
        pp.add(fanta);
        fanta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if(retiredSoda == true){
                    System.out.println("\nBuying Fanta. . .\n");
                    pp.getExp().comprarBebida(pp.getM(), 1);
                    pp.repaint();
                    retiredSoda = false;
                }else{
                    System.out.println("The soda hasnt been retired yet.");
                }
            }
        });
        
        JButton sprite = new JButton("C");
        sprite.setBounds(626, 162, 45, 15);
        sprite.setBackground(Color.orange);
        sprite.setFocusable(false);
        pp.add(sprite);
        sprite.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                if(retiredSoda == true){
                    System.out.println("\nBuying Sprite. . .");
                    pp.getExp().comprarBebida(pp.getM(), 2);
                    pp.repaint();
                    retiredSoda = false;
                }else{
                    System.out.println("The soda hasnt been retired yet.");
                }
            }
        });
        
        JButton depo = new JButton("Refill");
        depo.setBounds(416, 15, 200, 303);
        depo.setOpaque(false);
        depo.setContentAreaFilled(false);
        depo.setFocusable(false);
        pp.add(depo);
        depo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Refilling. . .");
                exp.llenarDepositosBebida();
                pp.repaint();
            }
        });        
        JButton clearChange = new JButton("Clear Change");
            clearChange.setBounds(750,50,120,353);
            clearChange.setOpaque(false);
            clearChange.setContentAreaFilled(false);
            clearChange.setFocusable(false);
            pp.add(clearChange);
            clearChange.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                pp.getC().takeChange(pp.getExp());
                pp.repaint();
            }
        });
        //clearChange.setBounds(750,50,120,353);
        //clearChange.setOpaque(false);
        //clearChange.setContentAreaFilled(false);
        //clearChange.setFocusable(false);
        //pp.add(clearChange);
        //clearChange.addMouseListener(new java.awt.event.MouseAdapter() {
        //    @Override
        //    public void mouseClicked(java.awt.event.MouseEvent e){  
        //        if(!pp.getC().getSencillo().isEmpty()){
        //            pp.getC().getSencillo().remove(0);
        //        }
        //        pp.repaint();
        //    }
        //});
        
        JButton clearSodas = new JButton("Clear Soda");
        clearSodas.setBounds(620,322,56,82);
        clearSodas.setOpaque(false);
        clearSodas.setContentAreaFilled(false);
        clearSodas.setFocusable(false);
        pp.add(clearSodas);
        clearSodas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){  
                retiredSoda = true;
                if(pp.getC().getSodas().isEmpty()){
                    return;
                }else{
                    pp.getC().getSodas().remove(0);
//                        pp.getC().addSoda(pp.getExp().getBebida());
                }
                pp.getExp().bebidaComprada = null;
                pp.repaint();
            }
        });
    }
}