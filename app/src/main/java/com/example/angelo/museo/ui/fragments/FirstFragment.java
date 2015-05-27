package com.example.angelo.museo.ui.fragments;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> api
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.angelo.museo.MuseoActivity;
=======
import android.widget.TextView;

>>>>>>> api
import com.example.angelo.museo.R;


public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
        tv.setText(getArguments().getString("msg"));

        RelativeLayout rl = (RelativeLayout)v.findViewById(R.id.container);


        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity = new Intent(getActivity(), MuseoActivity.class);
                startActivity(secondactivity);
            }
        });

        return v;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}