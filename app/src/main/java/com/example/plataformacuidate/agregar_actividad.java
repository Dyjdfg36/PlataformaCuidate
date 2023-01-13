package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class agregar_actividad extends AppCompatActivity {
    private EditText nombreNewActividad;
    private EditText numHorasAct;
    private Button btnAgregarAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        nombreNewActividad=(EditText) findViewById(R.id.editTextNombreAct);
        numHorasAct=(EditText) findViewById(R.id.editTextHoras);
        btnAgregarAct=(Button) findViewById(R.id.btnAgregarAct1);

        btnAgregarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar_act(nombreNewActividad.getText().toString(),numHorasAct.getText().toString());
            }
        });
    }

    public void agregar_act(String nombreNA,String numHA){

    }
}