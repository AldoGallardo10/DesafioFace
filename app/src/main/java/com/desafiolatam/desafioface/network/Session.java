package com.desafiolatam.desafioface.network;

import com.desafiolatam.desafioface.models.CurrentUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public interface Session {

    // un call esperando un objeto de retrofit
    @FormUrlEncoded //para que me acepte los parametros que meto en el login
    @POST("mobile_sessions")//el resto de la url
    Call<CurrentUser> login(@Field("session[email]") String email, @Field("session[password]") String password); // le decimos que parametros vamos a mandar en esos string

}
