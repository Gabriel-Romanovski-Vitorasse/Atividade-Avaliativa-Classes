import Wars.InOut;

void main(){
    Oraculo oc01 = new Oraculo();
    Guerreiro g01 =  new Guerreiro();
    Bolsa myBolsa = new Bolsa();
    Item item01 = new Item(01,"Arma", false);
    Item item02 = new Item(02,"Poca", true);
    
    boolean guerreiroDerrotado = false;
    
    
    oc01.definirNome();
    oc01.prologoIntroducao(g01);
    
    myBolsa.adicionarItem(item01);
    myBolsa.adicionarItem(item02);
    
    item01.ImprimirDados();
    myBolsa.equipar(item01);
    item01.ImprimirDados();
    
    oc01.loadLevel01();
    if(g01.qtdVidas == 0){
        if(oc01.SemVidas()){
            InOut.MsgDeInformacao("PARABENS!", "Suas presses forama atendidas. Vida extra concedida.");
            InOut.MsgDeInformacao("VIDA EXTRA CONCEDIDA", "Vidas: " + g01.qtdVidas);
            g01.ManipularVidas(2);
        }
        else{
            InOut.MsgDeAviso("Ah, não!", "Você não clamou o suficiente...");
            oc01.prologoPerdedor();
        }
    }
    if(!guerreiroDerrotado) oc01.loadLevel02();
    //if(g01.qtdVidas == 0){ guerreiroDerrotado = !oc01.SemVidas(); }
    //if(!guerreiroDerrotado) oc01.loadLevel03();
    //if(guerreiroDerrotado){ oc01.prologoPerdedor(); }
    
    
}
