package org.nex.helper;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import static org.nex.util.ContextUtil.*;

public final class ManifestHelper {
    private static final String LOG_TAG = "Nex";
    private static Boolean debugEnabled = null;


    public final static String METADATA_DATABASE = "DATABASE";

    public final static String METADATA_VERSION = "VERSION";
    public final static String METADATA_DOMAIN_PACKAGE_NAME = "DOMAIN_PACKAGE_NAME";
    public final static String METADATA_QUERY_LOG = "QUERY_LOG";

    public final static String DATABASE_DEFAULT_NAME = "Nex.db";

    private ManifestHelper() { }

    public static int getDatabaseVersion() {
        Integer databaseVersion = getMetaDataInteger(METADATA_VERSION);

        if ((databaseVersion == null) || (databaseVersion == 0)) {
            databaseVersion = 1;
        }

        return databaseVersion;
    }

    public static String getDomainPackageName() {
        String domainPackageName = getMetaDataString(METADATA_DOMAIN_PACKAGE_NAME);

        if (domainPackageName == null) {
            domainPackageName = "";
        }

        return domainPackageName;
    }

    public static String getDatabaseName() {
        String databaseName = getMetaDataString(METADATA_DATABASE);

        if (databaseName == null) {
            databaseName = DATABASE_DEFAULT_NAME;
        }

        return databaseName;
    }

    public static String getDbName() {
        return getDatabaseName();
    }


    public static boolean isDebugEnabled() {
        return (null == debugEnabled) ? debugEnabled = getMetaDataBoolean(METADATA_QUERY_LOG) : debugEnabled;
    }


    private static String getMetaDataString(String name) {
        PackageManager pm = getPackageManager();
        String value = null;

        try {
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            value = ai.metaData.getString(name);
        } catch (Exception e) {
            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Couldn't find config value: " + name);
            }
        }

        return value;
    }

    private static Integer getMetaDataInteger(String name) {
        PackageManager pm = getPackageManager();
        Integer value = null;

        try {
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            value = ai.metaData.getInt(name);
        } catch (Exception e) {
            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Couldn't find config value: " + name);
            }
        }

        return value;
    }

    private static Boolean getMetaDataBoolean(String name) {
        PackageManager pm = getPackageManager();
        Boolean value = false;

        try {
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            value = ai.metaData.getBoolean(name);
        } catch (Exception e) {
            Log.d(LOG_TAG, "Couldn't find config value: " + name);
        }

        return value;
    }
}