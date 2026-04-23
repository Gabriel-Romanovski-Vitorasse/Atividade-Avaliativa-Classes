import Wars.InOut;
import Wars.Menu;

public class Main {
    public static void main(String[] args) {
        boolean jogando = true;
        while (jogando) {
            switch (Menu.mostrarMenuJogo()) {
                case 0 -> {
                    Oraculo oc01 = new Oraculo();
                    Guerreiro g01 = new Guerreiro();
                    oc01.definirNome();
                    ReproduzirSom.tocar("../Wars/Midia/adventure.wav");
                    oc01.prologoIntroducao(g01);
                    oc01.loadLevel01();
                    oc01.loadLevel02();
                    oc01.LoadLevel03();
                }
                case 1 -> {
                    Bolsa myBolsa = new Bolsa();
                    Item item01 = new Item(1, "Arma", false);
                    Item item02 = new Item(2, "Poca", true);
                    myBolsa.adicionarItem(item01);
                    myBolsa.adicionarItem(item02);

                    item01.ImprimirDados();
                    myBolsa.equipar(item01);
                    item01.ImprimirDados();
                }
                case 2 -> {
                    InOut.MsgSemIcone("Fim", "Obrigado por jogar!");
                    jogando = false;
                }
                default -> jogando = false;
            }
        }
    }
}   