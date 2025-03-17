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
    public final static String METADATA_DOMAIN_PACKAGE_VERSION = "DOMAIN_PACKAGE_VERSION";
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

    public static String getDatabaseName() {
        String databaseName = getMetadataString(METADATA_DATABASE);

        if (databaseName == null) {
            databaseName = DATABASE_DEFAULT_NAME;
        }

        return databaseName;
    }

    public static String getDbName() {
        return getDatabaseName();
    }

    private static String getMetadataString(String name) {
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
    }
}
