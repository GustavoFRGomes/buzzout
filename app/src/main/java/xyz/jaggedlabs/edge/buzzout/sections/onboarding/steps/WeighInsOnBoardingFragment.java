package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.IOnOnboardingNavigationClicked;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.OnBoardingSteps;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class WeighInsOnBoardingFragment extends Fragment implements View.OnClickListener
{
    public static WeighInsOnBoardingFragment newInstance()
    {
        return new WeighInsOnBoardingFragment();
    }

    private Button nextPageButton;
    private Button previousPageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceBundle)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_weighins_page, parent, false);

        this.nextPageButton = ((Button) rootView.findViewById(R.id.next_button));
        this.nextPageButton.setOnClickListener(this);

        this.previousPageButton = ((Button) rootView.findViewById(R.id.previous_button));
        this.previousPageButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        if (this.getParentFragment() instanceof IOnOnboardingNavigationClicked)
        {
            if (v.getId() == this.nextPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).nextPage(OnBoardingSteps.WEIGHINS_PAGE);
            }
            else if (v.getId() == this.previousPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).previousPage(OnBoardingSteps.WEIGHINS_PAGE);
            }
        }
    }
}
