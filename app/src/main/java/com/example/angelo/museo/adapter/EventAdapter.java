package com.example.angelo.museo.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.angelo.museo.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonio on 26/05/2015.
 */
public class EventAdapter extends ArrayAdapter<Event>{

    ArrayList<Event>events;

    public EventAdapter(Context context,  ArrayList<Event> events) {
        super(context, 0, events);
        this.events = events;
    }


}
