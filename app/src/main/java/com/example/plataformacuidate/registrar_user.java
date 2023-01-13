package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registrar_user extends AppCompatActivity {
    private EditText  user;
    //private EditText pass;
    private EditText nombre;
    private EditText apellidop;
    private EditText apellidom;
    private EditText telefono;
    private EditText pass1;
    private EditText pass2;
    private EditText email;
    private Button btn;
    RequestQueue requestQueue;
    //private static final String URL1= "http://172.100.85.161/android/save.php";
    private static final String URL1= "http://192.168.0.101/android/save.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_user);

        requestQueue= Volley.newRequestQueue(this);

        nombre= (EditText) findViewById(R.id.editTextNombre);
        apellidop= (EditText) findViewById(R.id.editTextApellidoP);
        apellidom= (EditText) findViewById(R.id.editTextApellidoM);
        telefono= (EditText) findViewById(R.id.editTextTelefono);
        email=(EditText) findViewById(R.id.editTextEmail);
        user=(EditText) findViewById(R.id.editTextUser2);
        pass1=(EditText) findViewById(R.id.editTextPass);
        pass2=(EditText) findViewById(R.id.editTextPass2);
        btn =(Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarSesion(
                    nombre.getText().toString(),
                    apellidop.getText().toString(),
                    apellidom.getText().toString(),
                    telefono.getText().toString(),
                    user.getText().toString(),
                    pass1.getText().toString(),
                    email.getText().toString()
                );
            }
        });
    }

    //public void ingresarSesion(final String nombre,final String apellidop,final String apellidom_String,final String telefono_String,final String user_String,final String pass_String,final String email_String) {
    public void ingresarSesion(final String nombre,final String apellido_p,final String apellido_m,final String telefono,final String user,final String pass,final String email) {

        StringRequest stringRequest =new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        Toast.makeText(registrar_user.this,"correcto",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError response){
                        Toast.makeText(registrar_user.this,"incorrecto",Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("usuario",user);
                params.put("password",pass);
                params.put("nombre",nombre);
                params.put("apellidop",apellido_p);
                params.put("apellidom",apellido_m);
                params.put("telefono",telefono);
                params.put("email",email);
                return params;
            }
        };
        requestQueue.add(stringRequest);
        Intent i =new Intent(registrar_user.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("dato01",user);
        i.putExtra("dato02",pass);
        startActivity(i);

    }
}