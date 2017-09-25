package xyz.jaggedlabs.edge.buzzout.data;

/**
 * Created by gustavogomes on 24/09/2017.
 */

public enum ScheduleCategory
{
    WORKOUT(0),
    WEIGHT_IN(1),
    OTHER(2);

    private int value;
    private ScheduleCategory(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
}
