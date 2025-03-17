package org.nex.helper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import static org.nex.NexContext.getNexContext;

public final class NexTransactionHelper {
    private static final String LOG_TAG = NexTransactionHelper.class.getSimpleName();

    private NexTransactionHelper() { }

    public static void doInTransaction(Callback callback) {
        final SQLiteDatabase database = getNexContext().getNexDb().getDB();
        database.beginTransaction();

        try {
            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Callback executing within transaction");
            }

            callback.manipulateInTransaction();
            database.setTransactionSuccessful();

            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Callback successfully executed within transaction");
            }
        } catch (Throwable e) {
            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Could execute callback within transaction", e);
            }
        } finally {
            database.endTransaction();
        }
    }

    public interface Callback {
        void manipulateInTransaction();
    }
}