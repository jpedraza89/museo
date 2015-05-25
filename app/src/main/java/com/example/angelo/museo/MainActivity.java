package com.example.angelo.museo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.angelo.museo.ui.fragments.FirstFragment;
import com.example.angelo.museo.ui.fragments.ListFragment;
import com.example.angelo.museo.ui.fragments.SecondFragment;
import com.example.angelo.museo.ui.fragments.ThirdFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        getFragmentManager().beginTransaction()
                .add(R.id.list_fragment, ListFragment.getInstance(savedInstanceState))
        .commit();

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return FirstFragment.newInstance("FirstFragment, Instance 1");
                case 1:
                    return SecondFragment.newInstance("SecondFragment, Instance 1");
                case 2:
                    return ThirdFragment.newInstance("ThirdFragment, Instance 1");
                case 3:
                    return ThirdFragment.newInstance("ThirdFragment, Instance 2");
                case 4:
                    return ThirdFragment.newInstance("ThirdFragment, Instance 3");
                default:
                    return ThirdFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        StringRequest eventarioRequest = new StringRequest(Request.Method.GET,
                "http://eventario.mx/eventos.json",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray eventList = new JSONArray(response);
                            ArrayList<Event> eventArrayList = parseEvents(eventList);

                            for (int i = 0; i < eventArrayList.size(); i++) {
                                Log.d(LOG_TAG, eventArrayList.get(i).getNombre() + "\n" + eventArrayList.get(i).getLugar() + "\n" + eventArrayList.get(i).getFechaInicio());
                            }
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

        ((AppController) getApplicationContext())
                .addToRequestQueue(eventarioRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Event parseSecondEvent(JSONArray eventList) throws JSONException {
        JSONObject secondEvent = eventList.getJSONObject(1);

        String nombre = secondEvent.getString("nombre");
        String lugar = secondEvent.getString("lugar");
        String fecha = secondEvent.getString("hora_inicio");

        return new Event(nombre, lugar, fecha);
    }

    public ArrayList<Event> parseEvents(JSONArray eventList) throws JSONException {

        ArrayList<Event> arrayListEvent = new ArrayList<>();

        for (int i = 0; i < eventList.length(); i++) {
            JSONObject jsonEvents = eventList.getJSONObject(i);

            String nombre = jsonEvents.getString("nombre");
            String lugar = jsonEvents.getString("lugar");
            String fecha = jsonEvents.getString("hora_inicio");

            Event event = new Event(nombre, lugar, fecha);

            arrayListEvent.add(event);
        }

        return arrayListEvent;
    }
}
