package com.example.angelo.museo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MuseoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Nombre");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }


    }

}