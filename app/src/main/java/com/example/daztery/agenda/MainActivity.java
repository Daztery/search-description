package com.example.daztery.agenda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre,txtDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);



    }

    public void Guardar(View view){
        String nombre=txtNombre.getText().toString();
        String datos=txtDescripcion.getText().toString();

        SharedPreferences preferences= getSharedPreferences("agenda",Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor=preferences.edit();
        objEditor.putString(nombre,datos);
        objEditor.commit();

        Toast.makeText(this,"El contacto ha sido guardado",Toast.LENGTH_LONG).show();

    }
    public void Buscar(View view){
        String nombre=txtNombre.getText().toString();

        SharedPreferences preferences= getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos=preferences.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this,"No se encontró el registro",Toast.LENGTH_LONG).show();
        }
        else{
            txtDescripcion.setText(datos);
        }


    }

}
