package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.whartonsummit.android_app.pwcs_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 3/21/18.
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder>  {
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

    public class TimeLineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_timeline_date) public TextView mDate;
        @BindView(R.id.text_timeline_title) public TextView mMessage;
        @BindView(R.id.time_marker) public TimelineView mTimelineView;
        @BindView(R.id.text_timeline_desc) public TextView mTimelineDesc;

        public TimeLineViewHolder(View itemView, int viewType) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mTimelineView.initLine(viewType);
        }
    }
}
