package xyz.jaggedlabs.edge.buzzout.sections.onboarding;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public interface IOnOnboardingNavigationClicked
{
    void previousPage(OnBoardingSteps stepPosition);
    void nextPage(OnBoardingSteps stepPosition);
}
