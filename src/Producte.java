/**
 * Created by mauro on 14/01/18.
 */
public class Producte {

    //Declaració atributs
    private Integer id, nMagatzem, nBotiga;
    private String nom;
    private Double preu, descompte;

    public Producte(){
        this.id = -1;
        this.nMagatzem = 0;
        this.nBotiga = 0;
        this.nom = "null";
        this.preu = 0.00;
        this.descompte = 0.00;
    }
    public Producte(Integer id, Integer nMagatzem, Integer nBotiga, String nom, Double preu, Double descompte) {
        this.id = id;
        this.nMagatzem = nMagatzem;
        this.nBotiga = nBotiga;
        this.nom = nom;
        this.preu = preu;
        this.descompte = descompte;
    }

    public Integer getId() {
        return id;
    }

    public Integer getnMagatzem() {
        return nMagatzem;
    }

    public Integer getnBotiga() {
        return nBotiga;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producte producte = (Producte) o;

        if (id != null ? !id.equals(producte.id) : producte.id != null) return false;
        if (nMagatzem != null ? !nMagatzem.equals(producte.nMagatzem) : producte.nMagatzem != null) return false;
        if (nBotiga != null ? !nBotiga.equals(producte.nBotiga) : producte.nBotiga != null) return false;
        return nom != null ? nom.equals(producte.nom) : producte.nom == null;
    }

}
