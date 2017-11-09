package com.wowzillah.dahouetandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wowzillah.dahouetandroid.adapter.ResultatAdapter;
import com.wowzillah.dahouetandroid.model.Resultat;
import com.wowzillah.dahouetandroid.services.ResultatService;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ResultatActivity extends AppCompatActivity {
    private ListView mListView;
    int regatte_id;
    String regate_nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Intent intent = getIntent();
        regatte_id = intent.getIntExtra("regatte_id",0);
        regate_nom = intent.getStringExtra("regate_nom");
        mListView=(ListView) findViewById(R.id.resultat_list_view);
        new ListResultatTask().execute();
        TextView nom= (TextView) findViewById(R.id.resultat_regatta_name);

        nom.setText(regate_nom);

    }
    public void afficherResultats(List<Resultat>resultats) {
         ResultatAdapter adapter = new ResultatAdapter(this, resultats);
        if(resultats.size()>0) {
            TextView classe = (TextView) findViewById(R.id.resultat_classe_name);
            TextView serie = (TextView) findViewById(R.id.resultat_serie_name_text_view);

            classe.setText(resultats.get(0).getClasse_nom());
            serie.setText(resultats.get(0).getSerie_nom());
        }else{
            TextView noResult =(TextView) findViewById(R.id.pas_de_resultat_text_view);
            noResult.setText("les résultats ne sont pas disponible");

        }
        mListView.setAdapter(adapter);


    }


    class ListResultatTask extends AsyncTask<String, Void, List<Resultat>> {

        @Override
        protected List<Resultat> doInBackground(String... params) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("hh:mm:ss")
                    .create();
            ResultatService resultatService = new RestAdapter.Builder().setConverter(new GsonConverter(gson)).setEndpoint(ResultatService.ENDPOINT).build().create(ResultatService.class);

            List<Resultat> resultats = resultatService.resultats(regatte_id);

            return resultats;
        }

        @Override
        protected void onPostExecute(List<Resultat> resultats) {
            super.onPostExecute(resultats);
            afficherResultats(resultats);
        }
    }

}
