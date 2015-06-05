package com.example.angelo.museo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MuseoActivity extends AppCompatActivity {

    private Intent defaultIntent;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_museo, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider mShareActionProvider = (ShareActionProvider)
                MenuItemCompat.getActionProvider(shareItem);
        mShareActionProvider.setShareIntent(getDefaultIntent());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView eventImg = (ImageView) findViewById(R.id.image_event);
        TextView textEvent = (TextView) findViewById(R.id.event_text);
        TextView textEventLugar = (TextView) findViewById(R.id.Lugar);
        TextView textEventDireccion = (TextView) findViewById(R.id.Direccion);
        TextView textEventFecha = (TextView) findViewById(R.id.Fecha);

        String UrlImgEvento = getIntent().getStringExtra("urlImg");
        String NombreEvento = getIntent().getStringExtra("nombre");
        String Lugar = getIntent().getStringExtra("lugar");
        String DireccionEvento = getIntent().getStringExtra("direccion");
        String FechaInicioEvento = getIntent().getStringExtra("fechaInicio");
        String FechaFinEvento = getIntent().getStringExtra("fechaFin");
        String LongitudEvento = getIntent().getStringExtra("longitud");
        String LatitudEvento = getIntent().getStringExtra("latitud");


        textEvent.setText(NombreEvento);
        textEventLugar.setText("\t"+Lugar+"\n\n\n");
        textEventDireccion.setText(DireccionEvento+"\n\n\n");
        textEventFecha.setText("\t"+FechaInicioEvento+"\t\t\t"+FechaFinEvento);

        Picasso.with(this)
                .load(UrlImgEvento)
                .fit()
                .into(eventImg);



    }

    public Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
            }
}