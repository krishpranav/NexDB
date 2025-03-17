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
            throw new NullPointerException("");
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
}
