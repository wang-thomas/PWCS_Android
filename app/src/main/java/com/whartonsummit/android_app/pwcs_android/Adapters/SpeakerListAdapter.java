package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whartonsummit.android_app.pwcs_android.Activities.PanelDetailsActivity;
import com.whartonsummit.android_app.pwcs_android.Activities.SpeakerDetailsActivity;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Speaker speaker = data.get(position);
        holder.name.setText(speaker.getName());
        holder.title.setText(speaker.getTitle());
        Picasso.get().load(speaker.getImageUrl()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = goToSpeaker(speaker, holder.title.getContext());
                holder.title.getContext().startActivity(intent);
            }
        });
    }

    private Intent goToSpeaker(Speaker speaker, Context context){
        Intent intent= new Intent(context, SpeakerDetailsActivity.class);
        intent.putExtra("speaker", speaker);
        return intent;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.speaker_name) TextView name;
        @BindView(R.id.speaker_title) TextView title;
        @BindView(R.id.speaker_image) ImageView imageView;
        @BindView(R.id.card_view) CardView cardView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
