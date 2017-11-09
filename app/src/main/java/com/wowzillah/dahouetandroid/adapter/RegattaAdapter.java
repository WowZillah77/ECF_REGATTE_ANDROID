package com.wowzillah.dahouetandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wowzillah.dahouetandroid.R;
import com.wowzillah.dahouetandroid.model.Regatta;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by david on 08/11/17.
 */

public class RegattaAdapter extends ArrayAdapter<Regatta>{

        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yy");
        //regattas est la liste des models à afficher
        public RegattaAdapter(Context context, List<Regatta> regattas){
            super(context,0,regattas);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_regatta,parent, false);
            }

            ChallengeViewHolder viewHolder = (ChallengeViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new ChallengeViewHolder();
                viewHolder.nom_regatta_text_view =  convertView.findViewById(R.id.nom_regatta_text_view);
                viewHolder.regatta_date_text_view =  convertView.findViewById(R.id.regatta_date_text_view);
                viewHolder.challenge_nom_text_view =  convertView.findViewById(R.id.challenge_nom_text_view);
                viewHolder.regatta_distance_text_view =  convertView.findViewById(R.id.regatta_distance_text_view);
                convertView.setTag(viewHolder);
            }

            //getItem(position) will get the position of the item in the collection
            Regatta regatta = getItem(position);

            //fill the view
            viewHolder.nom_regatta_text_view.setText(regatta.getRegatta_nom());
            viewHolder.regatta_date_text_view.setText( output.format(regatta.getRegatta_date()));
            viewHolder.challenge_nom_text_view.setText( regatta.getChallenge_nom());
            viewHolder.regatta_distance_text_view.setText(regatta.getRegatta_distance().toString());
            return convertView;
        }

        private class ChallengeViewHolder{
            public TextView nom_regatta_text_view;
            public TextView regatta_date_text_view;
            public TextView challenge_nom_text_view;
            public TextView regatta_distance_text_view;
        }
}
