package org.nex.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadUtil {
    private ThreadUtil() { }

    public static Future doInBackground(Callable callable) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(callable);

        return future;
    }
}
