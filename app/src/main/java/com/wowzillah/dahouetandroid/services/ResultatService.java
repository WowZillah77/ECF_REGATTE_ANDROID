package com.wowzillah.dahouetandroid.services;

import com.wowzillah.dahouetandroid.model.Resultat;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by david on 08/11/17.
 */

public interface ResultatService {
    public static final String ENDPOINT = "http://10.105.49.50:8080";
    @GET("/regate/{id}/resultat/")
    List<Resultat> resultats(@Path("id") int id);
}
