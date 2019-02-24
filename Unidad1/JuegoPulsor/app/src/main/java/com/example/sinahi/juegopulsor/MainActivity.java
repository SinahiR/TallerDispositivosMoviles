package com.example.sinahi.juegopulsor;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button intentar, nr;
      final TextView nf;
        final CountDownTimer t;
        final double[] numero = new double[1];
        final double[] inicio = {1.0};

        intentar=findViewById(R.id.intento);
        nr=findViewById(R.id.nr);
        nf=findViewById(R.id.nf);


        t=new CountDownTimer(100000, 1000) {

            @Override
            public void onTick(long l) {

                    nr.setText(""+ inicio[0]);
                   inicio[0] = inicio[0] +.1;
               inicio[0] = Math.round(inicio[0] *10.0)/10.0;

               if(inicio[0]==3.1)
               {
                   inicio[0]=1.0;
               }
            }

            @Override
            public void onFinish() {

                nr.setText(""+ inicio[0]);


            }
        };


        intentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                numero[0] =(float) ((Math.random()*2)+1);
                numero[0] = Math.round(numero[0] *10.0)/10.0;
                nf.setText(""+ numero[0]); //necesitas un string mas el numero a imprimir
                t.start();
                inicio[0]=1.0;


            }
        });

        nr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.onFinish(); //para los numeros en el contador es decir se deja de hacer los acumulables
                t.cancel(); //Hace que paren de mostrarse los numeros


                if(inicio[0]==numero[0])
                {

                    Toast.makeText(MainActivity.this, "GANASTE", Toast.LENGTH_LONG ).show();
                }
else {
                    Toast.makeText(MainActivity.this, "INTENTALO OTRA VEZ.. Perdiste", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
