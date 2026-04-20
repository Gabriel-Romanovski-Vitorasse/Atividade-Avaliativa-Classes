import Wars.InOut;

public class Guerreiro {
    protected String nome;
    protected int qtdVidas;
    protected Bolsa myBolsa;
    
    
    protected void definirNome(){
        nome = InOut.leString("Qual é o seu nome Guerreiro: "+"");
    }
    int sortearVidas() {
        return qtdVidas = 9 + (int)(Math.random() * 4);
    }
    public boolean ManipularVidas(int resp){     
        if(resp == 1){
           return this.RetirarVida();
        }
        else{
           return this.AcrescentarVida();
        }
    }
    private boolean RetirarVida(){
        if(qtdVidas <= 0){
            return false;
        }
        else{
            qtdVidas--;
            return true;
        }
    }
    private boolean AcrescentarVida(){
            qtdVidas++;
            return true;
    }
    
        
        
    
    
}
