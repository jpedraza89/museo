package com.example.angelo.museo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MuseoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);
        ImageView eventImg = (ImageView) findViewById(R.id.image_event);
        TextView textEvent = (TextView) findViewById(R.id.event_text);
        TextView textEventDetail = (TextView) findViewById(R.id.event_text_details);

        String UrlImgEvento = getIntent().getStringExtra("urlImg");
        String NombreEvento = getIntent().getStringExtra("nombre");
        String Lugar = getIntent().getStringExtra("lugar");
        String DireccionEvento = getIntent().getStringExtra("direccion");
        String FechaInicioEvento = getIntent().getStringExtra("fechaInicio");
        String FechaFinEvento = getIntent().getStringExtra("fechaFin");
        String LongitudEvento = getIntent().getStringExtra("longitud");
        String LatitudEvento = getIntent().getStringExtra("latitud");
        String newString;

        textEvent.setText(NombreEvento);
        textEventDetail.setText("Lugar : "+Lugar+"\n\n\n"
                +"Direccion : "+DireccionEvento+"\n\n\n"
                +"Desde : " +FechaInicioEvento +"\t\t\t\tHasta : " +FechaFinEvento);

        Picasso.with(this)
                .load(UrlImgEvento)
                .fit()
                .into(eventImg);
    }
}