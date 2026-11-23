package olympicswimming.escenas;

import olympicswimming.base.*;
import olympicswimming.personajes.*;
import uwcse.graphics.*;

// Escena 3 carrera
// central baja 8 laterales bajan 3 y 6 px hacia afuera.
// 2 poses de brazos se ve una a la vez.
public class EscenaCarrera extends Escena {

    private NadadorIzquierdo izquierdo1;
    private NadadorIzquierdo izquierdo2;
    private NadadorDerecho derecho1;
    private NadadorDerecho derecho2;
    private NadadorCentral central1;
    private NadadorCentral central2;

    private int pose = 1;

    private Sonido silbato;
    private Sonido brazadas;

    public EscenaCarrera(GWindow ventana) {
        super(ventana);
    }

    @Override
    public void preparar() throws Exception {
        cargarFondo("sprites/fondo escena 3.jpg");
        fondo.addTo(ventana);

        izquierdo1 = new NadadorIzquierdo(1);
        izquierdo2 = new NadadorIzquierdo(2);
        derecho1 = new NadadorDerecho(1);
        derecho2 = new NadadorDerecho(2);
        central1 = new NadadorCentral(1);
        central2 = new NadadorCentral(2);

        izquierdo1.moverPor(30, -15);
        izquierdo2.moverPor(30, -15);
        derecho1.moverPor(-30, -15);
        derecho2.moverPor(-30, -15);
        central1.moverPor(0, -40);
        central2.moverPor(0, -40);

        silbato = new Sonido("audio/escena3_silbato.wav");
        brazadas = new Sonido("audio/escena3_brazadas.wav");
    }

    @Override
    public void reproducir() {
        silbato.tocar();
        Pausa.esperar(500);
        ventana.suspendRepaints();
        mostrarPose(1);
        ventana.resumeRepaints();
        brazadas.repetir();

        // 5 movimientos uno cada 1,5 s avanzan, cambian de brazada.
        for (int salto = 1; salto <= 5; salto++) {
            Pausa.esperar(1500);
            ventana.suspendRepaints();
            quitarPose(pose);
            izquierdo1.moverPor(-6, 3);
            izquierdo2.moverPor(-6, 3);
            derecho1.moverPor(6, 3);
            derecho2.moverPor(6, 3);
            central1.moverPor(0, 8);
            central2.moverPor(0, 8);
            pose = 3 - pose; // alterna 1 y 2
            mostrarPose(pose);
            ventana.resumeRepaints();
        }
        Pausa.esperar(1500);
    }

    @Override
    public void limpiar() {
        silbato.parar();
        brazadas.parar();
        quitarPose(pose);
        quitarFondo();
    }

    private void mostrarPose(int numero) {
        if (numero == 1) {
            izquierdo1.agregarA(ventana);
            derecho1.agregarA(ventana);
            central1.agregarA(ventana);
        } else {
            izquierdo2.agregarA(ventana);
            derecho2.agregarA(ventana);
            central2.agregarA(ventana);
        }
    }

    // Quita de la ventana a los nadadores.
    private void quitarPose(int numero) {
        if (numero == 1) {
            izquierdo1.quitar();
            derecho1.quitar();
            central1.quitar();
        } else {
            izquierdo2.quitar();
            derecho2.quitar();
            central2.quitar();
        }
    }
}
