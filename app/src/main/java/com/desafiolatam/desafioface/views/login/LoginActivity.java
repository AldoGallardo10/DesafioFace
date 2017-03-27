package com.desafiolatam.desafioface.views.login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desafiolatam.desafioface.R;
import com.desafiolatam.desafioface.models.CurrentUser;
import com.desafiolatam.desafioface.network.LoginInterceptor;
import com.desafiolatam.desafioface.network.Session;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity implements SessionCallback {

    private TextInputLayout mailWrapper, passwordWrapper;
    private EditText mailEt, passEt;
    private Button signinBtn;

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

        mailWrapper = (TextInputLayout) findViewById(R.id.emailTil);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordTil);
        mailEt = (EditText) findViewById(R.id.emailEt);
        passEt = (EditText) findViewById(R.id.passwordEt);
        signinBtn = (Button) findViewById(R.id.signBtn);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mailEt.getText().toString();
                String password = passEt.getText().toString();
                mailWrapper.setVisibility(GONE);
                passwordWrapper.setVisibility(GONE);
                signinBtn.setVisibility(GONE);
                new Signin(LoginActivity.this).toServer(email,password);
            }
        });


    }


    //implementamos session callback
    @Override
    public void requiredField() {
        restoreViews();
        mailEt.setError("Requerido");
        passEt.setError("Requerido");
    }

    @Override
    public void mailFormat() {
        restoreViews();
        mailEt.setError("Formato incorrecto");
    }

    @Override
    public void success() {
        Toast.makeText(this, "funciono ctm!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        restoreViews();
        Toast.makeText(this, "Mail o Password incorrecto", Toast.LENGTH_SHORT).show();
    }

    //metodo para mostrar los botones y los editext
    public void restoreViews() {
        mailEt.setError(null);
        passEt.setError(null);
        mailWrapper.setVisibility(View.VISIBLE);
        passwordWrapper.setVisibility(View.VISIBLE);
        signinBtn.setVisibility(View.VISIBLE);
    }



}
