import Wars.InOut;

public class Main {
    public static void main(String[] args) {
        Oraculo oc01 = new Oraculo();
        Guerreiro g01 = new Guerreiro();
        Bolsa myBolsa = new Bolsa();
        Item item01 = new Item(1, "Arma", false);
        Item item02 = new Item(2, "Poca", true);
        Musica musica = new Musica();
        

        oc01.definirNome();
        oc01.prologoIntroducao(g01);
        oc01.loadLevel01();
        musica.tocar("Wars/Midia/adventure.wav.wav");

        if (g01.qtdVidas > 0) {
            oc01.loadLevel2();
        } else {
            if (oc01.SemVidas()) {
                oc01.prologoPerdedor();
            }
            oc01.FimGame(oc01.prologoVencedor());
            return; 
        }

        if (g01.qtdVidas > 0) {
            oc01.LoadLevel3();
            if (g01.qtdVidas > 0) {
                oc01.FimGame(oc01.prologoVencedor());
                musica.tocar("Wars/Midia/watermellon.wav.wav");
            } else {
                oc01.FimGame(oc01.prologoPerdedor());
            }
        } else {
 
            oc01.FimGame(oc01.prologoPerdedor());
        }
    }
}