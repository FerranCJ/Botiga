import java.util.Date;

/**
 * Created by mauro on 17/01/18.
 */
public class Empleat {

    private String nom, cognom, dni, sexe;
    private Date dataNaixament;
    private int telefon, id;

    public Empleat(String nom, String cognom, String dni, String sexe, Date dataNaixament, int telefon, int id) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.sexe = sexe;
        this.dataNaixament = dataNaixament;
        this.telefon = telefon;
        this.id = id;
    }

    public Empleat(){
        this.nom = this.sexe = this.cognom = this.dni = "";
        this.dataNaixament = new Date(01/01/1970);
        telefon = -1; id = -1;
    }

    @Override
    public String toString() {
        return "Empleat num: " +id +" - " + nom + " " + cognom;
    }

    public int getID(){
        return id;
    }

    public String getDades(){
        return this.nom + " " + this.cognom;
    }
}
