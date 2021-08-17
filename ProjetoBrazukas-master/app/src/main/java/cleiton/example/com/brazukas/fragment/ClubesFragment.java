package cleiton.example.com.brazukas.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;

import cleiton.example.com.brazukas.BrazukasApp;
import cleiton.example.com.brazukas.R;
import cleiton.example.com.brazukas.adapter.ClubesArrayAdpter;
import cleiton.example.com.brazukas.model.BrazukasModel;
import cleiton.example.com.brazukas.model.ClubeModel;
import cleiton.example.com.brazukas.service.BrasukasServices;

public class ClubesFragment extends Fragment {

    private ListView listView;
    private ClubeModel[] clubes;
    private Boolean order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_clubes, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewClubes);
        ImageView btnsort = (ImageView) rootView.findViewById(R.id.btnsort);

        btnsort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order = !order;
                listView.setAdapter(new ClubesArrayAdpter(getContext(), Arrays.asList(clubes), order));
            }
        });
        String json = BrazukasApp.getInstance().getSharedPreferences("BRAZUKAS", 0).getString("BRAZUKAS_MODEL", "");

        Gson gson = new Gson();
        BrazukasModel response = gson.fromJson(json, BrazukasModel.class);
        String jsonString = gson.toJson(response.getClubes().values());
        clubes = gson.fromJson(jsonString, ClubeModel[].class);
        order = false;
        listView.setAdapter(new ClubesArrayAdpter(getContext(), Arrays.asList(clubes), order));

        return rootView;

    }
}
