package olympicswimming.base;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

// preparar, reproducir y limpiar.
// ejecutar() llama en orden cada escena.
public abstract class Escena {

    protected GWindow ventana;

    // Imagen de fondo.
    protected ImageShape fondo;

    public Escena(GWindow ventana) {
        this.ventana = ventana;
    }

    // Crea los objetos de la escena 
    public abstract void preparar() throws Exception;

    // La animación
    public abstract void reproducir();

    // vacia la ventana para la siguiente escena.
    public abstract void limpiar();

    public void ejecutar() throws Exception {
        preparar();
        reproducir();
        limpiar();
    }

    // Lee el JPG del fondo 
    // Deja la imagen en 'fondo' con fondo.addTo(ventana).
    protected void cargarFondo(String ruta) throws Exception {
        fondo = new ImageShape(cambiarTamano(ImageIO.read(new File(ruta)), 800, 450), 0, 0);
    }

    // Lee una imagen PNG y la ubica (Todavía no la muestra).
    protected ImageShape cargarImagen(String ruta, int x, int y) throws Exception {
        return new ImageShape(ImageIO.read(new File(ruta)), x, y);
    }

    // Dibuja la imagen en una imagen nueva .
    private BufferedImage cambiarTamano(BufferedImage original, int ancho, int alto) {
        BufferedImage nueva = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D lapiz = nueva.createGraphics();
        lapiz.drawImage(original, 0, 0, ancho, alto, null);
        lapiz.dispose();
        return nueva;
    }

    protected void quitarFondo() {
        fondo.removeFromWindow();
    }
}
