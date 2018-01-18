import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mauro on 17/01/18.
 */
public class Compra {
    private int id;
    private ArrayList<LiniaCompra> productesComprats;
    private Client clientCompra;
    private Empleat empleatCompra;
    private LocalTime horaCompra;
    private double preuCompra;

    public void afegirEmpleat(Empleat e){
        empleatCompra = e;
    }
    public void assignarHora(LocalTime h){
        this.horaCompra = h;
    }

    public void afegirProducte(LiniaCompra p){
        this.productesComprats.add(p);
    }
    public Compra(){
        id = -1;
        preuCompra = 0;
        clientCompra = new Client();
        empleatCompra = new Empleat();
        horaCompra = LocalTime.now();
        productesComprats = new ArrayList<>();
    }
    public Compra(int id){
        this.id = id;
        preuCompra = 0;
        clientCompra = new Client();
        empleatCompra = new Empleat();
        horaCompra = LocalTime.now();
        productesComprats = new ArrayList<>();
    }

    public void incrementarPreu(double n, int q){
        (this.preuCompra) += n*q;
    }

    public double getTotal(){
        return this.preuCompra;
    }
    public void afegirClient(Client c){
        this.clientCompra = c;
    }

    public void generarTicket(Client c){
        System.out.println("Generant ticket.....");
        System.out.println();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Ticket de compra numero: " + this.id);
        System.out.println("Atès per: "+ empleatCompra.getDades() + ", a les " + horaCompra.format(dtf));
        System.out.println("Productes: ");
        System.out.printf("%-30s %-15s %-15s %-15s", "Descripcio", "Quantitat", "Preu U.", "Total");
        System.out.println();

        for(int i = 0;i<productesComprats.size();i++){
            double total = productesComprats.get(i).getProducte().getPreu() * productesComprats.get(i).getQuantitat();
            String s = String.format("%.2f", total);
            System.out.printf("%-30s %-15s %-15s %-15s", productesComprats.get(i).getProducte().getNom(), productesComprats.get(i).getQuantitat(),
                    productesComprats.get(i).getProducte().getPreu(), s);
            System.out.println();
        }
        double totalP = preuCompra;
        String s = String.format("%.2f", totalP);
        System.out.println("Preu total: " + totalP);
        if(!clientCompra.getDNI().equals(""))
            System.out.println("Client: " + clientCompra);


        System.out.println("Punts acumulats totals: " + c.getPunts());
        System.out.println();

    }

}
