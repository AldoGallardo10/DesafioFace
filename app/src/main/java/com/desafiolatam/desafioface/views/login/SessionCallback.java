package com.desafiolatam.desafioface.views.login;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public interface SessionCallback {

    void requiredField();
    void mailFormat();
    void success();
    void failed();
}
