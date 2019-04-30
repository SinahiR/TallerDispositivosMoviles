package com.example.a43relojcanvas_sinahiruiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RelojS(this));
    }

    public class RelojS extends View {
        private  final long TIEMPO= 20;
        private Paint cfondo;
        private Paint manesilla;

        public RelojS(Context context) {
            super(context);
        init(context, null);
        }

        public RelojS(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context, attrs);
        }

        public RelojS(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context, attrs);
        }

        //Se crean objetos como el fondo del reloj y la manesilla
        private void init(Context context, AttributeSet attrs) {
            cfondo= new Paint();
            cfondo.setColor(Color.parseColor("#A9D0F5"));
            cfondo.setAntiAlias(true);


            manesilla = new Paint();
            manesilla.setColor(Color.BLACK);
            manesilla.setAntiAlias(true);
        }


        //Se determita el largo y el alto del fondo
        //Como vamos a manejar la medida de la vista,
        protected  void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int largo = MeasureSpec.getSize(widthMeasureSpec);
            int alto = MeasureSpec.getSize(heightMeasureSpec);
            int measuredSize = Math.min(largo, alto);
            setMeasuredDimension(measuredSize, measuredSize);
        }

        //Tarea en segundo plano
        private Runnable invalidator = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };


        //Plasma el fondo las manecillas de las horas, min, segundos y mas
        protected void onDraw(Canvas canvas) {
            dibFondo(canvas);
            dibManeH(canvas);
            dibManeMin(canvas);
            dibManeSeg(canvas);
            dibujarUna(canvas);
            postDelayed(invalidator, TIEMPO);
        }

        //Dibuja manesilla de horas
        private void dibManeH(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.2f;
            float espesor = getWidth() * 0.01f;
            manesilla.setStrokeWidth(espesor);
            double angulo = getAnguloHora();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, manesilla);
        }

        //Dibuja el circulo del reloj

        private void dibFondo(Canvas canvas) {
            float circuloFondo = getHeight() / 2f;
            canvas.drawCircle(circuloFondo, circuloFondo, circuloFondo, cfondo);
        }

        //Dibuja manesilla de minutos
        private void dibManeMin(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.3f;
            float espesor = getWidth() * 0.01f;
           manesilla.setStrokeWidth(espesor);
            double angulo = getAnguloMinutos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, manesilla);
        }

        //Dibuja manesilla de segundos

        private void dibManeSeg(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.4f;
            float espesor = getWidth() * 0.005f;
            manesilla.setStrokeWidth(espesor);
            double angulo = getAnguloSegundos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, manesilla);
        }
        private float getX(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio + manoRadio * Math.sin(angulo));
        }
        private float getY(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio - manoRadio * Math.cos(angulo));
        }

        //Dibuja el circulo del reloj
        private void dibujarUna(Canvas canvas) {
            float vistaRadio = getHeight() / 2f;
            float unaRadio = getHeight() * 0.02f;
            canvas.drawCircle(vistaRadio, vistaRadio, unaRadio, manesilla);
        }

        //Obtiene el angulo de la  hora
        private double getAnguloHora() {
            Calendar c = Calendar.getInstance();
            int horas = c.get(Calendar.HOUR);
            int minutos = c.get(Calendar.MINUTE);

            int minutosInicio = horas * 60 + minutos;
            return (2 * Math.PI * minutosInicio) / 720; //Minutos en 12 horas
        }

        //Obtiene el angulo de los minutos
        private double getAnguloMinutos() {
            Calendar c = Calendar.getInstance();
            int segundosDesdeElInicio = c.get(Calendar.MINUTE) * 60  + c.get(Calendar.SECOND);
            return (2 * Math.PI * segundosDesdeElInicio) / 3600; // Divide los segundos en una hora
        }

        //Obtiene el angulo de los segundos
        private double getAnguloSegundos() {
            Calendar c = Calendar.getInstance();
            int millisFromStart = c.get(Calendar.SECOND) * 1000 + c.get(Calendar.MILLISECOND);
            return (2 * Math.PI * millisFromStart) / 60000; // Milisegundos en 1 mnuto
        }
    }


}
