import Wars.InOut;
import java.util.ArrayList;
import java.util.List;

public class Bolsa {
    private final List<Item> listaItens = new ArrayList<>();
    private Item item;
    private int qtdeItens;
    
    void adicionarItem (Item i){
        listaItens.add(i);
        qtdeItens = listaItens.size();
    }
    void EquiparPeloId(){
        int idDesejado = InOut.leInt("Digite o ID do item que deseja equipar:");
        boolean itemEncontrado = false;
        for (Item i : listaItens) {
            if (i.idItem == idDesejado) { 
                itemEncontrado = true;
                if (i.equipado) InOut.MsgDeAviso("Aviso", "O item " + i.idItem + " (" + i.tipoItem + ") ja esta equipado.");
                else {
                    item = i;
                    item.equipado = true;
                    InOut.MsgDeInformacao("Sucesso", "O item " + item.idItem + " (" + item.tipoItem + ") foi equipado!");
                }
                break; 
            }
        }
        if (!itemEncontrado) InOut.MsgDeErro("Erro", "Nenhum item com esse ID foi encontrado na sua bolsa.");
    }
    
    void DesequiparPeloId(){
        int idDesejado = InOut.leInt("Digite o ID do item que deseja equipar:");
        boolean itemEncontrado = false;
        for (Item i : listaItens) {
            if (i.idItem == idDesejado) { 
                itemEncontrado = true;
                if (i.equipado != false) {
                    item = i;
                    item.equipado = false;
                    InOut.MsgDeInformacao("Sucesso", "O item " + item.idItem + " (" + item.tipoItem + ") foi desequipado!");
                } else InOut.MsgDeAviso("Aviso", "O item " + i.idItem + " (" + i.tipoItem + ") ja esta desequipado.");
                break; 
            }
        }
        if (!itemEncontrado) InOut.MsgDeErro("Erro", "Nenhum item com esse ID foi encontrado na sua bolsa.");
    }
    
    public void mostrarInventario() {
        if (listaItens.isEmpty()) {
            InOut.MsgDeAviso("Bolsa", "A sua bolsa está vazia!");
            return;
        }
        String textoInventario = "Estes são os itens na sua bolsa:\n\n";
        for (Item i : listaItens) {
            textoInventario += "ID: " + i.idItem + " | Tipo: " + i.tipoItem;
            
            if (i.equipado) textoInventario += " [EQUIPADO]\n";
            else textoInventario += " [DESEQUIPADO]\n";
        }
        InOut.MsgSemIcone("Inventário do Guerreiro", textoInventario);
    }
    
    public int acharItem() {
        int id_achado = 0;
        for (Item i : listaItens) {
            if (i.equipado) id_achado = i.idItem;
        }
        return id_achado;
    }
    
}
