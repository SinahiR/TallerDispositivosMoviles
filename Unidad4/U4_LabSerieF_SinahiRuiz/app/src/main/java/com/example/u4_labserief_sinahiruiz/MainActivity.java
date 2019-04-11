package com.example.u4_labserief_sinahiruiz;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num;
    TextView res;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num= findViewById(R.id.num);
        res = findViewById(R.id.res);
        boton = findViewById(R.id.boton);

      boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Ingresa un numero", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Las operaciones en segundo plano requieran comunicarse con el Hilo Principal.
                    AsyncTarea asyncTarea = new AsyncTarea();
                    asyncTarea.execute(Integer.parseInt(num.getText().toString()));
                }
            }
        });




    }

    private class  AsyncTarea extends AsyncTask<Integer, Integer,Boolean> {
       String resultado="0,1,";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        //Método abstracto que ejecuta las el Thread en segundo plano.

        @Override
        protected Boolean doInBackground(Integer... params) {
            int n1 = 0;
            int n2 = 1;
            int aux;
            int limite = params[0];
            int i=1;
            while ((i) <= limite-2) {

                aux = n1;
                n1 = n2;
                n2 = aux + n1;
                i++;
                resultado += n2+",";
            }

            return true;
        }


        //Es utilizado para actualizar la UI con el trabajo realizado en segundo plan
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);


        }

        //Maneja los resultados provenientes de la ejecución en segundo plano.
        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            res.setText(resultado);
        }

        //Es utilizado para manejar la cancelación del AsyncTask
        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(getApplicationContext(),"Tarea NO finaliza AsyncTask",Toast.LENGTH_SHORT).show();

        }

    }
}
