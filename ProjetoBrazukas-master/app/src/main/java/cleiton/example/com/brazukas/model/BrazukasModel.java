package cleiton.example.com.brazukas.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cleiton on 09/10/2017.
 */

public class BrazukasModel {

    private ArrayList<PartidaModel> partidas;
    private HashMap<String, Object> clubes;

    public ArrayList<PartidaModel> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<PartidaModel> partidas) {
        this.partidas = partidas;
    }

    public HashMap<String, Object> getClubes() {
        return clubes;
    }

    public void setClubes(HashMap<String, Object> clubes) {
        this.clubes = clubes;
    }
}
