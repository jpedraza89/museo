package com.example.angelo.museo;

import com.example.angelo.museo.model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Antonio on 27/05/2015.
 */
public class UtilMethods {

    public static ArrayList<Event> parseEvents(JSONArray eventList) throws JSONException {

        ArrayList<Event> arrayListEvent = new ArrayList<>();

        for (int i = 0; i < eventList.length(); i++) {
            JSONObject jsonEvents = eventList.getJSONObject(i);

            String nombre = jsonEvents.getString("nombre");
            String lugar = jsonEvents.getString("lugar");
            String fecha = jsonEvents.getString("hora_inicio");
            String urlImg = jsonEvents.getString("imagen");

            Event event = new Event(nombre, lugar, fecha, urlImg);

            arrayListEvent.add(event);
        }

        return arrayListEvent;
    }
}
