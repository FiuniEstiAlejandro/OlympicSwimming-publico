package olympicswimming.personajes;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Nadador del carril central (gorro rojo).
public class NadadorCentral extends ObjetoGrafico {

    public NadadorCentral(int pose) {
        // Torso y hombros
        agregarForma(new Oval(338, 236, 94, 50, Colores.PIEL, true));
        agregarForma(new Oval(332, 240, 38, 32, Colores.PIEL, true));
        agregarForma(new Oval(396, 234, 44, 32, Colores.PIEL, true));

        // Cara, cara, boca, nariz y orejas
        agregarForma(new Oval(370, 198, 58, 66, Colores.PIEL, true));
        agregarForma(new Rectangle(392, 250, 14, 3, Colores.BOCA, true));
        agregarForma(new Triangle(396, 232, 404, 232, 400, 242, Colores.PIEL_OSCURA, true));
        agregarForma(new Oval(364, 222, 10, 16, Colores.PIEL, true));
        agregarForma(new Oval(426, 222, 10, 16, Colores.PIEL, true));
//ayudalol
        // Gorro, gorro, borde y brillo
        agregarForma(new Oval(366, 186, 64, 46, Colores.GORRO_ROJO, true));
        agregarForma(new Rectangle(368, 214, 60, 8, Colores.GORRO_ROJO, true));
        agregarForma(new Arc(380, 190, 40, 24, 30, 130, Colores.GORRO_ROJO_BRILLO, false));

        // Gafas, tira, marcos, lentes , puente, luego las cejas
        agregarForma(new Rectangle(368, 224, 64, 4, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(374, 222, 22, 14, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(404, 222, 22, 14, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(377, 224, 16, 10, Colores.LENTE, true));
        agregarForma(new Oval(407, 224, 16, 10, Colores.LENTE, true));
        agregarForma(new Rectangle(394, 226, 12, 3, Colores.MARCO_GAFAS, true));
        agregarForma(new Rectangle(376, 216, 18, 3, Colores.PELO_CASTANO, true));
        agregarForma(new Rectangle(406, 216, 18, 3, Colores.PELO_CASTANO, true));

        // Brazo pose 1 = brazo derecho sube, pose 2 = brazo izquierdo sube.
        if (pose == 1) {
            // Brazo sube, brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 424, 234, 492, 158, 502, 176, 450, 250));
            agregarForma(new Rectangle(498, 160, 20, 68, Colores.PIEL, true));
            agregarForma(new Oval(498, 218, 22, 20, Colores.PIEL, true));

            // Brazo bajo y su mano
            agregarForma(new Oval(310, 256, 40, 20, Colores.PIEL, true));
            agregarForma(new Oval(330, 266, 18, 10, Colores.PIEL, true));
        } else {
            // Brazo sube ,brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 376, 234, 308, 158, 298, 176, 350, 250));
            agregarForma(new Rectangle(282, 160, 20, 68, Colores.PIEL, true));
            agregarForma(new Oval(280, 218, 22, 20, Colores.PIEL, true));
//odio los poligonos 
            // Brazo bajo y su mano
            agregarForma(new Oval(450, 256, 40, 20, Colores.PIEL, true));
            agregarForma(new Oval(452, 266, 18, 10, Colores.PIEL, true));
        }
    }
}
