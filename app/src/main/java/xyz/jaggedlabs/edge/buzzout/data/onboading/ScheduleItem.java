package xyz.jaggedlabs.edge.buzzout.data.onboading;

import java.util.Date;

import xyz.jaggedlabs.edge.buzzout.data.ScheduleCategory;

/**
 * Gustavo Gomes on 24/09/2017.
 */

public class ScheduleItem
{
    private String name;
    private ScheduleCategory scheduleCategory;

    // Theses dates should be times, basically from 1 second to 24 hours.
    private Date fromDate;
    private Date untilDate;

    public ScheduleItem(String name, ScheduleCategory scheduleCategory, Date fromDate, Date untilDate)
    {
        this.name = name;
        this.scheduleCategory = scheduleCategory;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ScheduleCategory getScheduleCategory()
    {
        return scheduleCategory;
    }

    public void setScheduleCategory(ScheduleCategory scheduleCategory)
    {
        this.scheduleCategory = scheduleCategory;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getUntilDate()
    {
        return untilDate;
    }

    public void setUntilDate(Date untilDate)
    {
        this.untilDate = untilDate;
    }
}
