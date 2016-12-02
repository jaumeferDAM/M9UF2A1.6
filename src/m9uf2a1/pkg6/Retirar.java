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
public class Retirar implements Runnable {

    private final Random aleatorio;
    private final Banco contenedor;
    private final int idconsumidor;

    /**
     * Constructor de la clase
     *
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     * @param aleatorio
     */
    public Retirar(Banco contenedor, int idconsumidor) {
        aleatorio = new Random(); 
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
            contenedor.retirar(poner);
//            System.out.println("EL consumidor " + idconsumidor + " retira: " + poner);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Error " + idconsumidor + ": Error en run -> " + e.getMessage());
            }
        }
    }
}
