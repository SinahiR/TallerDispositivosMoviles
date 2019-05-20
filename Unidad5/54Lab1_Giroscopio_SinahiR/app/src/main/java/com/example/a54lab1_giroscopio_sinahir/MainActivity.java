package com.example.a54lab1_giroscopio_sinahir;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor mysensor;
    private SensorManager senman;
    private TextView ejex, ejey, ejez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor=senman.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        ejex = (TextView) findViewById(R.id.ejex);
        ejey = (TextView) findViewById(R.id.ejey);
        ejez = (TextView) findViewById(R.id.ejez);

        //Event listener
        //Puede usar esta interfaz para crear dos métodos de
        // devolución de llamada que reciben notificaciones
        // (eventos del sensor) cuando cambian los valores del
        // sensor o cuando cambia la precisión del sensor.
        senman.registerListener((SensorEventListener) this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);

        //Sensor Manager
        //rear una instancia del servicio de sensor. Esta clase
        // proporciona varios métodos para acceder y listar sensores,
        // registrar y anular el registro de escuchas de eventos de
        // sensores y obtener información de orientación.


    }
    //Sensor event-->crear un objeto de evento de sensor,
    // que proporciona información sobre un evento de sensor.
    // Un objeto de evento de sensor incluye la siguiente
    // información: los datos sin procesar del sensor, el tipo
    // de sensor que generó el evento, la precisión de los datos
    // y la marca de tiempo del evento.
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        ejex.setText(""+sensorEvent.values[0]);
        ejey.setText(""+sensorEvent.values[1]);
        ejez.setText(""+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
