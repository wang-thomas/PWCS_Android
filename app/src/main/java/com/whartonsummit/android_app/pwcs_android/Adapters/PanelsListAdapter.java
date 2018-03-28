package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.Models.Speaker;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class PanelsListAdapter extends RecyclerView.Adapter<PanelsListAdapter.ViewHolder>{

    List<Panel> data;

    public PanelsListAdapter(List<Panel> panelsData) {
        this.data = panelsData;
    }

    @Override
    public PanelsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.panel_item, parent, false);
        return new PanelsListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PanelsListAdapter.ViewHolder holder, int position) {
        Panel panel = data.get(position);
        holder.title.setText(panel.getName());
        holder.location.setText(panel.getLocation());
        holder.time.setText(panel.getTime());
        holder.imageView.setImageResource(panel.getImageResource());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_info) TextView title;
        @BindView(R.id.background_image) ImageView imageView;
        @BindView(R.id.location_info) TextView location;
        @BindView(R.id.time_info) TextView time;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
