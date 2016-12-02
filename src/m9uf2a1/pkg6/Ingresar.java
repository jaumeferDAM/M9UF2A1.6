/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf2a1.pkg6;

import java.util.Random;

/**
 *
 * @author ALUMNEDAM
 */
public class Ingresar implements Runnable {

    private final Random aleatorio;
    private final Banco contenedor;
    private final int idproductor;

    /**
     * Constructor de la clase
     *
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idproductor Identificador del productor
     */
    public Ingresar(Banco contenedor, int idproductor) {
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        aleatorio = new Random();
    }

    public int getIdproductor() {
        return idproductor;
    }
    

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
//             System.out.println("EL trabajador " + idproductor + " pone: " + poner);;
//         System.out.println(Thread.currentThread());
            contenedor.ingresar(poner);
           
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Error " + idproductor + ": Error en run -> " + e.getMessage());
            }
        }
    }
}
