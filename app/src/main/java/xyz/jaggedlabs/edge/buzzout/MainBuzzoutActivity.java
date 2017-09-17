package xyz.jaggedlabs.edge.buzzout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import xyz.jaggedlabs.edge.buzzout.sections.onboarding.OnBoardingActivity;
import xyz.jaggedlabs.edge.buzzout.sections.base.BaseActivity;

public class MainBuzzoutActivity extends BaseActivity implements View.OnClickListener
{

    private Button onboardingButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_workout:
                    onboardingButton.setText(R.string.title_workout);
                    return true;
                case R.id.navigation_calendar:
                    onboardingButton.setText(R.string.title_calendar);
                    return true;
                case R.id.navigation_profile:
                    onboardingButton.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzout);

        onboardingButton = (Button) findViewById(R.id.center_button);
        this.onboardingButton.setOnClickListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onClick(View v)
    {
        this.pushHeaderlessActivity(OnBoardingActivity.class);
    }
}
