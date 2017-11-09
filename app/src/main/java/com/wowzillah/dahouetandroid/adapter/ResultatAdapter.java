package com.wowzillah.dahouetandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wowzillah.dahouetandroid.R;
import com.wowzillah.dahouetandroid.model.Resultat;

import java.util.List;

/**
 * Created by david on 08/11/17.
 */

public class ResultatAdapter extends ArrayAdapter<Resultat> {
//regattas est la liste des models à afficher
public ResultatAdapter(Context context, List<Resultat> resultats){
        super(context,0,resultats);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_resultat,parent, false);
        }

        ChallengeViewHolder viewHolder = (ChallengeViewHolder) convertView.getTag();
        if(viewHolder == null){
        viewHolder = new ChallengeViewHolder();
        viewHolder.resultat_position_text_view =  convertView.findViewById(R.id.resultat_position_text_view);
        viewHolder.nom_bateau_text_view =  convertView.findViewById(R.id.nom_bateau_text_view);
       viewHolder.proprietaire_text_view =  convertView.findViewById(R.id.proprietaire_text_view);
        viewHolder.resultat_club_nom =  convertView.findViewById(R.id.resultat_club_nom);
            viewHolder.resultat_temps_compose =  convertView.findViewById(R.id.resultat_temps_composé);

        convertView.setTag(viewHolder);
        }

        //getItem(position) will get the position of the item in the collection
       Resultat resultat = getItem(position);

        //fill the view
        viewHolder.resultat_position_text_view.setText( resultat.getResultat_position());
        viewHolder.nom_bateau_text_view.setText( resultat.getBateau_nom());
        viewHolder.proprietaire_text_view.setText( resultat.getPersonne_prenom()+" "+ resultat.getPersonne_nom());
        viewHolder.resultat_club_nom.setText( resultat.getClub_nom());

        viewHolder.resultat_temps_compose.setText(resultat.getTemp_compose());
        return convertView;
        }

private class ChallengeViewHolder{
    public TextView resultat_position_text_view;
    public TextView nom_bateau_text_view;
    public TextView proprietaire_text_view;
    public TextView resultat_club_nom;
    public TextView resultat_temps_compose;
}
}
