package olympicswimming.personajes;

import olympicswimming.base.*;
import uwcse.graphics.*;

// Nadador del carril izquierdo (gorro amarillo).
public class NadadorIzquierdo extends ObjetoGrafico {

    public NadadorIzquierdo(int pose) {
        // Torso y hombros
        agregarForma(new Oval(152, 214, 51, 24, Colores.PIEL, true));
        agregarForma(new Oval(148, 217, 21, 16, Colores.PIEL, true));
        agregarForma(new Oval(184, 213, 21, 16, Colores.PIEL, true));

        // Cara, cara, boca, nariz y oreja
        agregarForma(new Oval(162, 192, 28, 34, Colores.PIEL, true));
        agregarForma(new Rectangle(174, 219, 6, 1, Colores.BOCA, true));
        agregarForma(new Triangle(175, 211, 178, 211, 176, 216, Colores.PIEL_OSCURA, true));
        agregarForma(new Oval(158, 206, 5, 8, Colores.PIEL, true));

        // Gorro y borde
        agregarForma(new Oval(161, 184, 32, 22, Colores.AMARILLO, true));
        agregarForma(new Rectangle(161, 201, 31, 4, Colores.AMARILLO, true));

        // Gafas y cejas
        agregarForma(new Rectangle(161, 206, 30, 2, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(166, 205, 10, 7, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(178, 205, 10, 7, Colores.MARCO_GAFAS, true));
        agregarForma(new Oval(168, 206, 7, 4, Colores.LENTE, true));
        agregarForma(new Oval(180, 206, 7, 4, Colores.LENTE, true));
        agregarForma(new Rectangle(175, 207, 4, 1, Colores.MARCO_GAFAS, true));
        agregarForma(new Rectangle(167, 202, 8, 1, Colores.PELO_CASTANO, true));
        agregarForma(new Rectangle(179, 202, 8, 1, Colores.PELO_CASTANO, true));

        // Brazo  pose 1 = brazo de adelante estira, pose 2 = ese brazo baja y sube el otro.
        if (pose == 1) {
            // Brazo adelante, brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 184, 213, 224, 203, 238, 208, 202, 223));
            agregarForma(new Rectangle(234, 204, 16, 10, Colores.PIEL, true));
            agregarForma(new Oval(246, 202, 13, 10, Colores.PIEL, true));

            // Brazo atrás y mano
            agregarForma(cuadrilatero(Colores.PIEL, 152, 223, 134, 228, 145, 234, 158, 231));
            agregarForma(new Oval(130, 226, 10, 6, Colores.PIEL, true));
        } else {
            // Brazo adelante, brazo, antebrazo y mano
            agregarForma(cuadrilatero(Colores.PIEL, 184, 222, 224, 211, 238, 216, 202, 231));
            agregarForma(new Rectangle(234, 212, 16, 10, Colores.PIEL, true));
            agregarForma(new Oval(246, 210, 13, 10, Colores.PIEL, true));

            // Brazo atrás y mano
            agregarForma(cuadrilatero(Colores.PIEL, 152, 213, 134, 218, 145, 224, 158, 222));
            agregarForma(new Oval(130, 217, 10, 6, Colores.PIEL, true));
        }
    }
}
