import java.util.ArrayList;

/**
 * Created by mauro on 14/01/18.
 */
public class Inventari {

    private Integer codiProducte;
    private String nomProducte;
    private Integer productesBotiga;
    private Integer productesMagatzem;

    public Inventari(){
        this.codiProducte = -1;
        this.nomProducte = "null";
        this.productesBotiga = 0;
        this.productesMagatzem = 0;

    }

    public void generarInventari(){
        System.out.println(this.codiProducte + "\t" + this.nomProducte + "\t" +
        this.productesBotiga + "\t" + this.productesMagatzem);
    }

    public void afegirProducte(Producte p){
        this.codiProducte = p.getId();
        this.nomProducte = p.getNom();
        this.productesMagatzem = p.getnMagatzem();
        this.productesBotiga = p.getnBotiga();
    }
}
