import java.util.ArrayList;
import java.util.List;

public class Aposta {
    private int idAposta;
    private double valorAposta;
    private int repetir;
    private List<Jogo> jogos;

    public Aposta(int idAposta, double valorAposta, int repetir) {
        this.idAposta = idAposta;
        this.valorAposta = valorAposta;
        this.repetir = repetir;
        this.jogos = new ArrayList<>();
    }

    public int getIdAposta() {
        return idAposta;
    }

    public double getValorAposta() {
        return valorAposta;
    }

    public int getRepetir() {
        return repetir;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setValorAposta(double valorAposta) {
        this.valorAposta = valorAposta;
    }

    public void setRepetir(int repetir) {
        this.repetir = repetir;
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public void removerJogo(int idJogo) {
        jogos.removeIf(j -> j.getIdJogo() == idJogo);
    }

    public double calcularValorTotal() {
        return valorAposta * repetir;
    }

    @Override
    public String toString() {
        return "Aposta{" +
                "idAposta=" + idAposta +
                ", valorAposta=" + valorAposta +
                ", repetir=" + repetir +
                ", total=" + calcularValorTotal() +
                ", jogos=" + jogos +
                '}';
    }
}
