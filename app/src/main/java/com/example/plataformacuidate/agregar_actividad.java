package com.example.plataformacuidate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class agregar_actividad extends AppCompatActivity {
    private EditText nombreNewActividad;
    private EditText numHorasAct;
    private Button btnAgregarAct;
    RequestQueue requestQueue;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;
    private RadioButton radio6;
    private String icono;


    private static final String URL1= "http://192.168.0.101/android/save2.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);
        requestQueue= Volley.newRequestQueue(this);

        nombreNewActividad=(EditText) findViewById(R.id.editTextNombreAct);
        numHorasAct=(EditText) findViewById(R.id.editTextHoras);
        btnAgregarAct=(Button) findViewById(R.id.btnAgregarAct1);
        radio1=(RadioButton)findViewById(R.id.rd1);
        radio2=(RadioButton)findViewById(R.id.rd2);
        radio3=(RadioButton)findViewById(R.id.rd3);
        radio4=(RadioButton)findViewById(R.id.rd4);

        btnAgregarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar_act(nombreNewActividad.getText().toString(),numHorasAct.getText().toString(),icono);
            }
        });
    }
    public void checar(View view){
        if(radio1.isChecked()==true){
            //Toast.makeText(agregar_actividad.this,"entro1",Toast.LENGTH_SHORT).show();
            icono="1";
        }
        else if(radio2.isChecked()==true){
            //Toast.makeText(agregar_actividad.this,"entro",Toast.LENGTH_SHORT).show();
            icono="2";
        }
        else if(radio3.isChecked()==true){
            //Toast.makeText(agregar_actividad.this,"entro1",Toast.LENGTH_SHORT).show();
            icono="3";
        }
        else if(radio4.isChecked()==true){
            //Toast.makeText(agregar_actividad.this,"entro1",Toast.LENGTH_SHORT).show();
            icono="4";
        }
        else{
            //Toast.makeText(agregar_actividad.this,"entro1",Toast.LENGTH_SHORT).show();
            icono="4";
        }
    }
    public void agregar_act(String nombreNA,String numHA,String icono){
        StringRequest stringRequest =new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        Toast.makeText(agregar_actividad.this,"correcto",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError response){
                        Toast.makeText(agregar_actividad.this,"incorrecto",Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("nombre_actividad",nombreNA);
                params.put("horas_realizadas",numHA);
                params.put("icono",icono);
                return params;
            }
        };
        requestQueue.add(stringRequest);
        Intent i =new Intent(agregar_actividad.this, interfazPrincipal.class);
        //Intent i =new Intent(MainActivity.this, MainActivity2.class);
        //i.putExtra("dato01",user);
        //i.putExtra("dato02",pass);
        startActivity(i);
    }
}