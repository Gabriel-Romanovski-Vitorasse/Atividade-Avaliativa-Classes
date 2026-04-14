public class Oraculo {
    private String nome;
    private Guerreiro warrior;
    
    void definirNome(String nome){
        this.nome = nome;
    }
    
    String prologoIntroducao(){
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
