package com.linked.erfli.complexstream;

import android.app.Application;
import android.content.Context;

/**
 * Created by erfli on 11/21/16.
 */

public class _Application extends Application {

    public static Context applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

}
