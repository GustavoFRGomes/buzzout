package xyz.jaggedlabs.edge.buzzout.sections.onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.FinalOnBoardingFragment;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.InitialOnBoardingFragment;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.PersonalInfoOnBoardingFragment;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.SchedulingOnBoardingFragment;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.WeighInsOnBoardingFragment;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class OnBoardingViewPagerAdapter extends FragmentStatePagerAdapter
{
    public OnBoardingViewPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment;
        switch (position)
        {
            case 0:
                fragment = InitialOnBoardingFragment.newInstance();
                break;
            case 1:
                fragment = PersonalInfoOnBoardingFragment.newInstance();
                break;
            case 2:
                fragment = WeighInsOnBoardingFragment.newInstance();
                break;
            case 3:
                fragment = SchedulingOnBoardingFragment.newInstance();
                break;

            case 4:
            default:
                fragment = FinalOnBoardingFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount()
    {
        return 5;
    }
}
