package cleiton.example.com.brazukas.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import cleiton.example.com.brazukas.BrazukasApp;
import cleiton.example.com.brazukas.R;
import cleiton.example.com.brazukas.model.ClubeModel;
import cleiton.example.com.brazukas.model.PartidaModel;

/**
 * Created by Cleiton on 13/10/2017.
 */

public class PartidasArrayAdpter extends ArrayAdapter<PartidaModel> {

    private List<PartidaModel> array;
    private List<ClubeModel> clubes;
    public PartidasArrayAdpter(@NonNull Context context, @NonNull List<PartidaModel> objects, @NonNull List<ClubeModel> clubes) {
        super(context, 0, objects);

        Collections.sort(objects,  new Comparator<PartidaModel>() {
            @Override
            public int compare(PartidaModel o1, PartidaModel o2) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    Date date1 = formatter.parse(o1.getPartida_data());
                    Date date2 = formatter.parse(o2.getPartida_data());
                    return date1.compareTo(date2);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return -1;
            }
        });

        array = objects;
        this.clubes = clubes;
    }

    @Nullable
    @Override
    public PartidaModel getItem(int position) {
        return array.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_partidas, parent, false);
        }

        final PartidaModel item = getItem(position);
        if (item != null) {
            ClubeModel clubeCasa = getClube(item.getClube_casa_id());
            ClubeModel clubeVisitante = getClube(item.getClube_visitante_id());

            ImageView imgMand = (ImageView) convertView.findViewById(R.id.imgMand);
            ImageView imgVisit = (ImageView) convertView.findViewById(R.id.imgVisit);
            TextView cbMandante = (TextView) convertView.findViewById(R.id.cbMandante);
            TextView cbVisitante = (TextView) convertView.findViewById(R.id.cbVisitante);
            TextView local = (TextView) convertView.findViewById(R.id.txtLocalData);

            local.setText(item.getLocal()+" "+item.getPartida_data());
            cbMandante.setText(clubeCasa.getAbreviacao());
            cbVisitante.setText(clubeVisitante.getAbreviacao());

            Picasso.with(BrazukasApp.getInstance().getBaseContext())
                    .load(clubeCasa.getEscudos().get("30x30"))
                    .into(imgMand);

            Picasso.with(BrazukasApp.getInstance().getBaseContext())
                    .load(clubeVisitante.getEscudos().get("30x30"))
                    .into(imgVisit);

        }
        return convertView;
    }

    private ClubeModel getClube(Integer id){
        for (ClubeModel iten : clubes) {
            if(iten.getId().equals(id)){
                return iten;
            }
        }
        return null;
    }


}
