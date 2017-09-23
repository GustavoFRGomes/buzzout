package xyz.jaggedlabs.edge.buzzout.sections.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.jaggedlabs.edge.buzzout.ui.components.NonSwipeableViewPager;
import xyz.jaggedlabs.edge.buzzout.R;

/**
 * Gustavo Gomes on 17/09/2017.
 */

public class OnBoardingFragment extends Fragment implements IOnOnboardingNavigationClicked
{
    public static OnBoardingFragment newInstance()
    {
        OnBoardingFragment fragment = new OnBoardingFragment();

        return fragment;
    }

    private NonSwipeableViewPager onBoardingViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding, container, false);

        onBoardingViewPager = (NonSwipeableViewPager) rootView.findViewById(R.id.onboarding_view_pager);
        onBoardingViewPager.setAdapter(new OnBoardingViewPagerAdapter(this.getChildFragmentManager()));
        onBoardingViewPager.setPagingEnabled(false);

        return rootView;
    }

    @Override
    public void previousPage(OnBoardingSteps position)
    {
        int currentItem = this.onBoardingViewPager.getCurrentItem();

        if (currentItem - 1 < 0)
        {
            currentItem = this.onBoardingViewPager.getAdapter().getCount() - 1;
        }
        else
        {
            currentItem--;
        }

        this.onBoardingViewPager.setCurrentItem(currentItem);
    }

    @Override
    public void nextPage(OnBoardingSteps position)
    {
        int currentItem = this.onBoardingViewPager.getCurrentItem();

        if (currentItem + 1 == this.onBoardingViewPager.getAdapter().getCount())
        {
            currentItem = 0;
        }
        else
        {
            currentItem++;
        }

        this.onBoardingViewPager.setCurrentItem(currentItem);
    }
}
