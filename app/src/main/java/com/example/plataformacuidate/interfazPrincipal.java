package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class interfazPrincipal extends AppCompatActivity {
    private Button agregarAct;
    private Button Actividad1;
    private Button Actividad2;
    private Button Actividad3;
    private Button abrirPrincipal;
    private Button abrirActividades;
    private TextView txtBienvenida;

    private TextView  txtNombre,txtPaterno,txtMaterno,txtTelefono,txtEmail;
    String d1,d2;


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
        txtBienvenida=(TextView) findViewById(R.id.textView4);

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

    public void recibirDatos(){
        Bundle extras=getIntent().getExtras();
        d1= extras.getString("dato01");
        d2= extras.getString("dato02");

        //txtBienvenida = (TextView) findViewById(R.id.textView2);
        txtBienvenida.setText("Bienvenido\n"+d1);

    }

    private void readUser(){
        //String URL = "http://192.168.90.95/appcuidate/fetch.php?usuario=" + d1 +"password="+ d2;
        String URL = "http://192.168.0.131/android/fetch.php?usuario="+d1+"&password="+d2;
        //String URL = "https://jsonplaceholder.typicode.com/posts/1";
        //String URL = "http://my-json-feed";
        //String cadenaJson = "{'nombre':Maggie,'Edad':3}";
       /*/JSONObject objJSON=new JSONObject();
       try {
           objJSON.put("name", "Víctor");
           objJSON.put("age", 42);
           System.out.println(objJSON.toString());
           //txtNombre = (TextView) findViewById(R.id.txtNombre);
           //txtNombre.setText(objJSON.getString("name"));
       } catch (JSONException e) {
           e.printStackTrace();
       }*/

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String nombre,paterno,materno,telefono,email;
                        Toast.makeText(interfazPrincipal.this,"RESPONSE RECEIVED",Toast.LENGTH_SHORT).show();

                        try {
                            //txtNombre = (TextView) findViewById(R.id.txtNombre);
                            nombre=response.getString("nombre");
                            txtNombre.setText(nombre);
                            paterno=response.getString("apellido_p");
                            txtPaterno.setText(paterno);
                            materno=response.getString("apellido_m");
                            txtMaterno.setText(materno);
                            telefono=response.getString("telefono");
                            txtTelefono.setText(telefono);
                            email=response.getString("email");
                            txtEmail.setText(email);

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(interfazPrincipal.this,"errorcito",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }


}