import Wars.InOut;

void main(){
    Oraculo oc01 = new Oraculo();
    Bolsa myBolsa = new Bolsa();
    Item item01 = new Item(01,"Arma", true);
    Item item02 = new Item(02,"Poca", true);
    
    InOut.MsgDeInformacao("teste", oc01.definirNome(nome));
    
    myBolsa.equipar(item01);
    myBolsa.equipar(item02);
    System.out.println("");
    item01.ImprimirDados();
}
