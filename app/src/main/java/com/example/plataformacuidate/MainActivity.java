package com.example.plataformacuidate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.MediaRouteActionProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;


import android.app.Activity;
import android.view.Menu;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private EditText  user;
    private EditText pass;
    private TextView aux;
    private Button btnReg;
    private Button btn;
    public String x="Texto de prueba";
    RequestQueue requestQueue;

    private static final String URL1= "http://172.100.85.161/android/fetch.php";


    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue= Volley.newRequestQueue(this);

        user = (EditText) findViewById(R.id.editTextUser);
        pass = (EditText) findViewById(R.id.editTextPassword);
        aux = (TextView) findViewById(R.id.textView3);
        btn =(Button) findViewById(R.id.button);
        btnReg=(Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarSesion(user.getText().toString(),pass.getText().toString());
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });
    }

    public void ingresarSesion(String user_String,String pass_String) {
        /*String user_String=user.getText().toString();
        String pass_String=pass.getText().toString();*/
        String nombre="";
        StringRequest stringRequest =new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        Toast.makeText(MainActivity.this,"correcto",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError response){
                        Toast.makeText(MainActivity.this,"incorrecto",Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("user",user_String);
                params.put("name",pass_String);

                return super.getParams();
            }
        };
        Intent i =new Intent(MainActivity.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("dato01",user_String);
        i.putExtra("dato02",pass_String);
        startActivity(i);

    }
    public void registrar() {
        Intent i =new Intent(MainActivity.this, registrar_user.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);

    }
}