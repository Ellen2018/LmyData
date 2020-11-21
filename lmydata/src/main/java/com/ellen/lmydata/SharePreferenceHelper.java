package com.ellen.lmydata;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceHelper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharePreferenceHelper(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void save(String key, Object value) {
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else {
            editor.putString(key, value.toString());
        }
        editor.commit();
    }

    public <T> T getValue(String key, T defaultObject) {
        Object objectValue;
        if (defaultObject instanceof String) {
            objectValue = sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            objectValue = sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            objectValue = sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            objectValue = sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            objectValue = sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            objectValue = sharedPreferences.getString(key, null);
        }
        return (T) objectValue;
    }

    public void deleteKey(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }
}
