package edu.uw.ischool.activityandfragmentexample;

import android.app.Application;
import android.util.Log;

/**
 * Created by tedneward on 2/8/17.
 */

public class DwarfApplication extends Application {
    private MyRepository instance = new MyRepository();

    public DwarfApplication() {
        Log.d("DwarfApplication", "Constructor fired");
    }

    public MyRepository getRepository() {
        return instance;
    }
}
