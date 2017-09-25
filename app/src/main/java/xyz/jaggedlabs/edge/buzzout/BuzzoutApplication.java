package xyz.jaggedlabs.edge.buzzout;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by gustavogomes on 24/09/2017.
 */

public class BuzzoutApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Amaranth-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
