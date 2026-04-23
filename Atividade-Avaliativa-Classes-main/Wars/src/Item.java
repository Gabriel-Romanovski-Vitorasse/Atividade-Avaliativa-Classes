
import Wars.InOut;

public class Item {
    protected int idItem;
    protected String tipoItem;
    protected boolean equipado;

    public Item() {}

    public Item(int idItem, String tipoItem, boolean equipado) {
        this.idItem = idItem;
        this.tipoItem = tipoItem;
        this.equipado = equipado;
    }
    
    void ImprimirDados(){
        InOut.MsgSemIcone("Informacoes do Item", "Id do item: "+idItem+".\nTipo do Item: "+tipoItem+".\nEquipado: "+equipado);
    }
}
