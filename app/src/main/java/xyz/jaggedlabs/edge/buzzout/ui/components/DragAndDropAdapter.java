package xyz.jaggedlabs.edge.buzzout.ui.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

// https://github.com/woxblom/DragListView/blob/master/library/src/main/java/com/woxthebox/draglistview/DragItemRecyclerView.java

public abstract class DragAndDropAdapter<T, VH extends DragAndDropAdapter.ViewHolder> extends RecyclerView.Adapter {

    private List<T> itemList;

    public void setItemList(List<T> newItemList)
    {
        if (this.itemList == null)
        {
            this.itemList = new ArrayList<T>();
        }

        this.itemList.clear();

        if (newItemList != null)
        {
            // Always keep the same reference and simply copy the new items to the existing list.
            this.itemList.clear();
            this.itemList.addAll(newItemList);

            this.notifyDataSetChanged();
        }
    }

    public List<T> getItemList()
    {
        return this.itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.itemList == null ? 0 : this.itemList.size();
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

        private boolean isLongPressDragEnabled;

        public ViewHolder(View itemView, boolean isLongPressDragEnabled) {
            super(itemView);
            this.isLongPressDragEnabled = isLongPressDragEnabled;
        }

        public ViewHolder(View itemView, int onLongPressResId, boolean isLongPressDragEnabled) {
            super(itemView);
            this.isLongPressDragEnabled = isLongPressDragEnabled;

            if (isLongPressDragEnabled)
            {
                View onPressedView = itemView.findViewById(onLongPressResId);
                //onPressedView.set
            }
        }

        public void bind(T object)
        {

        }
    }
}
