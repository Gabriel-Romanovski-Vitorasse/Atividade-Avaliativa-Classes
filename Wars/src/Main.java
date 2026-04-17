import Wars.InOut;

void main(){
    Oraculo oc01 = new Oraculo();
    Guerreiro g01 =  new Guerreiro();
    Bolsa myBolsa = new Bolsa();
    Item item01 = new Item(01,"Arma", false);
    Item item02 = new Item(02,"Poca", true);
    
    
    
    oc01.definirNome();
    oc01.prologoIntroducao(g01);
    
    myBolsa.adicionarItem(item01);
    myBolsa.adicionarItem(item02);
    
    item01.ImprimirDados();
    myBolsa.equipar(item01);
    item01.ImprimirDados();
}
