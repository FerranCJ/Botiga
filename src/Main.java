import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        if(args.length < 1){
            System.err.println("Falten parametres");
            System.exit(0);
        }
        String RUTA_ARXIU = args[0];

        RelacioProductes productes = new RelacioProductes();
        RelacioClient clients = new RelacioClient();
        RelacioEmpleat empleats = new RelacioEmpleat();

        llegirArxiu(RUTA_ARXIU, clients, productes, empleats);

        ArrayList<Producte> llistaProductes = productes.obtenirProductes();
        Integer opcio = mostrarMenu();
        while(opcio != 0){

            if(opcio == 1){

                Scanner lector = new Scanner(System.in);
                System.out.println("Benvingut a la fase de compra:");
                System.out.println("Escull un empleat que vols que t'atengui: (Introdueix el numero d'empleat)");
                ArrayList<Empleat> empleatsActuals = empleats.obtenirEmpleats();
                if(empleatsActuals.size() > 0){
                    for(int i = 0;i<empleatsActuals.size();i++){
                        System.out.println("\t" +empleatsActuals.get(i));
                    }
                    Compra compra = new Compra(1);
                    LocalTime horaActual = LocalTime.now();
                    int empleatId = lector.nextInt();
                    Empleat empleat = empleats.buscarEmpleat(empleatId);
                    if(empleat.getID() != -1){
                        compra.afegirEmpleat(empleat);
                        compra.assignarHora(horaActual);
                        System.out.println("Hora de passar els productes");
                        int producteAcomprar = -1;
                        while(producteAcomprar != 0){
                            if(llistaProductes.size() > 0){
                                System.out.println("Llistat de productes disponibles: ");
                                for (int i = 0;i<llistaProductes.size();i++){
                                    if(llistaProductes.get(i).getnBotiga() > 0)
                                        System.out.println("\t" +llistaProductes.get(i));
                                }
                                System.out.println("Introdueix el id del producte que vols o 0 pero finalitzar la compra");
                                producteAcomprar = lector.nextInt();
                                if(producteAcomprar > 0){
                                    Producte p = productes.buscarProducte(producteAcomprar);
                                    if(p.getId() == -1)
                                        System.err.println("Producte inexistent");

                                    System.out.println("Introdueix la quantitat que vols");
                                    int n = lector.nextInt();
                                    LiniaCompra liniaCompra = new LiniaCompra(p, n);
                                    compra.afegirProducte(liniaCompra);
                                    compra.incrementarPreu(p.getPreu(), n);
                                    productes.restarBotiga(p, n);
                                }
                            }else{
                                System.out.println("No disposem de productes actualment");
                                producteAcomprar = 0;
                            }
                        }
                        //Pagament i identificacio client
                        String idClient ="";
                        Client c = new Client();
                        while(!idClient.equals("0")){
                        System.out.println("Identificació: (Introdueix DNI si no ets client 0)");
                        idClient = lector.next();
                            c = clients.buscarClient(idClient);
                            if(!c.getDNI().equals("")){
                                compra.afegirClient(c);
                                c.incrementarPunts(compra.getTotal());
                                idClient = "0";
                            }else{
                                System.err.println("Client inexistent");
                            }

                        }
                        compra.generarTicket(c);
                        System.out.println("Ticket pagat");
                    }else{
                        System.err.println("Empleat inexistent");
                    }

                }else{
                    System.err.println("Ho sentim molt pero els empleats estan tots ocupats torni mes tard");
                }

            }else if (opcio == 2){
                ArrayList<Inventari> inventari = new ArrayList<>();
                for (int i = 0;i<llistaProductes.size();i++){
                    Inventari liniaInventari = new Inventari();
                    liniaInventari.afegirProducte(llistaProductes.get(i));
                    inventari.add(liniaInventari);
                }

                //Generar llistat inventari
                System.out.printf("%-7s %-30s %-20s %-20s\n", "Codi", "Article", "BOTIGA", "MAGATZEM");
                for(int i = 0;i<inventari.size();i++){
                    inventari.get(i).generarInventari();
                }
            }else{
                System.out.println("Opcio no vàlida \n");
            }

            opcio = mostrarMenu();
        }

        System.out.println("Sortint del programa... \n");


    }

    public static Integer mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        System.out.println();
        System.out.println("Benvingut al caixer del futur: ");
        System.out.println("Que desitja fer? ");
        System.out.println("\t1 -> Passar per caixa");
        System.out.println("\t2 -> Generar llistat per l'inventari");
        System.out.println("\t0 -> Sortir");

        return lector.nextInt();
    }

    public static void llegirArxiu(String RUTA_ARXIU, RelacioClient clients, RelacioProductes productes, RelacioEmpleat empleats) throws FileNotFoundException{
        File arxiu = new File(RUTA_ARXIU);
        Scanner lector = new Scanner(arxiu).useLocale(Locale.US);

        String id ="";
        while(lector.hasNextLine()){
            id = lector.nextLine();

            if(id.equals("Client")){
                llegirClient(lector, clients);
            }else if(id.equals("Producte")){
                llegirProducte(lector, productes);
            }else if(id.equals("Empleat")){
                llegirEmpleat(lector, empleats);
            }
        }

    }

    public static void llegirClient(Scanner lector, RelacioClient clients){

        String nom = lector.nextLine();
        String cognom = lector.nextLine();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date dataNaixament = null;
        try {
            dataNaixament = format.parse(lector.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sexe = lector.nextLine();
        String numTargeta = lector.nextLine();
        String dni = lector.nextLine();
        double punts = Double.parseDouble(lector.nextLine());
        String correu = lector.nextLine();
        String adreça = lector.nextLine();
        int telefon = lector.nextInt();

        Client c = new Client(nom, cognom,  dni, sexe,  numTargeta,  correu,  adreça,
                 dataNaixament,  punts,  telefon);
        clients.afegirClient(c);

    }

    public static void llegirEmpleat(Scanner lector, RelacioEmpleat empleats){
        String nom = lector.nextLine();
        String cognoms = lector.nextLine();
        String dni = lector.nextLine();
        int telefon = Integer.parseInt(lector.nextLine());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        Date dataNaixament = null;
        try {
            dataNaixament = format.parse(lector.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sexe = lector.nextLine();
        int id = Integer.parseInt(lector.nextLine());

        Empleat e = new Empleat(nom, cognoms, dni, sexe, dataNaixament, telefon, id);
        empleats.afegirEmpleat(e);
    }

    public static void llegirProducte(Scanner lector, RelacioProductes productes){
        String nomP = lector.nextLine();
        int id = Integer.parseInt(lector.nextLine());
        double preu = Double.parseDouble(lector.nextLine());
        int nMagatzem = Integer.parseInt(lector.nextLine());
        int nBotiga = Integer.parseInt(lector.nextLine());
        double descompte = Double.parseDouble(lector.nextLine());

        Producte p = new Producte(id, nMagatzem, nBotiga, nomP, preu, descompte);
        productes.afegirProducte(p);

    }
}
