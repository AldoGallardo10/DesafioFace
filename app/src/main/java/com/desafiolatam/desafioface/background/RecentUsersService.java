package com.desafiolatam.desafioface.background;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import static android.content.ContentValues.TAG;


public class RecentUsersService extends IntentService {


    private static final String ACTION_RECENT_USERS = "com.desafiolatam.desafioface.background.action.ACTION_RECENT_USERS";

    public RecentUsersService() {
        super("RecentUsersService");
    }


    public static void startActionRecentUseres(Context context) {
        Intent intent = new Intent(context, RecentUsersService.class);
        intent.setAction(ACTION_RECENT_USERS);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_RECENT_USERS.equals(action)) {
                fetchUsere();
            }
        }
    }


    private void fetchUsere() {
        Log.d(TAG, "fetchUsere: ");
    }


}
