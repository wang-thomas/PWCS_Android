package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.whartonsummit.android_app.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 3/21/18.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder>  {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<TimelineObj> events;


    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.timeline_item, parent, false);

        return new TimeLineViewHolder(view, viewType);
    }

    public TimeLineAdapter(List<TimelineObj> events) {
        this.events = events;
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        TimelineObj obj = events.get(position);
        holder.time.setVisibility(View.VISIBLE);
        holder.time.setText(obj.getTime());
        holder.title.setText(obj.getTitle());
        holder.desc.setText(obj.getDesc());
        holder.location.setText(obj.getLocation());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_timeline_date) public TextView time;
        @BindView(R.id.text_timeline_title) public TextView title;
        @BindView(R.id.time_marker) public TimelineView mTimelineView;
        @BindView(R.id.text_timeline_desc) public TextView desc;
        @BindView(R.id.text_timeline_location) public TextView location;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mTimelineView.initLine(viewType);
        }
    }
}
