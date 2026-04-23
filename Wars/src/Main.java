public class Main {
    public static void main(String[] args) {
        Oraculo oc01 = new Oraculo();
        Guerreiro g01 = new Guerreiro();
        Bolsa myBolsa = new Bolsa();
        Item item01 = new Item(1, "Arma", false);
        Item item02 = new Item(2, "Poca", true);
        
        for(int i = 0;i < 3;i++){
            oc01.definirNome();
            ReproduzirSom.tocar("../Wars/Midia/adventure.wav");
            oc01.prologoIntroducao(g01);
            oc01.loadLevel01();
            oc01.loadLevel02();
            oc01.LoadLevel03();
        }
    }
}   