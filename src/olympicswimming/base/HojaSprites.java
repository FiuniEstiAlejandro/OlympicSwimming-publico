package olympicswimming.base;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// Un PNG con varios cuadros del mismo tamaño.
// cuadro(i) recorta el cuadro con getSubimage.
public class HojaSprites {

    private BufferedImage hoja;
    private int anchoCuadro;
    private int altoCuadro;

    public HojaSprites(String ruta, int anchoCuadro, int altoCuadro) throws Exception {
        this.hoja = ImageIO.read(new File(ruta));
        this.anchoCuadro = anchoCuadro;
        this.altoCuadro = altoCuadro;
    }

    // Devuelve cuadro numero (inicia en 0).
    public BufferedImage cuadro(int numero) {
        return hoja.getSubimage(numero * anchoCuadro, 0, anchoCuadro, altoCuadro);
    }
}
