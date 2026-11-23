package olympicswimming;

import olympicswimming.base.Escena;
import olympicswimming.escenas.*;
import uwcse.graphics.GWindow;

// Programa principal: crea la ventana y ejecuta las escenas en orden.
public class AvancePelicula {

    public static void main(String[] args) throws Exception {
        GWindow ventana = new GWindow("Olympic Swimming", 800, 450);
        ventana.setExitOnClose();

        // Las escenas en el orden de la película (cada una es una Escena: se ejecuta igual que las demás).
        Escena[] escenas = {
            new EscenaTitulo(ventana),
            new EscenaVestuario(ventana),
            new EscenaCarrera(ventana),
            new EscenaPodio(ventana)
        };
        for (Escena escena : escenas) {
            escena.ejecutar();
        }
    }
}
