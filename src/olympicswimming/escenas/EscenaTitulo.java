package olympicswimming.escenas;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Escena 1  título aparece el menú, cursor selecciona "Nueva partida".
// Sprites.
public class EscenaTitulo extends Escena {

    private ImageShape titulo;
    private ImageShape nuevaPartida;
    private ImageShape continuar;
    private HojaSprites hojaCursor;
    private ImageShape cursor;
    private Sonido seleccion;

    public EscenaTitulo(GWindow ventana) {
        super(ventana);
    }

    @Override
    public void preparar() throws Exception {
        cargarFondo("sprites/fondo escena 1.jpg");
        fondo.addTo(ventana);

        // Título inicial 160 px arriba de lugar final .
        titulo = cargarImagen("sprites/titulo.png", 152, 136 - 160);
        titulo.addTo(ventana);

        nuevaPartida = cargarImagen("sprites/nueva partida.png", 283, 249);
        continuar = cargarImagen("sprites/continuar.png", 320, 303);
        // Cursor 2 frames 20 x 20 0 = apagado 1 = prendido.
        hojaCursor = new HojaSprites("sprites/escena1/cursor_menu.png", 20, 20);
        cursor = new ImageShape(hojaCursor.cuadro(0), 253, 246);

        // Suena con parpadeo .
        seleccion = new Sonido("audio/escena1_seleccion.wav");
    }

    @Override
    public void reproducir() {
        Pausa.esperar(800);

        // 1. El título baja 80 px 2 veces .
        for (int i = 0; i < 2; i++) {
            titulo.moveBy(0, 80);
            Pausa.esperar(500);
        }
        Pausa.esperar(500);

        // 2. cursor en "Nueva partida".
        ventana.suspendRepaints();
        nuevaPartida.addTo(ventana);
        continuar.addTo(ventana);
        cursor.addTo(ventana);
        ventana.resumeRepaints();
        Pausa.esperar(600);

        // 3. Cursor parpadea 3 veces cambia cuadro setImage y brilla.
        for (int i = 0; i < 3; i++) {
            cursor.setImage(hojaCursor.cuadro(1));
            seleccion.tocar();
            Pausa.esperar(300);
            cursor.setImage(hojaCursor.cuadro(0));
            Pausa.esperar(300);
        }
        cursor.setImage(hojaCursor.cuadro(1));
        Pausa.esperar(1000);
    }

    @Override
    public void limpiar() {
        seleccion.parar();
        cursor.removeFromWindow();
        continuar.removeFromWindow();
        nuevaPartida.removeFromWindow();
        titulo.removeFromWindow();
        quitarFondo();
    }
}
