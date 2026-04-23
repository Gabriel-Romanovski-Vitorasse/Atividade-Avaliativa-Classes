public class Credito {
    private double saldo;
    private String validade;
    private String moeda;
    private boolean bloqueado;

    public Credito(double saldo, String validade, String moeda, boolean bloqueado) {
        this.saldo = saldo;
        this.validade = validade;
        this.moeda = moeda;
        this.bloqueado = bloqueado;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getValidade() {
        return validade;
    }

    public String getMoeda() {
        return moeda;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean debitar(double valor) {
        if (bloqueado) {
            InOut.MsgDeErro("Erro", "Crédito bloqueado.");
            return false;
        }

        if (valor <= 0) {
            InOut.MsgDeErro("Erro", "Valor inválido.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            InOut.MsgDeErro("Erro", "Saldo insuficiente.");
            return false;
        }
    }

    public void creditar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    @Override
    public String toString() {
        return "Credito{" +
                "saldo=" + saldo +
                ", validade='" + validade + '\'' +
                ", moeda='" + moeda + '\'' +
                ", bloqueado=" + bloqueado +
                '}';
    }
}
