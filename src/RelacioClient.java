import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mauro on 15/01/18.
 */
public class RelacioClient {

    private ArrayList<Client> clients;

    public RelacioClient() {
        this.clients = new ArrayList<Client>();
    }

    public void afegirClient(Client c){
        if(!this.clients.contains(c)){
            this.clients.add(c);
        }else{
            System.err.println("Error el client ja existent");
        }
    }

    public Client buscarClient(String dni){
        int i = 0;
        Client res = new Client();
        boolean trobat = false;
        while(!trobat && i < this.clients.size()){
            if(this.clients.get(i).getDNI().toLowerCase().equals(dni.toLowerCase())){
                trobat = true;
                res = this.clients.get(i);
            }
            i++;
        }

        return res;

    }
}
