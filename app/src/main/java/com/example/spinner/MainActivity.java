package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private EditText n1, n2;
    private TextView tv1;
  


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText)findViewById(R.id.txtvalor1);
        n2 = (EditText)findViewById(R.id.txtvalor2);
        tv1 = (TextView)findViewById(R.id.txtresultado);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        String[] opciones = {"sumar","restar","multiplicar","dividir"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

    }
    //metodo del boton
    public void calcular(View view){
        String valor1_String = n1.getText().toString();
        String valor2_String = n2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("sumar")){
            int sumar = valor1_int + valor2_int;
            String resultado = String.valueOf(sumar);
            tv1.setText(resultado);
        } else if (seleccion.equals("restar")){
            int restar = valor1_int - valor2_int;
            String resultado = String.valueOf(restar);
            tv1.setText(resultado);
        } else if (seleccion.equals("multiplicar")){
            int multiplicar = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);
        } else if (seleccion.equals("dividir")){
            if(valor2_int != 0){
                int dividir = valor1_int / valor2_int;
                String resultado = String.valueOf(dividir);
                tv1.setText(resultado);
            } else {
                Toast.makeText( this, "no se puede divisir entre 0", Toast.LENGTH_LONG).show();
            }
        }
    }
}