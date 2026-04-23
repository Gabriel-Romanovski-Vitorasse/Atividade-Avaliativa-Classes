import java.util.ArrayList;
import Wars.InOut;
public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    private boolean cheat = false; // Ativa ou desativa as trapaças pra fim de teste
    private int vidasperdidas = 0;
    ArrayList<Integer> respostasLV1 = new ArrayList<>();
    ArrayList<String> respostasLV2 = new ArrayList<>();
    ArrayList<Integer> respostasLV3 = new ArrayList<>();
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
        return "derrota";
    }
    
    String prologoVencedor(){
        InOut.MsgSemIcone("VITÓRIA!", "Parabéns! Você conseguiu!");
        return "vitoria";
    }
    
    boolean loadLevel01()
    {
        boolean Acerto = false;
        InOut.MsgDeAviso("Nível 1", "Estamos adentrando no primeiro desafio da jornada. PREPARE-SE!");
        InOut.MsgDeAviso("Nível 1", "Você deve acertar um número entre 1 e 100 para continuar!!!");
        int numeroCerto = 1 + (int)(Math.random() * 100);
        int numeroEsc;
        if(cheat) System.out.println("número correto " + numeroCerto);
        do{
        numeroEsc = InOut.leInt("SEU PALPITE:");
        respostasLV1.add(numeroEsc);
        if(numeroEsc == numeroCerto){
            InOut.MsgDeAviso("PARABENS!", "Você acertou o número. Prossiga para a próxima fase.");
            Acerto = true;
        }
        else{
            warrior.ManipularVidas(1);
            if(numeroEsc > numeroCerto) InOut.MsgDeAviso("ERRADO", "O número é menor que seu palpite.\n VIDAS RESTANTES: " + warrior.qtdVidas);
            else InOut.MsgDeAviso("ERRADO", "O número é maior que seu palpite.\n VIDAS RESTANTES: " + warrior.qtdVidas);
            vidasperdidas++;
        }  
        }while(warrior.qtdVidas > 0 && !Acerto);
                // Resultado final
        
        return true;
           
    }
    
    boolean loadLevel2() {
        String resposta;
        boolean Ac1 = false;
        boolean Ac2 = false;
        boolean Ac3 = false;        
        InOut.MsgDeAviso("Nível 2", "Estamos adentrando no segundo desafio da jornada. PREPARE-SE!");
        if(cheat)System.out.println("Charas: Buraco, Nuvem, Pente");
       do{
            
        if(!Ac1){
            resposta = InOut.leString("Primeira Carada. \nO que é, o que é? Quanto mais você tira, maior fica?");
            if (!resposta.equalsIgnoreCase("buraco")) {
            warrior.ManipularVidas(1);
            InOut.MsgDeAviso("Resposta Incorreta.", "Errou! Vidas restantes: " + warrior.qtdVidas);
            respostasLV2.add(resposta);
            vidasperdidas++;
        }
        else{
            InOut.MsgDeAviso("Resposta correta!", "Vamos para a próxima!");
            Ac1 = true;
        }
        }

        if(!Ac2){
            resposta = InOut.leString("Segunda Charada. \nO que é, o que é? Anda sem pernas e chora sem olhos?");
        if (!resposta.equalsIgnoreCase("nuvem")) {
            warrior.ManipularVidas(1);
            InOut.MsgDeAviso("Resposta Incorreta.", "Errou! Vidas restantes: " + warrior.qtdVidas);
            respostasLV2.add(resposta);
            vidasperdidas++;
        }
        else{
            InOut.MsgDeAviso("Resposta correta!", "Vamos para a próxima!");
            Ac2 = true;
        }
        }
        
        if(!Ac3){
           resposta = InOut.leString("Terceira Carada. \nO que é, o que é? Tem dentes mas não morde?");
        if (!resposta.equalsIgnoreCase("pente")) {
            warrior.ManipularVidas(1);
            InOut.MsgDeAviso("Resposta Incorreta.", "Errou! Vidas restantes: " + warrior.qtdVidas);
            respostasLV2.add(resposta);
            vidasperdidas++;
        }
        else{
            InOut.MsgDeAviso("Resposta correta!", "Vamos para a próxima!");
            Ac3 = true;
        }
        }

        
       }while(warrior.qtdVidas > 0 && !Ac1 && !Ac2 && !Ac3);

        return true;
    }
    
    public boolean LoadLevel3(){
        int[] sequencia = {0 + (int)(Math.random() * 10), 0 + (int)(Math.random() * 10), 0 + (int)(Math.random() * 10)};
        int resp;
        boolean Ac1 = false;
        boolean Ac2 = false;
        boolean Ac3 = false;
        InOut.MsgDeAviso("Nível 3", "Estamos entrando no nível 3! Está quase lá!");
        InOut.MsgDeAviso("Nível 3", "Para este nível, você deve acertar uma sequência de 3 números entre 1 a 10 para destravar a passagem!");
        if(cheat)System.out.println("Sequencia: " + sequencia[0] + sequencia[1] + sequencia[2]);
        do{ 
          resp = InOut.leInt("Insira o primeiro número");
            
          if(!Ac1){
            if (resp == sequencia[0]){
                System.out.println("teste: " + sequencia[0]);
              InOut.MsgDeInformacao("NÍVEL 3", "VOCÊ ACERTOU! Número: " + sequencia[0]);
              respostasLV3.add(resp);
              Ac1 = true;
            }
            else{
              warrior.ManipularVidas(1);
              InOut.MsgDeErro("INCORRETO", "Você não acertou o primeiro número da sequência! Vidas restantes: " + warrior.qtdVidas);
              vidasperdidas++;
                }
           }

          if(!Ac2){
              System.out.println("teste: " + sequencia[1]);
           resp = InOut.leInt("Insira o segundo número");
           if(resp == sequencia[1]) {
              InOut.MsgDeInformacao("NÍVEL 3", "VOCÊ ACERTOU! Número: " + sequencia[1]);
              respostasLV3.add(resp);
              Ac2 = true;
            }
           else{
            warrior.ManipularVidas(1);
             InOut.MsgDeErro("INCORRETO", "Você não acertou o segundo número da sequência! Vidas restantes: " + warrior.qtdVidas);
             vidasperdidas++;
            }
         }
        
          if(!Ac3){
              System.out.println("teste: " + sequencia[2]);
           resp = InOut.leInt("Insira o terceiro número");
           if(resp == sequencia[2]) {
              InOut.MsgDeInformacao("NÍVEL 3", "VOCÊ ACERTOU! Número: " + sequencia[2]);
              respostasLV3.add(resp);
              Ac3 = true;
            }
           else{
            warrior.ManipularVidas(1);
             InOut.MsgDeErro("INCORRETO", "Você não acertou o terceiro número da sequência! Vidas restantes: " + warrior.qtdVidas);
             vidasperdidas++;
            }
         }
       }while(warrior.qtdVidas > 0 && !(Ac1 && Ac2 && Ac3));
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
    
    private boolean VidaExtra(){
        if(SemVidas()){
            InOut.MsgDeInformacao("PARABENS!", "Suas presses forama atendidas. Vida extra concedida.");
            InOut.MsgDeInformacao("VIDA EXTRA CONCEDIDA", "Vidas: " + warrior.qtdVidas);
            warrior.ManipularVidas(2);
        }
        else{
            InOut.MsgDeAviso("Ah, não!", "Você não clamou o suficiente...");
            prologoPerdedor();
        }
        return true;
    }
    
    private boolean decidirVidaExtra(String frase){
        int qtdPalavras;
        String[] Palavras;
        Palavras = frase.trim().split("\\s+");
        qtdPalavras = Palavras.length;
        return qtdPalavras >= 5;
        
    }
    public void FimGame(String resultado){
        if(resultado.equalsIgnoreCase("vitoria")){
            InOut.MsgSemIcone("VENCEDOR!", "Estatísticas: "
                + "\nNome do guerreiro: " + warrior.nome
                + "\nNome do oraculo: " + this.nome
                + "\nVidas perdidas: " + vidasperdidas
                + "\nAte a proxima!");
        }
        
        
    }
    
}
