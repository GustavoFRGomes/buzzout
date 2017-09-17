package xyz.jaggedlabs.edge.buzzout.sections.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import xyz.jaggedlabs.edge.buzzout.R;

/**
 *   Gustavo Gomes on 17/09/2017.
 */

public class BaseActivity extends AppCompatActivity
{
    private final String HAS_TITLE = "HAS_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceBundle)
    {
        super.onCreate(savedInstanceBundle);
        boolean presentTitle = this.getIntent().getBooleanExtra(HAS_TITLE, true);

        // TODO: The content view should change into a different base layout
        this.setContentView(R.layout.activity_base);

        if (!presentTitle)
            this.getSupportActionBar().hide();
    }

    public void pushHeaderlessActivity(Class headerLessActivity)
    {
        this.pushHeaderlessActivity(headerLessActivity, new Bundle());
    }
    public void pushHeaderlessActivity(Class headerLessActivity, Bundle bundle)
    {
        bundle.putBoolean(HAS_TITLE, false);
        this.pushActivity(headerLessActivity, bundle);
    }

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

    public void pushFragment(Fragment fragment)
    {
        this.pushFragment(fragment, new Bundle());
    }

    public void pushFragment(Fragment fragment, Bundle bundle)
    {
        this.setFragment(fragment);
    }

    protected void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
