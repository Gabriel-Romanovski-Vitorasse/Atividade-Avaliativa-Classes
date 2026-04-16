import Wars.InOut;

public class Guerreiro {
    protected String nome;
    protected int qtdVidas;
    protected Bolsa myBolsa;
    
    String vidaExtra(){
        return "teste";
    }
    
    protected void definirNome(){
        nome = InOut.leString("Qual é o seu nome Guerreiro: "+"");
    }
    private int sortearVidas() {
        return this.qtdVidas = 9 + (int)(Math.random() * 4);
    }
    
}
