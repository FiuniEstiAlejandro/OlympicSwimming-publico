package olympicswimming.base;

import java.awt.Color;
import java.util.ArrayList;
import uwcse.graphics.*;

// Objeto complejo hecho de muchas figuras: las guarda en una lista
// para agregarlas, moverlas y quitarlas todas juntas.
public class ObjetoGrafico {

    protected ArrayList<Shape> formas = new ArrayList<>();

    protected void agregarForma(Shape forma) {
        formas.add(forma);
    }

    // Figura de 4 esquinas (para brazos inclinados): x1, y1, x2, y2, x3, y3, x4, y4.
    protected Polygon cuadrilatero(Color color /* color de relleno */,
                                   int x1 /* posición  inicial X de la esquina 1*/,
                                   int y1 /* posición inicial Y de la esquina 1*/,
                                   int x2 /* posición final X de la esquina 2*/,
                                   int y2 /* posición final Y de la esquina 2*/,
                                   int x3 /* posición inicial 2 X de la esquina 3*/,
                                   int y3 /* posición inicial 2 Y de la esquina 3*/,
                                   int x4 /* posición final 2 X de la esquina 4*/,
                                   int y4 /* posición final 2 Y de la esquina 4*/) {
        Polygon forma = new Polygon(color, true);
        forma.addPoint(x1, y1);
        forma.addPoint(x2, y2);
        forma.addPoint(x3, y3);
        forma.addPoint(x4, y4);
        return forma;
    }

    // Agrega todas las figuras a la ventana.
    public void agregarA(GWindow ventana) {
        for (Shape forma : formas) {
            forma.addTo(ventana);
        }
    }

    // Mueve todas las figuras con moveBy.
    public void moverPor(int dx, int dy) {
        for (Shape forma : formas) {
            forma.moveBy(dx, dy);
        }
    }

    public void quitar() {
        for (Shape forma : formas) {
            forma.removeFromWindow();
        }
    }
}
