package com.example.angelo.museo.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.angelo.museo.R;


/**
 * Created by angelo on 14/05/15.
 */
public class ListFragment extends Fragment {

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_frag, container, false);

        GridView gridview = (GridView) v.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }});

        return v;
    }

    public static ListFragment getInstance(Bundle bundle) {
        ListFragment listFragment = new ListFragment();

        listFragment.setArguments(bundle);

        return listFragment;
    }


}
