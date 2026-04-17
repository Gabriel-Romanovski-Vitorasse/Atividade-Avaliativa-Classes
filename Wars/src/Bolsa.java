import Wars.InOut;
import java.util.ArrayList;
import java.util.List;

public class Bolsa {
    private List<Item> listaItens = new ArrayList<>();
    private Item item;
    private int qtdeItens;
    
    void adicionarItem (Item i){
        listaItens.add(i);
        qtdeItens = listaItens.size();
        InOut.MsgDeInformacao("Aviso: Item equipado na bolsa.", "Quantidade de Itens na bolsa: "+qtdeItens);
    }
    void equipar(Item i){
        item = i;
        item.equipado = true;
        InOut.MsgDeAviso("Aviso", "O item "+item.idItem+" foi equipado.");
    }
    
    void desequipar(Item i){
        item = i;
        item.equipado = false;
        InOut.MsgDeAviso("Aviso", "O item "+item.idItem+" foi desequipado.");
    }
    
}
