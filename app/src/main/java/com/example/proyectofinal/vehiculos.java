package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.DataVehiculo.Transacciones;
import com.example.proyectofinal.SQLiteConexion;

public class vehiculos extends AppCompatActivity {
    EditText marca, modelo, anio, tipoaceite;
    Button btnagregar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marca = (EditText) findViewById(R.id.marca);
        modelo = (EditText) findViewById(R.id.modelo);
        anio = (EditText) findViewById(R.id.anio);
        tipoaceite = (EditText) findViewById(R.id.tipoaceite);

        btnagregar = (Button) findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarVehiculo();
            }
        });

    }

    private void AgregarVehiculo()
    {
        try
        {
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null,1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("marca", marca.getText().toString());
            valores.put("modelo", modelo.getText().toString());
            valores.put("anio", anio.getText().toString());
            valores.put("tipoaceite", tipoaceite.getText().toString());

            Long Resultado = db.insert(Transacciones.tablaVehiculos, "id", valores);
            Toast.makeText(this, Resultado.toString(), Toast.LENGTH_SHORT).show();

            ClearScreen();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"No se pudo insertar el dato", Toast.LENGTH_LONG).show();
        }
    }

    private void ClearScreen()
    {
        marca.setText(Transacciones.Empty);
        modelo.setText(Transacciones.Empty);
        anio.setText(Transacciones.Empty);
        tipoaceite.setText(Transacciones.Empty);
    }

    private void MostrarVehiculo()
    {
        String mensaje = marca.getText().toString() +
                " | " + modelo.getText().toString() +
                " | " + anio.getText().toString() +
                " | " + tipoaceite.getText().toString();

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
