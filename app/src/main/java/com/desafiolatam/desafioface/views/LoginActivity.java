package com.desafiolatam.desafioface.views;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.desafiolatam.desafioface.R;
import com.desafiolatam.desafioface.models.CurrentUser;
import com.desafiolatam.desafioface.network.LoginInterceptor;
import com.desafiolatam.desafioface.network.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        View view = findViewById(R.id.root);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //implementar
        Session session = new LoginInterceptor().get();
        Call<CurrentUser> call = session.login("erick@gmail.com","desafioandroid");
        call.enqueue(new Callback<CurrentUser>() {
            @Override
            public void onResponse(Call<CurrentUser> call, Response<CurrentUser> response) {
              if (200==response.code() && response.isSuccessful()){
                  CurrentUser user = response.body();
                  Toast.makeText(LoginActivity.this, user.getAuth_token(), Toast.LENGTH_SHORT).show();
                  user.create();
                  Log.d("Serve",String.valueOf(user.getServerId()));
              }else{
                  Toast.makeText(LoginActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onFailure(Call<CurrentUser> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "fallo", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
