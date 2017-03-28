package com.desafiolatam.desafioface.background;

import android.os.AsyncTask;

import java.util.Map;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public class GetUsers extends AsyncTask<Map<String, String>, Integer, Integer> {

    private int additionalPages;

    public GetUsers(int additionalPages) {
        this.additionalPages = additionalPages;
    }

    @Override
    protected Integer doInBackground(Map<String, String>... params) {

        return null;
    }
}
