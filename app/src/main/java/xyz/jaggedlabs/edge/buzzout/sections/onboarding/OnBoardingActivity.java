package xyz.jaggedlabs.edge.buzzout.sections.onboarding;

import android.os.Bundle;

import xyz.jaggedlabs.edge.buzzout.sections.base.BaseActivity;

/**
 *   Gustavo Gomes on 17/09/2017.
 */

public class OnBoardingActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceBundle)
    {
        super.onCreate(savedInstanceBundle);
        this.pushFragment(OnBoardingFragment.newInstance());
    }
}
