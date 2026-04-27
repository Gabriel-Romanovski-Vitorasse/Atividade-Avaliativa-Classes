public class Jogo {
    private int idJogo;
    private String descritivo;
    private double apostaMax;
    private double premioMax;

    public Jogo(int idJogo, String descritivo, double apostaMax, double premioMax) {
        this.idJogo = idJogo;
        this.descritivo = descritivo;
        this.apostaMax = apostaMax;
        this.premioMax = premioMax;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public double getApostaMax() {
        return apostaMax;
    }

    public double getPremioMax() {
        return premioMax;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public void setApostaMax(double apostaMax) {
        this.apostaMax = apostaMax;
    }

    public void setPremioMax(double premioMax) {
        this.premioMax = premioMax;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "idJogo=" + idJogo +
                ", descritivo='" + descritivo + '\'' +
                ", apostaMax=" + apostaMax +
                ", premioMax=" + premioMax +
                '}';
    }
}
