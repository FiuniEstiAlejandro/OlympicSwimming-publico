package olympicswimming.base;

import java.io.File;
import javax.sound.sampled.*;


// El sonido corre independiente a la animacion.
public class Sonido {

    private Clip clip;

    // Abre el archivo y lo carga en el clip (todavía no suena).
    public Sonido(String ruta) throws Exception {
        clip = AudioSystem.getClip();
        try (AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta))) {
            clip.open(audio);
        }
    }

    // Suena una vez desde el principio.
    public void tocar() {
        clip.setFramePosition(0);
        clip.start();
    }

    // Suena una y otra vez hasta que se llame a parar().
    public void repetir() {
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Detiene el sonido y libera el clip.
    public void parar() {
        clip.stop();
        clip.close();
    }
}
