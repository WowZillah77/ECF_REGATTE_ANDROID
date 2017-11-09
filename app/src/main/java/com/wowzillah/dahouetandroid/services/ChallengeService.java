package com.wowzillah.dahouetandroid.services;

import com.wowzillah.dahouetandroid.model.Challenge;

import java.util.ArrayList;

import retrofit.http.GET;

/**
 * Created by david on 07/11/17.
 */
public interface ChallengeService {

    public static final String ENDPOINT = "http://10.105.49.50:8080";
    @GET("/challenge/")
    ArrayList<Challenge> challenges();
}
