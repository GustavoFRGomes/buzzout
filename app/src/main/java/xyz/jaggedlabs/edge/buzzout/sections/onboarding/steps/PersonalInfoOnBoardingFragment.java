package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.IOnOnboardingNavigationClicked;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class PersonalInfoOnBoardingFragment extends Fragment implements View.OnClickListener
{
    public static PersonalInfoOnBoardingFragment newInstance()
    {
        return new PersonalInfoOnBoardingFragment();
    }

    private Button nextPageButton;
    private Button previousPageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_personalinfo_page, parent, false);

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
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).nextPage(1);
            }
            else if (v.getId() == this.previousPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).previousPage(1);
            }
        }
    }
}
