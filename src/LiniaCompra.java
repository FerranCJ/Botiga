/**
 * Created by mauro on 18/01/18.
 */
public class LiniaCompra {

    private int quantitat;
    private Producte p;

    public LiniaCompra(){
        quantitat = 0;
        p = new Producte();
    }
    public LiniaCompra(Producte p, int n){
        this.quantitat = n;
        this.p = p;
    }

    public Producte getProducte(){
        return this.p;
    }

    public int getQuantitat(){
        return this.quantitat;
    }
}
