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

    public void restarBotiga(Producte p, int n){
        int pos = this.productes.indexOf(p);
        productes.get(pos).restarQuantitat(n);
    }
    public ArrayList<Producte> obtenirProductes(){
        return this.productes;
    }

    public Producte buscarProducte(int id){
        boolean trobat = false;
        int i = 0;
        Producte res = new Producte();
        while(!trobat && i<productes.size()){
            if(productes.get(i).getId() == id){
                trobat = true;
                res = productes.get(i);
            }
            i++;

        }
        return res;
    }
}
