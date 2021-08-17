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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cleiton.example.com.brazukas.BrazukasApp;
import cleiton.example.com.brazukas.R;
import cleiton.example.com.brazukas.model.ClubeModel;

/**
 * Created by Cleiton on 13/10/2017..
 */

public class ClubesArrayAdpter extends ArrayAdapter<ClubeModel> {

    private List<ClubeModel> array;
    public ClubesArrayAdpter(@NonNull Context context, @NonNull List<ClubeModel> objects, Boolean reverse) {
        super(context, 0, objects);
        Collections.sort(objects,  new Comparator<ClubeModel>() {
            @Override
            public int compare(ClubeModel o1, ClubeModel o2) {
                return o1.getPosicao() - o2.getPosicao();
            }
        });
        if(reverse){
            Collections.reverse(objects);
        }
        array = objects;
    }

    @Nullable
    @Override
    public ClubeModel getItem(int position) {
        return array.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_clubes, parent, false);
        }

        final ClubeModel item = getItem(position);
        if (item != null) {
            ImageView imageView = (ImageView) convertView.findViewById(R.id.img);
            TextView nomeView = (TextView) convertView.findViewById(R.id.nome);
            TextView txtPosition = (TextView) convertView.findViewById(R.id.position);
            txtPosition.setText(item.getPosicao().toString());
            nomeView.setText(item.getNome());

            Picasso.with(BrazukasApp.getInstance().getBaseContext())
                    .load(item.getEscudos().get("30x30"))
                    .into(imageView);

        }
        return convertView;
    }
}
