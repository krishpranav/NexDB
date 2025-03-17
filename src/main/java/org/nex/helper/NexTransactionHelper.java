package org.nex.helper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import javax.security.auth.callback.Callback;

import static org.nex.NexContext.getNexContext;

public final class NexTransactionHelper {
    private static final String LOG_TAG = NexTransactionHelper.class.getSimpleName();

    public static void doInTransaction(Callback callback) {
        final SQLiteDatabase database = getNexContext().getNexDb().getDB();
        database.beginTransaction();

        try {
            if (ManifestHelper.isDebugEnabled()) {
                Log.d(LOG_TAG, "Callable executing within transaction");
            }

        }
    }

    public interface Callback {
        void maniputeInTransaction();
    }
}
