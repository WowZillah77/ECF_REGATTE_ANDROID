package com.wowzillah.dahouetandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wowzillah.dahouetandroid.R;
import com.wowzillah.dahouetandroid.model.Challenge;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by david on 07/11/17.
 */

public class ChallengeAdapter  extends ArrayAdapter<Challenge>{
   SimpleDateFormat output = new SimpleDateFormat("dd/MM/yy");
    //challenges est la liste des models à afficher
    public ChallengeAdapter(Context context, List<Challenge> challenges){
        super(context,0,challenges);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_challenge,parent, false);
        }

        ChallengeViewHolder viewHolder = (ChallengeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ChallengeViewHolder();
            viewHolder.challenge_nom_text_view =  convertView.findViewById(R.id.challenge_nom_text_view);
            viewHolder.date_debut_text_view =  convertView.findViewById(R.id.date_debut_text_view);
            viewHolder.date_fin_text_view =  convertView.findViewById(R.id.date_fin_text_view);
            viewHolder.challenge_code_text_view =  convertView.findViewById(R.id.challenge_code_text_view);
            convertView.setTag(viewHolder);
        }

        //getItem(position) will get the position of the item in the collection
        Challenge challenge = getItem(position);

        //fill the view
        viewHolder.challenge_nom_text_view.setText(challenge.getChallenge_nom());
        viewHolder.date_debut_text_view.setText( output.format(challenge.getChallenge_date_debut()));
        viewHolder.date_fin_text_view.setText( output.format(challenge.getChallenge_date_fin()));
        viewHolder.challenge_code_text_view.setText(challenge.getChallenge_code());
        return convertView;
    }

    private class ChallengeViewHolder{
        public TextView challenge_nom_text_view;
        public TextView date_debut_text_view;
        public TextView date_fin_text_view;
        public TextView challenge_code_text_view;
    }
}
