package olympicswimming.personajes;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Nadador del carril derecho (gorro verde).
public class NadadorDerecho extends ObjetoGrafico {

    public NadadorDerecho(int pose) {
        // Torso y hombros
        agregarForma(new Oval(597, 214, 51, 24, Colores.PIEL, true));
        agregarForma(new Oval(631, 217, 21, 16, Colores.PIEL, true));
        agregarForma(new Oval(594, 213, 21, 16, Colores.PIEL, true));

        // Cara, cara, boca, nariz y una oreja
        agregarForma(new Oval(610, 192, 28, 34, Colores.PIEL, true));
        agregarForma(new Rectangle(620, 219, 6, 1, Colores.BOCA, true));
        agregarForma(new Triangle(625, 211, 622, 211, 624, 216, Colores.PIEL_OSCURA, true));
        agregarForma(new Oval(636, 206, 5, 8, Colores.PIEL, true));

        // Gorro y borde
        agregarForma(new Oval(608, 184, 32, 22, Colores.GORRO_VERDE, true));
        agregarForma(new Rectangle(609, 201, 31, 4, Colores.GORRO_VERDE, true));

        // Gafas y cejas
        agregarForma(new Rectangle(609, 206, 30, 2, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(624, 205, 10, 7, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(612, 205, 10, 7, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(625, 206, 7, 4, Colores.LENTE, true));
        agregarForma(new Oval(613, 206, 7, 4, Colores.LENTE, true));
        agregarForma(new Rectangle(621, 207, 4, 1, Colores.MARCO_GAFAS, true));
        agregarForma(new Rectangle(625, 202, 8, 1, Colores.PELO_CASTANO, true));
        agregarForma(new Rectangle(612, 202, 8, 1, Colores.PELO_CASTANO, true));

        // Brazo pose 1 = brazo de adelante estira, pose 2 = ese brazo baja sube el otro.
        if (pose == 1) {
            // Brazo delante, brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 616, 213, 576, 203, 562, 208, 598, 223));
            agregarForma(new Rectangle(549, 204, 16, 10, Colores.PIEL, true));
            agregarForma(new Oval(540, 202, 13, 10, Colores.PIEL, true));

            // Brazo atrás y mano
            agregarForma(cuadrilatero(Colores.PIEL, 648, 223, 666, 228, 655, 234, 642, 231));
            agregarForma(new Oval(660, 226, 10, 6, Colores.PIEL, true));
        } else {
            // Brazo adelante, brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 616, 222, 576, 211, 562, 216, 598, 231));
            agregarForma(new Rectangle(549, 212, 16, 10, Colores.PIEL, true));
            agregarForma(new Oval(540, 210, 13, 10, Colores.PIEL, true));

            // Brazo atrás y mano
            agregarForma(cuadrilatero(Colores.PIEL, 648, 213, 666, 218, 655, 224, 642, 222));
            agregarForma(new Oval(660, 217, 10, 6, Colores.PIEL, true));
        }
    }
}
