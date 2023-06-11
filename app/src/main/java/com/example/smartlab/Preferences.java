package com.example.smartlab;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    static final String KEY_USER_TEREGISTER = "nama", KEY_EMAIL_TEREGISTER = "email", KEY_NOHP_TEREGISTER = "phone", KEY_PASS_TEREGISTER = "pass";
    static final String KEY_EMAIL_SEDANG_LOGIN = "email_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "status_logged_in";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String PREF_NAME = "Pref";

    private static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Preferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveString(String Key, String Value){
        editor.putString(Key, Value);
        editor.apply();
    }

    public String getString (String Key, String defaultValue){
        return sharedPreferences.getString(Key, defaultValue);
    }

    public static void setRegisteredNohp(Context context, String phone){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_NOHP_TEREGISTER, phone);
        editor.apply();
    }

    public static void setRegisteredUser(Context context, String nama){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USER_TEREGISTER, nama);
        editor.apply();
    }

    public static void setRegisteredEmail(Context context, String email){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_EMAIL_TEREGISTER, email);
        editor.apply();
    }

    public static void setRegisteredPass(Context context, String password){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_PASS_TEREGISTER, password);
        editor.apply();
    }

    public static String getRegisteredUser(Context context){
        return getSharedPreferences(context).getString(KEY_USER_TEREGISTER, "");
    }

    public static String getRegisteredNohp(Context context){
        return getSharedPreferences(context).getString(KEY_NOHP_TEREGISTER, "");
    }

    public static String getRegisteredEmail(Context context){
        return getSharedPreferences(context).getString(KEY_PASS_TEREGISTER, "");
    }

    public static String getRegisteredPass(Context context){
        return getSharedPreferences(context).getString(KEY_EMAIL_TEREGISTER, "");
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
        editor.clear();
        editor.apply();
    }

}
