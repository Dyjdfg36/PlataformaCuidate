package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class interfazPrincipal2 extends AppCompatActivity {
    private TextView txtActividad1;
    private TextView txtActividad2;
    private TextView txtActividad3;
    private TextView txtActividad4;
    private TextView txtActividad5;
    private TextView txtActividad6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_principal2);

        txtActividad1=(TextView) findViewById(R.id.textView12);
        txtActividad1=(TextView) findViewById(R.id.textView13);
        txtActividad1=(TextView) findViewById(R.id.textView14);
        txtActividad1=(TextView) findViewById(R.id.textView15);
        txtActividad1=(TextView) findViewById(R.id.textView16);
        txtActividad1=(TextView) findViewById(R.id.textView17);

    }
}