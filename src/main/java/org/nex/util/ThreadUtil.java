package org.nex.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class ThreadUtil {

    private ThreadUtil() { }

    public static Future doInBackground(Callable callable) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(callable);

        if(executor.isTerminated()) {
            executor.shutdown();
        }

        return future;
    }
}