/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf2a1.pkg6;

/**
 *
 * @author ALUMNEDAM
 */
public class Main {
 private static Banco banco;
    private static Thread[] ingresadores;
    private static Thread[] retiradores;
    private static final int CANTIDADRETIRADORES = 5;
    private static final int CANTIDADINGRESADORES = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        banco = new Banco();
     
        ingresadores = new Thread[CANTIDADINGRESADORES];
        retiradores = new Thread[CANTIDADRETIRADORES];
        
        for (int i = 0; i < CANTIDADRETIRADORES; i++) {
            retiradores[i] = new Thread(new Retirar(banco, i));
            retiradores[i].start();
        }
        
        for(int i = 0;i<CANTIDADINGRESADORES;i++) {
            ingresadores[i] = new Thread (new Ingresar(banco, i));
            ingresadores[i].start();
        }

        
        
    }
}
    

