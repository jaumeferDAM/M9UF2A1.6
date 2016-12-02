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
public class Banco {

    private float saldo;
    private boolean ingresado = true;
    private Ingresar ingresar;
    private int idproductor;
    private float poner;
    public boolean comprova = false;

    public Banco(Ingresar ingresar) {
        this.ingresar = ingresar;
    }
//
    public Banco() {
    }

    public synchronized void retirar(float valor) {
        while (ingresado) {
                
            try {
                ingresado=false;
                wait();

            } catch (InterruptedException e) {
                System.err.println("Contenedor: error en get: " + e.getMessage());
            }
        }
       ingresado=true;
        saldo -= valor;
        
        System.out.println("Retiro la cantidad de: " + valor + " y me queda un total de :" + saldo);
        notifyAll();

    }

    public synchronized void ingresar(float value) {
        while (ingresado) {
            try {
                ingresado=true;
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: error en put: " + e.getMessage());
            }
        }
        saldo += value;
        ingresado=true;
        System.out.println("Ingreso la cantidad de: " + value + " y me queda un total de :" + saldo);

        notifyAll();
    }
}
