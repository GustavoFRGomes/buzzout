package xyz.jaggedlabs.edge.buzzout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by gustavogomes on 17/09/2017.
 */

public class NonSwipeableViewPager extends ViewPager
{
    private boolean enabled = true;

    public NonSwipeableViewPager(Context context)
    {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return this.enabled && super.onTouchEvent(event);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event)
    {
        return this.enabled && super.onInterceptTouchEvent(event);

    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
