import java.util.ArrayList;

/**
 * Created by mauro on 14/01/18.
 */
public class RelacioProductes {

    private ArrayList<Producte> productes;

    public RelacioProductes(){
        this.productes = new ArrayList<Producte>();
    }

    public void afegirProducte(Producte p){
        if(!this.productes.contains(p)){
            this.productes.add(p);
        }else{
            System.err.println("Error producte ja existent");
        }

    }

    public ArrayList<Producte> obtenirProductes(){
        return this.productes;
    }
}
