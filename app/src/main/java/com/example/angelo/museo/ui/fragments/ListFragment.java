package com.example.angelo.museo.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        return v;
    }

    public static ListFragment getInstance(Bundle bundle) {
        ListFragment listFragment = new ListFragment();

        listFragment.setArguments(bundle);

        return listFragment;
    }


}
