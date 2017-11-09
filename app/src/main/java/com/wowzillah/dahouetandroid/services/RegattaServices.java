package com.wowzillah.dahouetandroid.services;


import com.wowzillah.dahouetandroid.model.Regatta;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by david on 08/11/17.
 */

public interface RegattaServices {
    public static final String ENDPOINT = "http://10.105.49.50:8080";
    @GET("/challenge/{challenge_id}/regates/")
    List<Regatta> regattas(@Path("challenge_id") int challenge_id);

}
