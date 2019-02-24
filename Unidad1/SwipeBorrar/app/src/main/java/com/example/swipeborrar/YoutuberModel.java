package com.example.swipeborrar;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class YoutuberModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String control;
    private String carrera;
    int basura;

    public YoutuberModel(String nombre, String control, String carrera, int basura) {
        this.nombre = nombre;
        this.control = control;
        this.carrera=carrera;
        this.basura=basura;
    }

    public int getBasura() {
        return basura;
    }

    public void setBasura(int basura) {
        this.basura = basura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
