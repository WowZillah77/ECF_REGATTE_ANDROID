package com.wowzillah.dahouetandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wowzillah.dahouetandroid.adapter.RegattaAdapter;
import com.wowzillah.dahouetandroid.model.Regatta;
import com.wowzillah.dahouetandroid.services.RegattaServices;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RegattaActivity extends AppCompatActivity {
    private ListView mListView;
    int challenge_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regatta);
        Intent intent = getIntent();
        challenge_id = intent.getIntExtra("challenge_id",0);
        mListView = (ListView) findViewById(R.id.regatta_list_view);
        new ListRegattaTask().execute();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Regatta regatta = (Regatta) mListView.getItemAtPosition(position);
                int regate_id=regatta.getRegatta_id();
                String regate_nom=regatta.getRegatta_nom();
                Intent intent = new Intent(RegattaActivity.this, ResultatActivity.class);
                intent.putExtra("regatte_id",regate_id);
                intent.putExtra("regate_nom",regate_nom);
                startActivity(intent);
            }
        });
    }

    public void afficherResultats(List<Regatta> regattas) {
       RegattaAdapter adapter = new RegattaAdapter(this, regattas);
        mListView.setAdapter(adapter);
    }


    class ListRegattaTask extends AsyncTask<String, Void, List<Regatta>> {

        @Override
        protected List<Regatta> doInBackground(String... params) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy")
                    .create();
            RegattaServices regattaServices = new RestAdapter.Builder().setConverter(new GsonConverter(gson)).setEndpoint(RegattaServices.ENDPOINT).build().create(RegattaServices.class);

            List<Regatta> regattas = regattaServices.regattas(challenge_id);

            return regattas;
        }

        @Override
        protected void onPostExecute(List<Regatta> regattas) {
            super.onPostExecute(regattas);
            afficherResultats(regattas);
        }
    }
}
