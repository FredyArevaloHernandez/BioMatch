package com.example.biomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    private Button btnReg, btnList;

    private MyDBSQLiteHelper admin;
    private SQLiteDatabase db;
    private ContentValues cv;

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

        t9 = (TextView) findViewById(R.id.txtIdentificacion);
        t9.setHint("DocumentoIdentidad");
        t9.setTextSize(18);
        t9.setTextColor(R.color.purple_500);

        btnReg = (Button) findViewById(R.id.btnRegistrar);
        btnReg.setText(R.string.Agregar);

        btnList = (Button) findViewById(R.id.btnListar);
        btnList.setText(R.string.Listar);

        admin = new MyDBSQLiteHelper(this, vars.nomDB, null, vars.version);

    }

    public void agregarDatos(View view){
        String raz = t2.getText().toString();
        String ni = t3.getText().toString();
        String nom = t4.getText().toString();
        String ape = t5.getText().toString();
        String dir = t6.getText().toString();
        String tel = t7.getText().toString();
        String fecha = t8.getText().toString();
        String doc = t9.getText().toString();

        db = admin.getWritableDatabase();
        cv = new ContentValues();
        cv.put("razon", raz);
        cv.put("_NIT", ni);
        cv.put("nombres", nom);
        cv.put("apellidos", ape);
        cv.put("docu",doc);
        cv.put("direccion", dir);
        cv.put("telefono", tel);
        cv.put("direccion", dir);
        cv.put("telefono", tel);
        cv.put("fechaNac",fecha);

        long reg = db.insert("cliente", null, cv);

        if (reg == -1){
            Toast.makeText(this, "El registro no se pudo almacenar", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "El registro se almacenó exitosamente", Toast.LENGTH_SHORT).show();
            t2.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
        }
    }



    public void evaluar (View view){
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
            //Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
            agregarDatos(view);
        }
    }

    public void listarClientes(View view){
        db = admin.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM CLIENTE", null);
        filas.moveToFirst();
        while (filas.moveToNext()){
            Toast.makeText(this, filas.getInt(0) + "-" + filas.getString(1), Toast.LENGTH_SHORT).show();
        }
        db.close();
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("nomtabla", "cliente");
        startActivity(intent);
    }



}