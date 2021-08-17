package cleiton.example.com.brazukas.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import cleiton.example.com.brazukas.BrazukasApp;
import cleiton.example.com.brazukas.R;
import cleiton.example.com.brazukas.adapter.TabPagerAdapter;
import cleiton.example.com.brazukas.model.BrazukasModel;
import cleiton.example.com.brazukas.model.ClubeModel;
import cleiton.example.com.brazukas.service.BrasukasServices;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BrasukasServices.get(sucess, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", error.getMessage());
            }
        });

    }

    private  Response.Listener sucess = new Response.Listener<BrazukasModel>() {
        @Override
        public void onResponse(BrazukasModel response) {
            SharedPreferences.Editor editor = BrazukasApp.getInstance().getSharedPreferences("BRAZUKAS", 0).edit();
            editor.putString("BRAZUKAS_MODEL", new Gson().toJson(response));
            editor.commit();
            createComponents();
        }
    };

    private void createComponents(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Clubes"));
        tabLayout.addTab(tabLayout.newTab().setText("Partidas"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}

