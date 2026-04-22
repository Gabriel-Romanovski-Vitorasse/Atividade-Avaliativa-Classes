import Wars.InOut;
public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    
    void definirNome(){
        this.nome = InOut.leString("De um nome para o oraculo: "+"");
    }
    
    String prologoIntroducao(Guerreiro guerreiro){
        warrior = guerreiro;
        warrior.sortearVidas();
        warrior.definirNome();
        InOut.MsgSemIcone("Prologo de Introducao", "Olá "+warrior.nome+", sou o Oraculo "+this.nome+". "
                + "Irei te acompanhar nessa jornada.\n\nVoce possui um total de "+warrior.qtdVidas+" vidas.");
        return "teste";
    }
    
    String prologoPerdedor(){
        InOut.MsgSemIcone("Prologo Perdedor", "Eh uma pena que a nossa jornada "
                + "acabou Guerreiro "+warrior.nome+", deveria ter tomado mais "
                        + "cuidado.\nAte uma proxima!");
        return "You Lose";
    }
    
    String prologoVencedor(){
        return "Fatality. Warrior win!";
    }
    
    boolean loadLevel01()
    {
        boolean Acerto = false;
        InOut.MsgDeAviso("Nível 1", "Estamos adentrando no primeiro nível do Desafio. PREPARE-SE!");
        InOut.MsgDeAviso("Nível 1", "Você deve acertar um número entre 1 e 100 para continuar!!!");
        int numeroCerto = 1 + (int)(Math.random() * 100);
        int numeroEsc;
        System.out.println("TESTE: numero: " + numeroCerto);
        do{
        numeroEsc = InOut.leInt("SEU PALPITE:");
        if(numeroEsc == numeroCerto){
            InOut.MsgDeAviso("PARABENS!", "Você acertou o número. Prossiga para a próxima fase.");
            Acerto = true;
        }
        else{
            warrior.ManipularVidas(1);
            if(numeroEsc > numeroCerto) InOut.MsgDeAviso("ERRADO", "O número é menor que seu palpite.\n VIDAS RESTANTES: " + warrior.qtdVidas);
            else InOut.MsgDeAviso("ERRADO", "O número é maior que seu palpite.\n VIDAS RESTANTES: " + warrior.qtdVidas);
        }  
        }while(warrior.qtdVidas > 0 && !Acerto);
         
        return true;   
    }
    
    boolean loadLevel02(){
        return true;
    }

    public boolean SemVidas(){
        InOut.MsgDeAviso("VOCE ESTA SEM VIDAS!", "O Oraculo ainda te dara chances de viver.\n Mas para isso, tem de pedir misericordia.");
        if(this.decidirVidaExtra(InOut.leString("Clame por misericordia!"))){
            warrior.ManipularVidas(2);
            return true;
        }
        else return false;
    }
    
    private boolean decidirVidaExtra(String frase){
        int qtdPalavras;
        String[] Palavras;
        Palavras = frase.trim().split("\\s+");
        qtdPalavras = Palavras.length;
        return qtdPalavras >= 5;
        
    }
    public void FimGame(){
        
        InOut.MsgDeInformacao("FIM DE JOGO", "Sua condição: VITÓRIA!");
    }
    
}
