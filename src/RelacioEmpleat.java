import java.util.ArrayList;

/**
 * Created by mauro on 17/01/18.
 */
public class RelacioEmpleat {

    private ArrayList<Empleat> empleats;

    public RelacioEmpleat(){
        this.empleats = new ArrayList<>();
    }

    public void afegirEmpleat(Empleat e){
        if(!this.empleats.contains(e)){
            this.empleats.add(e);
        }else{
            System.err.println("Error empleat ja existent");
        }
    }

    public ArrayList<Empleat> obtenirEmpleats(){
        return this.empleats;
    }

    public Empleat buscarEmpleat(int id){
        int i = 0;
        Empleat res = new Empleat();
        boolean trobat = false;
        while(!trobat && i < this.empleats.size()){
            if(this.empleats.get(i).getID() == id){
                trobat = true;
                res = this.empleats.get(i);
            }
            i++;
        }

        return res;

    }
}
