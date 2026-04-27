import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int idJogador;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String cpf;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private Credito credito;
    private List<Aposta> apostas;

    public Jogador(int idJogador, String nome, String sobrenome, String apelido,
                   String cpf, String nacionalidade, LocalDate dataNascimento, Credito credito) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.credito = credito;
        this.apostas = new ArrayList<>();
    }

    public int getIdJogador() {
        return idJogador;
    }

    public String getNome() {
        return nome;
    }

    public Credito getCredito() {
        return credito;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public boolean criarAposta(Aposta aposta) {
        double total = aposta.calcularValorTotal();

        if (credito.debitar(total)) {
            apostas.add(aposta);
            InOut.MsgDeInformacao("Sucesso", "Aposta criada com sucesso.");
            return true;
        }

        return false;
    }

    public void listarApostas() {
        if (apostas.isEmpty()) {
            InOut.MsgDeAviso("Aviso", "Nenhuma aposta cadastrada.");
            return;
        }

        StringBuilder lista = new StringBuilder("LISTA DE APOSTAS\n\n");
        for (Aposta a : apostas) {
            lista.append(a.toString()).append("\n\n");
        }
        InOut.MsgSemIcone("Apostas", lista.toString());
    }

    public Aposta buscarAposta(int idAposta) {
        for (Aposta a : apostas) {
            if (a.getIdAposta() == idAposta) {
                return a;
            }
        }
        return null;
    }

    public boolean atualizarAposta(int idAposta, double novoValor, int novoRepetir) {
        Aposta aposta = buscarAposta(idAposta);

        if (aposta == null) {
            InOut.MsgDeErro("Erro", "Aposta não encontrada.");
            return false;
        }

        double valorAntigo = aposta.calcularValorTotal();
        double valorNovo = novoValor * novoRepetir;
        double diferenca = valorNovo - valorAntigo;

        if (diferenca > 0) {
            if (!credito.debitar(diferenca)) {
                InOut.MsgDeErro("Erro", "Saldo insuficiente para atualizar a aposta.");
                return false;
            }
        } else if (diferenca < 0) {
            credito.creditar(Math.abs(diferenca));
        }

        aposta.setValorAposta(novoValor);
        aposta.setRepetir(novoRepetir);

        InOut.MsgDeInformacao("Sucesso", "Aposta atualizada com sucesso.");
        return true;
    }

    public boolean removerAposta(int idAposta) {
        Aposta aposta = buscarAposta(idAposta);

        if (aposta == null) {
            InOut.MsgDeErro("Erro", "Aposta não encontrada.");
            return false;
        }

        credito.creditar(aposta.calcularValorTotal());
        apostas.remove(aposta);
        InOut.MsgDeInformacao("Sucesso", "Aposta removida com sucesso.");
        return true;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "idJogador=" + idJogador +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", credito=" + credito +
                '}';
    }
}

