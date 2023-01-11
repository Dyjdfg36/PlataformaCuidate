package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.jar.JarException;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtBienvenida;
    varGlobales va=varGlobales.getInstance();

    private TextView  txtNombre,txtPaterno,txtMaterno,txtTelefono,txtEmail;
    String d1,d2;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        requestQueue= Volley.newRequestQueue(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtBienvenida = (TextView) findViewById(R.id.textView2);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtPaterno = (TextView) findViewById(R.id.txtPaterno);
        txtMaterno = (TextView) findViewById(R.id.txtMaterno);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        recibirDatos();
        readUser();


    }

    public void recibirDatos(){
        Bundle extras=getIntent().getExtras();
        d1= extras.getString("dato01");
        d2= extras.getString("dato02");

        //txtBienvenida = (TextView) findViewById(R.id.textView2);
        txtBienvenida.setText("Bienvenido");

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
                        Toast.makeText(MainActivity2.this,"RESPONSE RECEIVED",Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(MainActivity2.this,"errorcito",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }


}

