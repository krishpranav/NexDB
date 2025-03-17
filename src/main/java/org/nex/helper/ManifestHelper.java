package org.nex.helper;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import static org.nex.util.ContextUtil.*;

public final class ManifestHelper {
    private static final String LOG_TAG = "Nex";
    private static Boolean debugEnabled = null;

    public final String METADATA_DATABASE = "DATABASE";


    public final static String METADATA_VERSION = "VERSION";
    public final static String METADATA_DOMAIN_PACKAGE_VERSION = "DOMAIN_PACKAGE_VERSION";
    public final static String METADATA_QUERY_LOG = "QUERY_LOG";

    public final static String DATABASE_DEFAULT_NAME = "Nex.db";

    private ManifestHelper() { }
}
