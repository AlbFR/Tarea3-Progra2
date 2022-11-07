package tarea3.progra2;

public class Tarea2Progra2 {
    public static void main(String[] args) {
        // Deposito d = new Deposito();
        // Bebida b = new Sprite(1);
        // d.addBebida(b);
        // b = d.getBebida();
        // System.out.println(b.beber());
        //
        int precios[] = {700, 700, 700};
        Expendedor e1 = new Expendedor(1, precios);
        Moneda m1 = new Moneda1000();
        Moneda m2 = new Moneda500();

        System.out.println("Compra 1:");
        Comprador Pedro = new Comprador(m1, 0, e1);
        System.out.println(Pedro.getSabor());
        System.out.println(Pedro.getVuelto());
        System.out.println();

        System.out.println("Compra 2:");
        Comprador Juan = new Comprador(m1, 0, e1);
        System.out.println(Juan.getSabor());
        System.out.println(Juan.getVuelto());
        System.out.println();

        System.out.println("Compra 3:");
        Comprador Diego = new Comprador(m1, 1, e1);
        System.out.println(Diego.getSabor());
        System.out.println(Diego.getVuelto());
        System.out.println();

        System.out.println("Compra 4:");
        Comprador Maria = new Comprador(null, 0, e1);
        System.out.println(Maria.getSabor());
        System.out.println(Maria.getVuelto());
        System.out.println();

        System.out.println("Compra 5:");
        Comprador Julia = new Comprador(m1, 3, e1);
        System.out.println(Julia.getSabor());
        System.out.println(Julia.getVuelto());
        System.out.println();

        System.out.println("Compra 6:");
        Comprador Ana = new Comprador(m2, 2, e1); // Moneda distinta
        System.out.println(Ana.getSabor());
        System.out.println(Ana.getVuelto());


        // Moneda m = new Moneda1000();
        // int p[] = {1000, 900, 1000};
        // Expendedor e = new Expendedor(3, p);
        // System.out.println("Comprador 1:");
        // Comprador mirro = new Comprador(m, 1, e);
        // System.out.println(mirro.getSabor());
        // System.out.println("Vuelto: "+mirro.getVuelto());

        // System.out.println("Comprador 2:");
        // Moneda c = new Moneda500();
        // Comprador yo = new Comprador(c, 1, e);
        // System.out.println(yo.getSabor());
        // System.out.println(yo.getVuelto());

        // System.out.println("Comprador 3:");

        // Comprador x = new Comprador(m, 1, e);
        // System.out.println(x.getSabor());
        // System.out.println(x.getVuelto());
    }
}
