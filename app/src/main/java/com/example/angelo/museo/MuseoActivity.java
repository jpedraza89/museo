package com.example.angelo.museo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.angelo.museo.ui.fragments.FirstFragment;
import com.example.angelo.museo.ui.fragments.SecondFragment;
import com.example.angelo.museo.ui.fragments.ThirdFragment;

public class MuseoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);
    }

}
