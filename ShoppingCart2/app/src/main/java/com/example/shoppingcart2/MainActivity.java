package com.example.shoppingcart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView lvProductos;
    private ArrayAdapter<String> arrayAdapter;
    ObtenerData obtenerProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProductos = findViewById(R.id.lv_productos);


        obtenerProductos.getProductosById("1", new ObtenerData.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, "Algo salió mal " + message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Productos> productos) {
                arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,productos);
                lvProductos.setAdapter(arrayAdapter);
            }
        });

    }
}