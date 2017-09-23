package xyz.jaggedlabs.edge.buzzout.sections.onboarding;

import xyz.jaggedlabs.edge.buzzout.sections.onboarding.OnBoardingFragment;

/**
 * Created by gustavogomes on 23/09/2017.
 */

public enum OnBoardingSteps
{
    INITIAL_PAGE(0),
    PERSONAL_INFO(1),
    WEIGHINS_PAGE(2),
    SCHEDULING_PAGE(3),
    FINAL_PAGE(4);

    private final int value;

    OnBoardingSteps(final int value)
    {
        this.value = value;
    }

    public int getValue() { return value; }
}
