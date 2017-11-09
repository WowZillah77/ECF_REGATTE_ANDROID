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
import com.wowzillah.dahouetandroid.adapter.ChallengeAdapter;
import com.wowzillah.dahouetandroid.model.Challenge;
import com.wowzillah.dahouetandroid.services.ChallengeService;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.challengeListview);
        new ListChallengesTask().execute();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Challenge challenge = (Challenge) mListView.getItemAtPosition(position);
                int challenge_id=challenge.getChallenge_id();
                Intent intent = new Intent(MainActivity.this, RegattaActivity.class);
                intent.putExtra("challenge_id",challenge_id);
                startActivity(intent);
            }
        });
    }

    public void afficherResultats(List<Challenge> challenges) {
        ChallengeAdapter adapter = new ChallengeAdapter(MainActivity.this, challenges);
        mListView.setAdapter(adapter);
    }


    class ListChallengesTask extends AsyncTask<String, Void, List<Challenge>> {

        @Override
        protected List<Challenge> doInBackground(String... params) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd-MM-yyyy")
                    .create();
            ChallengeService resultatService = new RestAdapter.Builder().setConverter(new GsonConverter(gson)).setEndpoint(ChallengeService.ENDPOINT).build().create(ChallengeService.class);

            ArrayList<Challenge> challenges = resultatService.challenges();

            return challenges;
        }

        @Override
        protected void onPostExecute(List<Challenge> challenges) {
            super.onPostExecute(challenges);
            afficherResultats(challenges);
        }
    }

}