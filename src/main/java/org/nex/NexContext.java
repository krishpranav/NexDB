package org.nex;

import android.content.Context;
import org.nex.util.ContextUtil;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class NexContext {

    private static NexDbConfiguration dbConfiguration = null;
    private static NexContext instance = null;
    private NexDb nexDb;
    private Map<Object, Long> entitiesMap;

    private NexContext() {
        this.nexDb = NexDb.getInstance();
        this.entitiesMap = Collections.synchronizedMap(new WeakHashMap<Object, Long>());
    }

    public static NexContext getNexContext() {
        if (instance == null) {
            throw new NullPointerException("NexContext has not been initialized properly. Call NexContext.init(Context) in your Application.onCreate() method and NexContext.terminate() in your Application.onTerminate() method.");
        }

        return instance;
    }

    public static void init(Context context) {
        ContextUtil.init(context);
        instance = new NexContext();
        dbConfiguration = null;
    }

    public static void init(Context context, NexDbConfiguration configuration) {
        init(context);
        dbConfiguration = configuration;
    }


    public static void terminate() {
        if (instance == null) {
            return;
        }
        instance.doTerminate();
        ContextUtil.terminate();
    }

    private void doTerminate() {
        if (this.nexDb != null) {
            this.nexDb.getDB().close();
        }
    }

    public static NexDbConfiguration getDbConfiguration() {
        return dbConfiguration;
    }

    public NexDb getNexDb() {
        return nexDb;
    }

    public Map<Object, Long> getEntitiesMap() {
        return entitiesMap;
    }
}