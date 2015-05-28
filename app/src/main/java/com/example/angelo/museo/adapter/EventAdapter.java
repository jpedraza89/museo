package com.example.angelo.museo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.angelo.museo.R;
import com.example.angelo.museo.model.Event;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Antonio on 26/05/2015.
 */
public class EventAdapter extends BaseAdapter{

    Context context;
    ArrayList<Event>events;

    public EventAdapter(Context context,  ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder;

        if (convertView == null) {

            // get layout from mobile.xml
            convertView = inflater.inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();

            // set image based on selected text
            viewHolder.ivEvent = (ImageView)convertView.findViewById(R.id.grid_item_image);
            viewHolder.txtEvent = (TextView)convertView.findViewById(R.id.txt_name);

            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Event currentEvent = events.get(position);

        //Set image
        Picasso.with(context)
                .load(currentEvent.getUrlImg())
                .resize(180, 180)
                .centerCrop()
                .into(viewHolder.ivEvent);

        //Set name
        viewHolder.txtEvent.setText(currentEvent.getNombre());

        return convertView;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     * http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView ivEvent;
        TextView txtEvent;
    }
}
