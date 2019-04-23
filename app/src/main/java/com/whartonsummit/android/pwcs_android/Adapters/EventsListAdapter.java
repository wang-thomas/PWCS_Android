package com.whartonsummit.android.pwcs_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whartonsummit.android.pwcs_android.Activities.EventDetailsActivity;
import com.whartonsummit.android.pwcs_android.Models.Event;
import com.whartonsummit.android.pwcs_android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 4/1/18.
 */

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder> {

    List<Event> data;

    public EventsListAdapter(List<Event> eventsData) {
        this.data = eventsData;
    }

    @Override
    public EventsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new EventsListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EventsListAdapter.ViewHolder holder, int position) {
        final Event event = data.get(position);
        holder.title.setText(event.getName());
//        holder.location.setText(event.getLocation().toString());
        holder.time.setText(event.getTime());
        holder.imageView.setImageResource(event.getImageResource());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = goToEvent(event, holder.title.getContext());
                holder.title.getContext().startActivity(intent);
            }
        });
    }

    private Intent goToEvent(Event event, Context context){
        Intent intent= new Intent(context, EventDetailsActivity.class);
        intent.putExtra("event", event);
        return intent;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_info)
        TextView title;
        @BindView(R.id.background_image)
        ImageView imageView;
        @BindView(R.id.time_info)
        TextView time;
        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}