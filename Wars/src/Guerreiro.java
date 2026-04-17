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
    int sortearVidas() {
        return qtdVidas = 9 + (int)(Math.random() * 4);
    }
    
}
