package com.ejemplo.rcview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>
{
    private  View.OnClickListener listener;


    //Contex es la interfaz global de información , Es una clase abstracta
    // Permite acceder a los recursos específicos de la aplicación y a sus clases,
    // así como llamar al padre para realizar operaciones a nivel de la aplicación, como lanzar Activities,
    // difundir mensajes por el sistema, recibir Intents, etc.

    private Context mostrar;
    private String[] nombres;
    ImageView iperfil;
    ImageView basura;



    //Contructor para inicializar valores y para el paso de parametros
    public RecyclerAdapter(String[] nombres, Context mostrar) {
        this.nombres = nombres;
        this.mostrar=mostrar;
    }

    @Override

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;

    }


    @Override
    // El onBindViewHolder Llena los datos que quiere mostrar
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        //Asignas el campo nombre con su respectivo nombre y  la posicion
        holder.campo_nombre.setText(nombres[position]);


          //Eventos OnClick
        holder.iperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(mostrar, "Se actualizo:" + nombres[position], Toast.LENGTH_LONG).show();
            }
        });

        holder.basura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mostrar, "Se borro:" + nombres[position], Toast.LENGTH_LONG).show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return nombres.length;
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
         //Declaracion de variables en el recycler
        TextView campo_nombre;
        ImageView iperfil;
        ImageView basura;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            campo_nombre = itemView.findViewById(R.id.alumno_id);
            iperfil=itemView.findViewById(R.id.iperfil);
            basura=itemView.findViewById(R.id.basura);




        }

    }




}
