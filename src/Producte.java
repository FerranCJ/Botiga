/**
 * Created by mauro on 14/01/18.
 */
public class Producte {

    //Declaració atributs
    private int id, nMagatzem, nBotiga;
    private String nom;
    private double preu, descompte;

    public Producte(){
        this.id = -1;
        this.nMagatzem = 0;
        this.nBotiga = 0;
        this.nom = "null";
        this.preu = 0.00;
        this.descompte = 0.00;
    }
    public Producte(int id, int nMagatzem, int nBotiga, String nom, double preu, double descompte) {
        this.id = id;
        this.nMagatzem = nMagatzem;
        this.nBotiga = nBotiga;
        this.nom = nom;
        this.preu = preu;
        this.descompte = descompte;
    }

    public int getId() {
        return id;
    }

    public int getnMagatzem() {
        return nMagatzem;
    }

    public int getnBotiga() {
        return nBotiga;
    }

    public String getNom() {
        return nom;
    }

    public void restarQuantitat(int n){
        if(this.nBotiga - n < 0)
            System.err.println("No disposem de tants productes");
        else
            this.nBotiga -= n;
    }

    public double getPreu(){
        return this.preu;
    }

    @Override
    public String toString() {
        return id + " - " + nom + " " + preu + "€ Disponibles: " + nBotiga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producte producte = (Producte) o;

        if (id != producte.id) return false;
        if (Double.compare(producte.preu, preu) != 0) return false;
        return nom != null ? nom.equals(producte.nom) : producte.nom == null;
    }

}
