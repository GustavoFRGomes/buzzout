package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.IOnOnboardingNavigationClicked;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.OnBoardingSteps;

/**
 * Gustavo Gomes on 17/09/2017.
 */

public class WeighInsOnBoardingFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
    private enum WEIGHT_IN_INTERVALS { DAILY, WEEKLY, MONTHLY, X_DAYS }

    public static WeighInsOnBoardingFragment newInstance()
    {
        return new WeighInsOnBoardingFragment();
    }

    private Button nextPageButton;
    private Button previousPageButton;

    private CheckBox daily;
    private CheckBox weekly;
    private CheckBox monthly;
    private CheckBox xDays;

    private EditText xDaysInput;
    private TextView xDaysEmptyError;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceBundle)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_weighins_page, parent, false);

        this.nextPageButton = ((Button) rootView.findViewById(R.id.next_button));
        this.nextPageButton.setOnClickListener(this);

        this.previousPageButton = ((Button) rootView.findViewById(R.id.previous_button));
        this.previousPageButton.setOnClickListener(this);

        this.daily = (CheckBox) rootView.findViewById(R.id.weight_in_daily);
        this.weekly = (CheckBox) rootView.findViewById(R.id.weight_in_weekly);
        this.monthly = (CheckBox) rootView.findViewById(R.id.weight_in_monthly);
        this.xDays = (CheckBox) rootView.findViewById(R.id.weight_in_x_days);
        this.xDaysInput = (EditText) rootView.findViewById(R.id.x_days_input);
        this.xDaysEmptyError = (TextView) rootView.findViewById(R.id.empty_value_error);

        this.daily.setOnCheckedChangeListener(this);
        this.weekly.setOnCheckedChangeListener(this);
        this.monthly.setOnCheckedChangeListener(this);
        this.xDays.setOnCheckedChangeListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v)
    {
        if (this.getParentFragment() instanceof IOnOnboardingNavigationClicked)
        {
            if (v.getId() == this.nextPageButton.getId())
            {
                if (this.getSelectedInterval() == WEIGHT_IN_INTERVALS.X_DAYS && this.xDaysInput.getText().toString().isEmpty())
                {
                    this.xDaysEmptyError.setText(R.string.onboarding_weight_in_x_days_empty);
                }
                else
                {
                    this.xDaysEmptyError.setText("");
                    ((IOnOnboardingNavigationClicked) this.getParentFragment()).nextPage(OnBoardingSteps.WEIGHINS_PAGE);
                }
            }
            else if (v.getId() == this.previousPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).previousPage(OnBoardingSteps.WEIGHINS_PAGE);
            }
        }
    }

    private WEIGHT_IN_INTERVALS getSelectedInterval() {
        if (this.daily.isChecked())
        {
            return WEIGHT_IN_INTERVALS.DAILY;
        }

        if (this.weekly.isChecked())
        {
            return WEIGHT_IN_INTERVALS.WEEKLY;
        }

        if (this.monthly.isChecked())
        {
            return WEIGHT_IN_INTERVALS.MONTHLY;
        }

        return WEIGHT_IN_INTERVALS.X_DAYS;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        int id = buttonView.getId();

        if (isChecked)
        {
            this.singleCheckAndDisableAction(
                    this.daily.getId() == id,
                    this.weekly.getId() == id,
                    this.monthly.getId() == id,
                    this.xDays.getId() == id);
        }
    }

    private void singleCheckAndDisableAction(boolean daily, boolean weekly, boolean monthly, boolean xDays)
    {
        this.daily.setChecked(daily);
        this.daily.setClickable(!daily);

        this.monthly.setChecked(monthly);
        this.monthly.setClickable(!monthly);

        this.weekly.setChecked(weekly);
        this.weekly.setClickable(!weekly);

        this.xDays.setChecked(xDays);
        this.xDays.setClickable(!xDays);
    }
}
