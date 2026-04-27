package Wars;

public class Menu {
    public static int mostrarMenuJogo() {
        
        // 1. As opções ficam aqui dentro, protegidas
        String[] acoes = {"Iniciar o Jogo", "Menu de Itens", "Sair"};

        // 2. O menu é chamado e guardamos a resposta
        int acaoEscolhida = InOut.MenuBotoes(
            "Hud do Jogo", 
            "Quais das opcoes abaixo deseja escolher?", 
            acoes
        );
        
        // 3. Devolvemos o número do botão que o jogador clicou
        return acaoEscolhida;
    }
    
    public static int mostrarMenuItens() {
        
        // 1. As opções ficam aqui dentro, protegidas
        String[] acoes = {"Mostrar Itens","Equipar Itens", "Desequipar Itens"};

        // 2. O menu é chamado e guardamos a resposta
        int acaoEscolhida = InOut.MenuBotoes(
            "Hud do Jogo", 
            "Quais das opcoes abaixo deseja escolher?", 
            acoes
        );
        
        // 3. Devolvemos o número do botão que o jogador clicou
        return acaoEscolhida;
    }
}
