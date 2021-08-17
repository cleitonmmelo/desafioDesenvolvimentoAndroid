package cleiton.example.com.brazukas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.Arrays;

import cleiton.example.com.brazukas.BrazukasApp;
import cleiton.example.com.brazukas.R;
import cleiton.example.com.brazukas.adapter.ClubesArrayAdpter;
import cleiton.example.com.brazukas.adapter.PartidasArrayAdpter;
import cleiton.example.com.brazukas.model.BrazukasModel;
import cleiton.example.com.brazukas.model.ClubeModel;

public class PartidasFragment extends Fragment {

    private ListView listView;
    private ClubeModel[] clubes;
    private Boolean order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_partidas, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewPartidas);

        String json = BrazukasApp.getInstance().getSharedPreferences("BRAZUKAS", 0).getString("BRAZUKAS_MODEL", "");
        Gson gson = new Gson();
        BrazukasModel response = gson.fromJson(json, BrazukasModel.class);
        String jsonString = gson.toJson(response.getClubes().values());
        clubes = gson.fromJson(jsonString, ClubeModel[].class);
        order = false;
        listView.setAdapter(new PartidasArrayAdpter(getContext(), response.getPartidas(), Arrays.asList(clubes)));

        return rootView;

    }
}
