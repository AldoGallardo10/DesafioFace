package com.desafiolatam.desafioface.views.splash;

import com.desafiolatam.desafioface.models.CurrentUser;

import java.util.List;

/**
 * Created by Aldo Gallardo on 27-03-2017. Presenter
 */

public class LoginValidation {

    private LoginCallback loginCallback;

    public LoginValidation(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    //presentador que valida al usuario
    public void validate(){
        List<CurrentUser> currentUsers = CurrentUser.listAll(CurrentUser.class);
        if (currentUsers != null && currentUsers.size()>0){
            loginCallback.signed();
        }else{
            loginCallback.signIn();
        }
    }
}
