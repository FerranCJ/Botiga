import java.util.Date;

/**
 * Created by mauro on 17/01/18.
 */
public class Oferta {

    private double descompte;
    private Date dataIni, dataFin;
    private int id;
    private int idProducte;

    public Oferta(double descompte, Date dataIni, Date dataFin, int id, int idProducte) {
        this.descompte = descompte;
        this.dataIni = dataIni;
        this.dataFin = dataFin;
        this.id = id;
        this.idProducte = idProducte;
    }

    public Oferta(){
        this.dataFin = this.dataIni = new Date(01/1/1970);
        this.id = this.idProducte = -1;
        this.descompte = 0.0;
    }
}
