import java.util.ArrayList;

/**
 * Created by mauro on 14/01/18.
 */
public class Inventari {

    private int codiProducte;
    private String nomProducte;
    private int productesBotiga;
    private int productesMagatzem;

    public Inventari(){
        this.codiProducte = -1;
        this.nomProducte = "null";
        this.productesBotiga = 0;
        this.productesMagatzem = 0;

    }

    public void generarInventari(){
        System.out.printf("%-7s %-30s %-20s %-20s\n", this.codiProducte, this.nomProducte,
        this.productesBotiga,  this.productesMagatzem);
    }

    public void afegirProducte(Producte p){
        this.codiProducte = p.getId();
        this.nomProducte = p.getNom();
        this.productesMagatzem = p.getnMagatzem();
        this.productesBotiga = p.getnBotiga();
    }
}
