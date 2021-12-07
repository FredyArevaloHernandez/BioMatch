package com.example.biomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private MyDBSQLiteHelper admin;
    private SQLiteDatabase db;
    private ContentValues cv;
    private ListView lv;
    private Cursor filas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        admin = new MyDBSQLiteHelper(this, vars.nomDB, null, vars.version);
        lv = findViewById(R.id.lstView);
        ArrayList<String> listado = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        String nomTabla = extras.getString("nomtabla");

        db = admin.getReadableDatabase();

        if (nomTabla.equals("cliente")) {
            filas = db.rawQuery("SELECT * FROM CLIENTE", null);
            while (filas.moveToNext()) {
                listado.add(filas.getInt(0) + "-" + filas.getInt(1));
            }
            db.close();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listado);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}