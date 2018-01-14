import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //El constructor llegirà l'arxiu i emplenara l'array de productes.
        RelacioProductes productes = new RelacioProductes();

        //Test
        Producte p = new Producte(1, 10, 10, "p1", 12.90, 1.00);
        Producte p1 = new Producte(2, 10, 10, "p1", 10.90, 0.00);
        productes.afegirProducte(p);
        productes.afegirProducte(p1);
        ArrayList<Producte> llistaProductes = productes.obtenirProductes();

        Integer opcio = mostrarMenu();
        if(opcio == 1){

        }else if (opcio == 2){
            ArrayList<Inventari> inventari = new ArrayList<>();
            for (int i = 0;i<llistaProductes.size();i++){
                Inventari liniaInventari = new Inventari();
                liniaInventari.afegirProducte(llistaProductes.get(i));
                inventari.add(liniaInventari);
            }

            //Generar llistat inventari
            for(int i = 0;i<inventari.size();i++){
                inventari.get(i).generarInventari();
            }




        }else{
            System.out.println("Sortint del programa... ");
        }

    }

    public static Integer mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Benvingut al caixer del futur: ");
        System.out.println("Que desitja fer? ");
        System.out.println("\t1 -> Passar per caixa");
        System.out.println("\t2 -> Generar llistat per l'inventari");
        System.out.println("\t0 -> Sortir");

        return lector.nextInt();
    }
}
