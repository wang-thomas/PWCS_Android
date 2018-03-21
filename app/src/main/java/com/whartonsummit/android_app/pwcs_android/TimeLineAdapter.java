package com.whartonsummit.android_app.pwcs_android;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

/**
 * Created by zhileizheng on 3/21/18.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder>  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;


    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.timeline_item, parent, false);

        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        holder.mDate.setVisibility(View.VISIBLE);
        holder.mDate.setText("Finance Panel");
        holder.mMessage.setText("This is awesome");
        holder.mTimelineDesc.setText("Your RecyclerViewHolder should have an extra paramenter in constructor i.e viewType from onCreateViewHolder. You would also have to call the method initLine(viewType) in constructor definition.");
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
