public class Guerreiro {
    private String nome;
    private int qtdVidas;
    private Bolsa myBolsa;
    
    String vidaExtra(){
        return "teste";
    }
    
    private int sortearVidas() {
        return this.qtdVidas = 9 + (int)(Math.random() * 4);
    }
    
}
