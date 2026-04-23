import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproduzirSom {
    
    public static void tocarAudio(String caminhoDoArquivo) {
        try {
            File audioFile = new File(caminhoDoArquivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            // Inicia a reprodução em LOOP contínuo (ideal para música de fundo)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception e) {
            System.out.println("Erro ao reproduzir o áudio: " + e.getMessage());
        }
    }
}
