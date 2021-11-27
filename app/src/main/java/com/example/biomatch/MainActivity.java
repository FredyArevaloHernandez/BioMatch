package com.example.biomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8;
    Button btnReg;
    Boolean Evaluar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.txtTitulo);
        t1.setText(R.string.RegistroDeClientes);
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
        t4.setHint(R.string.Nombre);
        t4.setTextSize(18);
        t4.setTextColor(R.color.purple_500);

        t5 = (TextView) findViewById(R.id.txtApellidos);
        t5.setHint(R.string.Apellido);
        t5.setTextSize(18);
        t5.setTextColor(R.color.purple_500);

        t6 = (TextView) findViewById(R.id.txtDireccion);
        t6.setHint(R.string.Direccion);
        t6.setTextSize(18);
        t6.setTextColor(R.color.purple_500);

        t7 = (TextView) findViewById(R.id.txtTelefono);
        t7.setHint(R.string.Telefono);
        t7.setTextSize(18);
        t7.setTextColor(R.color.purple_500);

        t8 = (TextView) findViewById(R.id.txtFechaNac);
        t8.setHint(R.string.FechadeNacimiento);
        t8.setTextSize(18);
        t8.setTextColor(R.color.purple_500);

        btnReg = (Button) findViewById(R.id.btnRegistrar);
        btnReg.setText(R.string.Agregar);

    }

    private void evaluar (View view){
        Boolean salida = Boolean.TRUE;

        if (t2.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar la Razón Social", Toast.LENGTH_LONG).show();
        }else if (t3.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar el número del NIT", Toast.LENGTH_LONG).show();
        }else if (t4.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar el nombre del contacto", Toast.LENGTH_LONG).show();
        }else if (t5.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar el apellido del contacto", Toast.LENGTH_LONG).show();
        }else if (t6.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar la dirección", Toast.LENGTH_LONG).show();
        }else if (t7.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar el número de teléfono", Toast.LENGTH_LONG).show();
        }else if (t8.length()==0){
            salida=Boolean.FALSE;
            Toast.makeText(this, "Debe ingresar la fecha de nacimiento", Toast.LENGTH_LONG).show();
        }

        if (salida==Boolean.TRUE){
            Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Datos incompletos", Toast.LENGTH_LONG).show();
        }
    }

}