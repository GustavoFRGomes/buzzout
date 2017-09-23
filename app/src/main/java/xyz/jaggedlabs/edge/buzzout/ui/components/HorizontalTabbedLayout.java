package xyz.jaggedlabs.edge.buzzout.ui.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.HorizontalScrollView;

import xyz.jaggedlabs.edge.buzzout.R;

/**
 * Gustavo Gomes on 23/09/2017.
 */

public class HorizontalTabbedLayout extends HorizontalScrollView
{
    private static final int DEFAULT_TAB_TEXT_SIZE_SP = 16;
    private static final int DEFAULT_TAB_PADDING_DIPS = 16;
    private static final int DEFAULT_TITLE_OFFSET_DIPS = 24;

    public HorizontalTabbedLayout(Context context)
    {
        this(context, null);
    }

    public HorizontalTabbedLayout(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public HorizontalTabbedLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr)
    {
        // Disable Horizontal Scroll Bar
        this.setHorizontalScrollBarEnabled(false);

        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        final float displayDensity = displayMetrics.density;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HorizontalTabbedLayout, defStyleAttr, 0);

        int backgroundResId = typedArray.getResourceId(R.styleable.HorizontalTabbedLayout_tab_background, Color.TRANSPARENT);
        boolean textAllCaps = typedArray.getBoolean(R.styleable.HorizontalTabbedLayout_tabs_textAllCaps, true);
        ColorStateList textColors = typedArray.getColorStateList(R.styleable.HorizontalTabbedLayout_tabs_textColor);
        float textSize = typedArray.getDimension(R.styleable.HorizontalTabbedLayout_tabs_textSize, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, DEFAULT_TAB_TEXT_SIZE_SP, displayMetrics));
        float horizontalPadding = typedArray.getDimensionPixelSize(R.styleable.HorizontalTabbedLayout_tabs_horizontalPadding,
                (int)(DEFAULT_TAB_PADDING_DIPS * displayDensity));
        float textMinWidth = typedArray.getDimensionPixelSize(R.styleable.HorizontalTabbedLayout_tabs_textMinWidth, 0);
        // custom tab view
        // custom textView id in view
        boolean tabsDistributedEvenly = typedArray.getBoolean(R.styleable.HorizontalTabbedLayout_tabs_distributeEvenly, true);
        boolean tabsAreClickable = typedArray.getBoolean(R.styleable.HorizontalTabbedLayout_tabs_clickable, true);
        int titleOffset = typedArray.getLayoutDimension(R.styleable.HorizontalTabbedLayout_tabs_titleOffset,
                (int)(DEFAULT_TITLE_OFFSET_DIPS * displayDensity));

        typedArray.recycle();
    }

}
