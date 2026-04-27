import java.time.LocalDate;

public class SistemaApostas {

    public static void main(String[] args) {
        Credito credito = new Credito(1000.0, "12/2026", "BRL", false);
        Jogador jogador = new Jogador(
                1,
                "Isaque",
                "Monteiro",
                "Isa",
                "123.456.789-00",
                "Brasileiro",
                LocalDate.of(2000, 1, 1),
                credito
        );

        int opcao;

        do {
            opcao = InOut.leInt(
                    "===== MENU SISTEMA DE APOSTAS =====\n" +
                    "1 - Mostrar jogador\n" +
                    "2 - Criar aposta\n" +
                    "3 - Listar apostas\n" +
                    "4 - Atualizar aposta\n" +
                    "5 - Remover aposta\n" +
                    "6 - Consultar saldo\n" +
                    "7 - Bloquear/Desbloquear crédito\n" +
                    "0 - Sair"
            );

            switch (opcao) {
                case 1:
                    InOut.MsgSemIcone("Jogador", jogador.toString());
                    break;

                case 2:
                    criarAposta(jogador);
                    break;

                case 3:
                    jogador.listarApostas();
                    break;

                case 4:
                    atualizarAposta(jogador);
                    break;

                case 5:
                    removerAposta(jogador);
                    break;

                case 6:
                    InOut.MsgDeInformacao(
                            "Saldo",
                            "Saldo atual: " + jogador.getCredito().getSaldo() + " " + jogador.getCredito().getMoeda()
                    );
                    break;

                case 7:
                    boolean statusAtual = jogador.getCredito().isBloqueado();
                    jogador.getCredito().setBloqueado(!statusAtual);
                    InOut.MsgDeInformacao(
                            "Status do Crédito",
                            jogador.getCredito().isBloqueado() ? "Crédito BLOQUEADO" : "Crédito DESBLOQUEADO"
                    );
                    break;

                case 0:
                    InOut.MsgDeInformacao("Sistema", "Encerrando sistema...");
                    break;

                default:
                    InOut.MsgDeErro("Erro", "Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void criarAposta(Jogador jogador) {
        int idAposta = InOut.leInt("ID da aposta:");
        double valorAposta = InOut.leDouble("Valor da aposta:");
        int repetir = InOut.leInt("Quantidade de repetições:");

        Aposta aposta = new Aposta(idAposta, valorAposta, repetir);

        int qtdJogos = InOut.leInt("Quantos jogos deseja adicionar nessa aposta?");

        for (int i = 0; i < qtdJogos; i++) {
            int idJogo = InOut.leInt("ID do jogo " + (i + 1) + ":");
            String descritivo = InOut.leString("Descritivo do jogo " + (i + 1) + ":");
            double apostaMax = InOut.leDouble("Aposta máxima do jogo:");
            double premioMax = InOut.leDouble("Prêmio máximo do jogo:");

            if (valorAposta > apostaMax) {
                InOut.MsgDeErro("Erro", "Valor da aposta maior que a aposta máxima permitida para esse jogo.");
            } else {
                Jogo jogo = new Jogo(idJogo, descritivo, apostaMax, premioMax);
                aposta.adicionarJogo(jogo);
            }
        }

        jogador.criarAposta(aposta);
    }

    public static void atualizarAposta(Jogador jogador) {
        int id = InOut.leInt("Digite o ID da aposta que deseja atualizar:");
        double novoValor = InOut.leDouble("Novo valor da aposta:");
        int novoRepetir = InOut.leInt("Nova quantidade de repetições:");

        jogador.atualizarAposta(id, novoValor, novoRepetir);
    }

    public static void removerAposta(Jogador jogador) {
        int id = InOut.leInt("Digite o ID da aposta que deseja remover:");
        jogador.removerAposta(id);
    }
}
