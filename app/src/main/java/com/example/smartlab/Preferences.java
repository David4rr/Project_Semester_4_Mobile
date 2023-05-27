package com.example.smartlab;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    static final String KEY_EMAIL_TEREGISTER = "email", KEY_PASS_TEREGISTER = "pass";
    static final String KEY_EMAIL_SEDANG_LOGIN = "email_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "status_logged_in";

    private static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLoggedInUser(Context context, String email){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_EMAIL_SEDANG_LOGIN, email);
        editor.apply();
    }

    public static String getLoggedInUser(Context context){
        return getSharedPreferences(context).getString(KEY_EMAIL_SEDANG_LOGIN, "");
    }

    public static void setLoggedInStatus(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(KEY_STATUS_SEDANG_LOGIN, status);
        editor.apply();
    }

    public static boolean getLoggedInStatus(Context context){
        return getSharedPreferences(context).getBoolean(KEY_STATUS_SEDANG_LOGIN, false);
    }

    public static void clearLoggedInUser(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove(KEY_EMAIL_SEDANG_LOGIN);
        editor.remove(KEY_STATUS_SEDANG_LOGIN);
        editor.apply();
    }

}
