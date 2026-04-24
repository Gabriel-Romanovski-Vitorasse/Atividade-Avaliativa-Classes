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
                item = i;
                item.equipado = true;
                
                InOut.MsgDeAviso("Aviso", "O item " + item.idItem + " (" + item.tipoItem + ") foi equipado.");
                itemEncontrado = true;
                break; 
            }
        }
        if (!itemEncontrado)
            InOut.MsgDeErro("Erro", "Nenhum item com esse ID foi encontrado na sua bolsa.");
    }
    
    void DesequiparPeloId(){
        int idDesejado = InOut.leInt("Digite o ID do item que deseja equipar:");
        
        boolean itemEncontrado = false;
        for (Item i : listaItens) {
            if (i.idItem == idDesejado) {
                item = i;
                item.equipado = false;
                
                InOut.MsgDeAviso("Aviso", "O item " + item.idItem + " (" + item.tipoItem + ") foi equipado.");
                itemEncontrado = true;
                break; 
            }
        }
        if (!itemEncontrado)
            InOut.MsgDeErro("Erro", "Nenhum item com esse ID foi encontrado na sua bolsa.");
    }
    
    public void mostrarInventario() {
        if (listaItens.isEmpty()) {
            InOut.MsgDeAviso("Bolsa", "A sua bolsa está completamente vazia!");
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
    
}
