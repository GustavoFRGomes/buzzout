package xyz.jaggedlabs.edge.buzzout.ui.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class DragAndDropRecyclerView extends RecyclerView {

    private DragAndDropAdapter adapter;

    public DragAndDropRecyclerView(Context context) {
        super(context);
    }

    public DragAndDropRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragAndDropRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter)
    {
        if (!(adapter instanceof DragAndDropAdapter))
        {
            throw new RuntimeException("Adapter must be instance of " + DragAndDropAdapter.class);
        }

        if (!adapter.hasStableIds()) {
            throw new RuntimeException("Adapter must have stable ids");
        }

        super.setAdapter(adapter);
        this.adapter = ((DragAndDropAdapter) adapter);
    }

    @Override
    public void setLayoutManager(LayoutManager layoutManager)
    {
        super.setLayoutManager(layoutManager);

        if (!(layoutManager instanceof LinearLayoutManager))
        {
            throw new RuntimeException("LayoutManager must be an instance of LinearLayoutManager");
        }
    }
}
