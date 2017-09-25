package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.data.ScheduleCategory;
import xyz.jaggedlabs.edge.buzzout.data.onboading.ScheduleItem;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.IOnOnboardingNavigationClicked;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.OnBoardingSteps;
import xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.workout.scheduling.SchedulingOnBoardingAdapter;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class SchedulingOnBoardingFragment extends Fragment implements View.OnClickListener
{
    public static SchedulingOnBoardingFragment newInstance()
    {
        return new SchedulingOnBoardingFragment();
    }

    private Button nextPageButton;
    private Button previousPageButton;

    private RecyclerView todaysSchedule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstance)
    {
        View rootView = inflater.inflate(R.layout.fragment_onboarding_scheduling_page, parent, false);

        this.todaysSchedule = (RecyclerView) rootView.findViewById(R.id.todays_schedule_line);
        this.todaysSchedule.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        this.todaysSchedule.setAdapter(new SchedulingOnBoardingAdapter(this.getContext(), this.getScheduledItems()));

        this.nextPageButton = ((Button) rootView.findViewById(R.id.next_button));
        this.nextPageButton.setOnClickListener(this);

        this.previousPageButton = ((Button) rootView.findViewById(R.id.previous_button));
        this.previousPageButton.setOnClickListener(this);

        return rootView;
    }

    private List<ScheduleItem> getScheduledItems()
    {
        List<ScheduleItem> scheduleItems = new ArrayList<>();

        Date tempDate = new Date();
        Calendar cal = Calendar.getInstance(); // creates calendar

        for(int i=0; i<14; i++)
        {
            cal.setTime(tempDate); // sets calendar time/date
            cal.add(Calendar.HOUR, i);

            scheduleItems.add(new ScheduleItem("Item #" + Integer.toString(i),
                    i % 2 == 0 ? ScheduleCategory.WORKOUT : ScheduleCategory.OTHER,
                    cal.getTime(),
                    cal.getTime()));
        }

        return scheduleItems;
    }

    @Override
    public void onClick(View v)
    {
        if (this.getParentFragment() instanceof IOnOnboardingNavigationClicked)
        {
            if (v.getId() == this.nextPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).nextPage(OnBoardingSteps.SCHEDULING_PAGE);
            }
            else if (v.getId() == this.previousPageButton.getId())
            {
                ((IOnOnboardingNavigationClicked) this.getParentFragment()).previousPage(OnBoardingSteps.SCHEDULING_PAGE);
            }
        }
    }
}
