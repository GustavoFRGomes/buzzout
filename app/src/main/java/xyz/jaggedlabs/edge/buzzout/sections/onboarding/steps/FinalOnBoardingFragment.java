package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.IOnOnboardingNavigationClicked;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class FinalOnBoardingFragment extends Fragment implements View.OnClickListener
{
    public static FinalOnBoardingFragment newInstance()
    {
        return new FinalOnBoardingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceBundle)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_final_page, parent, false);

        rootView.findViewById(R.id.next_button).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        if (this.getParentFragment() instanceof IOnOnboardingNavigationClicked)
        {
            ((IOnOnboardingNavigationClicked) this.getParentFragment()).nextPage(4);
        }
    }
}
