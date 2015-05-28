package com.example.angelo.museo.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.angelo.museo.AppController;
import com.example.angelo.museo.R;
import com.example.angelo.museo.UtilMethods;
import com.example.angelo.museo.adapter.EventAdapter;
import com.example.angelo.museo.model.Event;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


/**
 * Created by angelo on 14/05/15.
 */
public class ListFragment extends Fragment {

    GridView gridEvents;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.grid_layout, container, false);

        gridEvents = (GridView) v.findViewById(R.id.grid_view);

        gridEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }});

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        StringRequest eventarioRequest = new StringRequest(Request.Method.GET,
                "http://eventario.mx/eventos.json",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray eventList = new JSONArray(response);
                            ArrayList<Event> eventArrayList = UtilMethods.parseEvents(eventList);

                            //Todo automatize adding events to adapter
                            EventAdapter adapter = new EventAdapter(getActivity(), eventArrayList);
                            gridEvents.setAdapter(adapter);

                            //Create the adapter
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        });

        ((AppController) getActivity().getApplicationContext())
                .addToRequestQueue(eventarioRequest);
    }

    public static ListFragment getInstance(Bundle bundle) {
        ListFragment listFragment = new ListFragment();

        listFragment.setArguments(bundle);

        return listFragment;
    }


}
