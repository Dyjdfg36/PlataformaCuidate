package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interfazPrincipal extends AppCompatActivity {
    private Button agregarAct;
    private Button Actividad1;
    private Button Actividad2;
    private Button Actividad3;
    private Button abrirPrincipal;
    private Button abrirActividades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_principal);

        agregarAct=(Button) findViewById(R.id.btn_agregarActividad);
        Actividad1=(Button) findViewById(R.id.btn_Actividad1);
        Actividad2=(Button) findViewById(R.id.btn_Actividad2);
        Actividad3=(Button) findViewById(R.id.btn_Actividad3);
        abrirPrincipal=(Button) findViewById(R.id.btn_abrirPrincipal);
        abrirActividades=(Button) findViewById(R.id.btn_abrirActividades);

        agregarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarAct();
            }
        });

        Actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActividad1();
            }
        });

        Actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActividad2();
            }
        });

        Actividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActividad3();
            }
        });

        abrirPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verVistaGeneral();
            }
        });

        abrirActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verActividades();
            }
        });
    }

    private void agregarAct(){
        Intent i =new Intent(interfazPrincipal.this, agregar_actividad.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    private void abrirActividad1(){
        Intent i =new Intent(interfazPrincipal.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    private void abrirActividad2(){
        Intent i =new Intent(interfazPrincipal.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    private void abrirActividad3(){
        Intent i =new Intent(interfazPrincipal.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
    private void verVistaGeneral() {
        Intent i = new Intent(interfazPrincipal.this, interfazPrincipal2.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

    private void verActividades() {
        Intent i = new Intent(interfazPrincipal.this, interfazPrincipal2.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }


}