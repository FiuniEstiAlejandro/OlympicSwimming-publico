package olympicswimming.escenas;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Escena 4 podio.
// Aparece el podio y los tres nadadores en un movimiento, levanta la medalla.
// sprites.
public class EscenaPodio extends Escena {

    private ImageShape podio;
    private ImageShape segundo;
    private ImageShape tercero;
    private HojaSprites hojaGanador;
    private ImageShape ganador;
    private Sonido redoble;
    private Sonido medalla;
    private Sonido aplauso;

    public EscenaPodio(GWindow ventana) {
        super(ventana);
    }

    @Override
    public void preparar() throws Exception {
        cargarFondo("sprites/fondo escena 4.jpg");

        // podio bloque 1 y = 282.
        podio = cargarImagen("sprites/escena4/podio.png", 210, 282);

        // nadador centrado
        segundo = cargarImagen("sprites/escena4/segundo.png", 218, 101);
        tercero = cargarImagen("sprites/escena4/tercero.png", 477, 117);

        // ganador 2 bloques 120 x 260 0 medalla 1, 1 medalla 2.
        hojaGanador = new HojaSprites("sprites/escena4/ganador.png", 120, 260);
        ganador = new ImageShape(hojaGanador.cuadro(0), 342, 22);

        // tambor 2,8 s mientras espera antes de que el ganador mdealla .
        redoble = new Sonido("audio/escena4_redoble.wav");

        // Levantar medalla sonido medalla aplausos.
        medalla = new Sonido("audio/escena4_medalla.wav");
        aplauso = new Sonido("audio/escena4_aplauso.wav");
    }

    @Override
    public void reproducir() {
        // 1. Fondo
        fondo.addTo(ventana);
        Pausa.esperar(500);

        // 2. podio nadadores
        ventana.suspendRepaints();
        podio.addTo(ventana);
        segundo.addTo(ventana);
        tercero.addTo(ventana);
        ganador.addTo(ventana);
        ventana.resumeRepaints();
        Pausa.esperar(1000);
        redoble.tocar();
        Pausa.esperar(2900);

        // 3. Ganador levanta medalla, cambia el cuadro 1 2,4 s.
        ganador.setImage(hojaGanador.cuadro(1));
        medalla.tocar();
        aplauso.tocar();
        Pausa.esperar(2400);
    }

    @Override
    public void limpiar() {
        redoble.parar();
        medalla.parar();
        aplauso.parar();
        ventana.suspendRepaints();
        ganador.removeFromWindow();
        tercero.removeFromWindow();
        segundo.removeFromWindow();
        podio.removeFromWindow();
        ventana.resumeRepaints();
        quitarFondo();
    }
}
