package com.example.angelo.museo;

/**
 * Created by Antonio on 20/05/2015.
 * <p/>
 * Este es el modelo de datos
 */
public class Event {

    //Atributos de la clase
    private String nombre;
    private String lugar;
    private String fechaInicio;
    private String urlImg;

    //Constructor
    public Event(String nombre, String lugar, String fechaInicio, String urlImg) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.urlImg = urlImg;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getUrlImg() {
        return urlImg;
    }
}
