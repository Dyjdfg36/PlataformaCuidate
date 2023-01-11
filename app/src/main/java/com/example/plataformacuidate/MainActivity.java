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
    private Button btn;
    public String x="Texto de prueba";
    //private clsConexion con=new clsConexion();
    //varGlobales va=varGlobales.getInstance();
    RequestQueue requestQueue;

    private static final String URL1= "http://172.100.85.161/android/fetch.php";


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue= Volley.newRequestQueue(this);

        user = (EditText) findViewById(R.id.editTextUser);
        pass = (EditText) findViewById(R.id.editTextPassword);
        aux = (TextView) findViewById(R.id.textView3);
        btn =(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarSesion(user.getText().toString(),pass.getText().toString());
            }
        });
    }

    public void ingresarSesion(String user_String,String pass_String) {
        /*String user_String=user.getText().toString();
        String pass_String=pass.getText().toString();*/
        String nombre="";
        //try{
            /*Class.forName("org.postgresql.Driver");
            // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
            // Si estás utilizando el emulador de android y tenes el PostgreSQL en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
            //Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.90.95:5432/appCuidate", "test", "test");
            Connection conn=DriverManager.getConnection("jdbc:postgresql://192.168.90.95:5432/appCuidate","postgres","20151130");
            String stsql = "SELECT nombre FROM usuarios";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(stsql);
            while (rs.next()) {
                nombre = rs.getString(1);
                System.out.println("Employee number = " + nombre);
            }

            rs.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("oops! No se puede conectar. Error: " + se.toString());
        } catch (ClassNotFoundException e) {
        System.out.println("oops! No se encuentra la clase. Error: " + e.getMessage());
        }*/
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
}