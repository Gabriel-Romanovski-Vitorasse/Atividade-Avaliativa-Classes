import java.util.ArrayList;
import java.util.List;

public class Bolsa {
    private List<Item> listaItens = new ArrayList<>();
    private Item item;
    int qtdeItens;
    
    void equipar(Item i){
        listaItens.add(i);
        qtdeItens = listaItens.size();
        System.out.println("Item equipado na bolsa.");
        System.out.println("Quantidade de Itens: "+qtdeItens);
    }
    
    void desequipar(Item i){
        listaItens.remove(i);
    }
    
}
