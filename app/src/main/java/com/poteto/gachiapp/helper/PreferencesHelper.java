package com.poteto.gachiapp.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

public class PreferencesHelper {
    private final String PREFS_FILE = "gachiPrefs";
    public final String KEY_FIRST_TIME = "note";
    private SharedPreferences preferences;

    public PreferencesHelper(Context context) {
        preferences = context.getSharedPreferences(PREFS_FILE, 0);
    }

    public void savePref(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void savePref(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();


    }

    public void savePref(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public Boolean contains(String key) {
        return preferences.contains(key);
    }

    public Boolean getBoolean(String key) {
        return preferences.getBoolean(key, true);
    }

    public int getInt(String key) {
        return preferences.getInt(key, -1);
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }
}
