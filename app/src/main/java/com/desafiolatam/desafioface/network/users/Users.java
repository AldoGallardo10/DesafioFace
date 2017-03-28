package com.desafiolatam.desafioface.network.users;

import com.desafiolatam.desafioface.models.Developer;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public interface Users {

    @GET("users")
    Call<Developer[]> get(@QueryMap Map<String,String> querymap);


}
