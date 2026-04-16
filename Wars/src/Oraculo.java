import Wars.InOut;
public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    
    void definirNome(){
        this.nome = InOut.leString("De um nome para o oraculo: "+"");
    }
    
    String prologoIntroducao(){
        warrior.definirNome();
        InOut.MsgSemIcone("Prologo de Introducao", "Olá "+warrior.nome+", sou o Oraculo "+this.nome+". "
                + "Irei te acompanhar nessa jornada. Voce possui um total de "+warrior.qtdVidas);
        return "teste";
    }
    
    String prologoPerdedor(){
        return "You Lose";
    }
    
    String prologoVencedor(){
        return "Fatality. Warrior win!";
    }
    
    boolean loadLevel01(){
        return true;
    }
    
    boolean loadLevel02(){
        return true;
    }
    
    boolean decidirVidaExtra(String frase){
        return true;
    }
    
}
