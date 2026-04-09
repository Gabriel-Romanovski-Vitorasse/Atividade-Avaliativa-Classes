public class Item {
    private int idItem;
    private String tipoItem;
    private boolean equipado;

    public Item() {}

    public Item(int idItem, String tipoItem, boolean equipado) {
        this.idItem = idItem;
        this.tipoItem = tipoItem;
        this.equipado = equipado;
    }
    
    void ImprimirDados(){}
}
