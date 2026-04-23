

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musica {
    private Clip clip;

    public void tocar(String caminho) {
        try {
            File msc = new File(caminho);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(msc);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void parar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}

