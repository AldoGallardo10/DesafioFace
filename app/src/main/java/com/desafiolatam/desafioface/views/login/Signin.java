package com.desafiolatam.desafioface.views.login;

import com.desafiolatam.desafioface.models.CurrentUser;
import com.desafiolatam.desafioface.network.session.LoginInterceptor;
import com.desafiolatam.desafioface.network.session.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public class Signin {

    //llamamos a la interface
    private SessionCallback callback;

    public Signin(SessionCallback callback) {
        this.callback = callback;
    }

    public void toServer(String email, String password){
        //implementar
        if (email.trim().length() <= 0 || password.trim().length() <= 0){
            callback.requiredField();
        }else {
            if (!email.contains("@")){
                callback.mailFormat();
            }
        }
        Session session = new LoginInterceptor().get();
        Call<CurrentUser> call = session.login(email,password);
        call.enqueue(new Callback<CurrentUser>() {
            @Override
            public void onResponse(Call<CurrentUser> call, Response<CurrentUser> response) {
                if (200==response.code() && response.isSuccessful()){
                    CurrentUser user = response.body();
                    user.create();
                    callback.success();
                }else{
                   callback.failed();
                }
            }

            @Override
            public void onFailure(Call<CurrentUser> call, Throwable t) {
               callback.failed();
            }
        });
    }
}
