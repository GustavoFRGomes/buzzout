package xyz.jaggedlabs.edge.buzzout.sections.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class BaseActivity extends AppCompatActivity
{
    public void pushActivity(Class activityClass)
    {
        this.pushActivity(activityClass, new Bundle());
    }

    public void pushActivity(Class activityClass, Bundle bundle)
    {
        Intent newActivityIntent = new Intent(this, activityClass);
        newActivityIntent.putExtras(bundle);

        this.startActivity(newActivityIntent);

        //TODO: Add a cool looking transitional animation to the mix.
    }
}
