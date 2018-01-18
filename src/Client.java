import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mauro on 15/01/18.
 */
public class Client {
    private String nom, cognom, DNI, sexe, numTargeta, correu, adreça;
    private Date dataNaixament;
    private double puntsTotals;
    private int telefon;
    private ArrayList<Oferta> ofertesPersonalitzades;

    public Client(){
        this.nom = this.cognom = this.DNI = this.sexe = this.numTargeta= this.correu = this.adreça = "";
        this.dataNaixament = new Date(1/1/1970);
        this.puntsTotals = 0.0;
        this.telefon = 000000000;
        this.ofertesPersonalitzades = new ArrayList<>();
    }

    public Client(String nom, String cognom, String DNI, String sexe, String numTargeta, String correu, String adreça,
                  Date dataNaixament, double puntsTotals, int telefon) {
        this.nom = nom;
        this.cognom = cognom;
        this.DNI = DNI;
        this.sexe = sexe;
        this.numTargeta = numTargeta;
        this.correu = correu;
        this.adreça = adreça;
        this.dataNaixament = dataNaixament;
        this.puntsTotals = puntsTotals;
        this.telefon = telefon;
        this.ofertesPersonalitzades = new ArrayList<>();
    }

    public void incrementarPunts(double punts){
        this.puntsTotals += punts;
    }

    public double getPunts(){
        return this.puntsTotals;
    }

    @Override
    public String toString() {
        return this.nom + " " + this.cognom;
    }

    public String getDNI(){
        return this.DNI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (cognom != null ? !cognom.equals(client.cognom) : client.cognom != null) return false;
        if (DNI != null ? !DNI.equals(client.DNI) : client.DNI != null) return false;
        if (numTargeta != null ? !numTargeta.equals(client.numTargeta) : client.numTargeta != null) return false;
        return dataNaixament != null ? dataNaixament.equals(client.dataNaixament) : client.dataNaixament == null;
    }

}
