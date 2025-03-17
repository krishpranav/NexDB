package org.nex.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;

public class ContextUtil {
    private static Context ctx;

    private ContextUtil() { }

    public static void init(Context context) {
        if (null == context) {
            throw new IllegalArgumentException("Context shouldn't be null!!!");
        }

        ctx = context;
    }

    public static void terminate() {
        ctx = null;
    }

    public static Context getContext() {
        return ctx;
    }
}
