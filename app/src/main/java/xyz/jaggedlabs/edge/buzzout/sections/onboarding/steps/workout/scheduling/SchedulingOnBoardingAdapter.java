package xyz.jaggedlabs.edge.buzzout.sections.onboarding.steps.workout.scheduling;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import xyz.jaggedlabs.edge.buzzout.R;
import xyz.jaggedlabs.edge.buzzout.data.onboading.ScheduleItem;

/**
 * Created by gustavogomes on 24/09/2017.
 */

public class SchedulingOnBoardingAdapter extends RecyclerView.Adapter
{
    private Context context;
    private List<ScheduleItem> scheduleItems;

    public SchedulingOnBoardingAdapter(Context context, List<ScheduleItem> scheduleItems)
    {
        this.context = context;
        this.scheduleItems = scheduleItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(this.context).inflate(R.layout.schedule_item, parent, false);

        return new ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ((ScheduleViewHolder) holder).bind(this.scheduleItems.get(position));
    }

    @Override
    public int getItemCount()
    {
        return this.scheduleItems == null ? 0 : this.scheduleItems.size();
    }

    public List<ScheduleItem> getScheduleList()
    {
        return this.scheduleItems;
    }

    public void addScheduleItemToList(ScheduleItem item)
    {
        this.scheduleItems.add(item);
        // Should sort the list. This is a feature for editing.
        this.notifyDataSetChanged();
    }

    private class ScheduleViewHolder extends RecyclerView.ViewHolder
    {
        private TextView itemName;
        private TextView itemTimeFrame;

        public ScheduleViewHolder(View itemView)
        {
            super(itemView);
            this.itemName = ((TextView) itemView.findViewById(R.id.schedule_item_title));
            this.itemTimeFrame = ((TextView) itemView.findViewById(R.id.schedule_item_time));
        }

        public void bind(ScheduleItem item)
        {
            this.itemName.setText(item.getName());
            //this.itemName.setBackgroundResource(item.getScheduleCategory() == ScheduleCategory.WORKOUT ? R.color.black : R.color.colorPrimaryDark);

            Calendar cal = Calendar.getInstance();
            cal.setTime(item.getFromDate());
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            this.itemTimeFrame.setText(String.format("%s", cal.get(Calendar.HOUR)));
        }
    }

}
