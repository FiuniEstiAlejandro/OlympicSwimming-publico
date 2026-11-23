package olympicswimming.escenas;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Escena 2 Charla del baño.
// hijo entra derecha padre izquierda texto aparece saliendo del padre.
public class EscenaVestuario extends Escena {

    // Padre esquina superior izquierda de imagen 260 x 390, hijo 268 x 400.
    private static final int X_PADRE = 60;
    private static final int Y_PADRE = 60;
    private static final int X_HIJO = 590;
    private static final int Y_HIJO = 50;

    // Entran 2 movimientos 100 px moveBy.
    private static final int SALTO = 100;

    private ImageShape padre;
    private ImageShape hijo;
    private ImageShape globo;
    private Sonido texto;

    public EscenaVestuario(GWindow ventana) {
        super(ventana);
    }

    @Override
    public void preparar() throws Exception {
        cargarFondo("sprites/fondo escena 2.jpg");
        fondo.addTo(ventana);

        // Empiezan 200 px afuera de plano.
        padre = cargarImagen("sprites/escena2/padre.png", X_PADRE - 2 * SALTO, Y_PADRE);
        hijo = cargarImagen("sprites/escena2/hijo.png", X_HIJO + 2 * SALTO, Y_HIJO);

        globo = cargarImagen("sprites/globo padre.png", 129, 262);

        // sonido de texto.
        texto = new Sonido("audio/escena2_texto.wav");
    }

    @Override
    public void reproducir() {
        Pausa.esperar(500);

        // 1. Entra padre izquierda 100 px 2 veces.
        padre.addTo(ventana);
        for (int i = 0; i < 2; i++) {
            Pausa.esperar(300);
            padre.moveBy(SALTO, 0);
        }
        Pausa.esperar(500);

        // 2. Entra hijo derecha 100 px 2 vece.
        hijo.addTo(ventana);
        for (int i = 0; i < 2; i++) {
            Pausa.esperar(300);
            hijo.moveBy(-SALTO, 0);
        }
        Pausa.esperar(800);

        // 3. Aparece mensaje.
        globo.addTo(ventana);
        texto.tocar();
        Pausa.esperar(4500);
        globo.removeFromWindow();
        texto.parar();
        Pausa.esperar(300);

        // 4. limpiar escena.
        ventana.suspendRepaints();
        padre.removeFromWindow();
        hijo.removeFromWindow();
        ventana.resumeRepaints();
        Pausa.esperar(500);
    }

    @Override
    public void limpiar() {
        quitarFondo();
    }
}
