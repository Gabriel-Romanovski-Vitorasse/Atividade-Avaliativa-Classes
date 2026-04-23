void main(){
    ReproduzirSom.tocarAudio("C:\\Users\\ADM\\Documents\\GitHub\\Atividade-Avaliativa-Classes\\Wars\\midia\\adventure.wav.wav");
    Oraculo oc01 = new Oraculo();
    Guerreiro g01 =  new Guerreiro();
    Bolsa myBolsa = new Bolsa();
    Item item01 = new Item(01,"Arma", false);
    Item item02 = new Item(02,"Poca", true);
  
    
    
    oc01.definirNome();
    oc01.prologoIntroducao(g01);
    
    oc01.loadLevel01();
    oc01.loadLevel2();
}