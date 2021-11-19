package com.example.biomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8;
    Button btnReg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        t1 = (TextView) findViewById(R.id.txtTitulo);
        t1.setText("REGISTRO DE CLIENTES");
        t1.setTextSize(24);
        t1.setTextColor(R.color.purple_200);

        t2 = (TextView) findViewById(R.id.txtRazonSocial);
        t2.setHint("Razón Social");
        t2.setTextSize(18);
        t2.setTextColor(R.color.purple_500);

        t3 = (TextView) findViewById(R.id.txtxNIT);
        t3.setHint("NIT");
        t3.setTextSize(18);
        t3.setTextColor(R.color.purple_500);

        t4 = (TextView) findViewById(R.id.txtNombres);
        t4.setHint("Nombre");
        t4.setTextSize(18);
        t4.setTextColor(R.color.purple_500);

        t5 = (TextView) findViewById(R.id.txtApellidos);
        t5.setHint("Apellido");
        t5.setTextSize(18);
        t5.setTextColor(R.color.purple_500);

        t6 = (TextView) findViewById(R.id.txtDireccion);
        t6.setHint("Dirección");
        t6.setTextSize(18);
        t6.setTextColor(R.color.purple_500);

        t7 = (TextView) findViewById(R.id.txtTelefono);
        t7.setHint("Teléfono");
        t7.setTextSize(18);
        t7.setTextColor(R.color.purple_500);

        t8 = (TextView) findViewById(R.id.txtFechaNac);
        t8.setHint("Fecha de Nacimiento");
        t8.setTextSize(18);
        t8.setTextColor(R.color.purple_500);

        btnReg = (Button) findViewById(R.id.btnRegistrar);
        btnReg.setText("AGREGAR");


    }

    private boolean onClickValidar (){
        Boolean salida = Boolean.FALSE;


        return salida;
    }
}