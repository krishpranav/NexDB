package org.nex;

import android.app.Application;

public class NexApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NexContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        NexContext.terminate();
    }
}
