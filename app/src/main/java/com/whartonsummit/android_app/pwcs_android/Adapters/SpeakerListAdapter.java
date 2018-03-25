package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.whartonsummit.android_app.pwcs_android.Models.Speaker;
import com.whartonsummit.android_app.pwcs_android.R;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class SpeakerListAdapter extends RecyclerView.Adapter<SpeakerListAdapter.ViewHolder>{

    List<Speaker> data;

    public SpeakerListAdapter(List<Speaker> speakerData) {
        this.data = speakerData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speaker_grid_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Speaker speaker = data.get(position);
        holder.title.setText(speaker.getName());
        holder.imageView.setImageResource(R.drawable.speaker_kevin_rudd);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.info_text) TextView title;
        @BindView(R.id.imageView) ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
