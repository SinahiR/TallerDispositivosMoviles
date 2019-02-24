package com.ejemplo.rcview2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    String[] nombres = {"ARANDA  JAZIEL",
            "CARDENAS EMANUEL",
            "CASTILLO  EMMANUEL",
            "CERVANTES MIGUEL",
            "CORDERO  YAZMIN",
            "CORDERO  ALBERTO",
            "ESPINOSA  YANETH",
            "FIGUEROA  RAMON",
            "GALLEGOS  JAVIER",
            "GIL  PEDRO",
            "GONZALEZ  ERNESTO",
            "GUTIERREZ  JESUS",
            "GUTIÉRREZ  BRYAN",
            "LOPEZ  MISSAEL",
            "MARTINEZ  LIZBETH",
            "MENDEZ  ALEJANDRO",
            "MONROY  DE JESUS",
            "PADILLA  EFRÉN",
            "PARRA SALVADOR",
            "PEREZ MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GUADALUPE",
            "REYES  GUADALUPE",
            "RICO  HENRY",
            "RIVERA  DAVID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas e imagenes
        adapter = new RecyclerAdapter(nombres, this);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);


    }
}

