package com.example.angelo.museo.model;

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
    private String fechaFin;
    private String urlImg;
    private String latitud;
    private String longitud;
    private String direccion;

    //Constructor
    public Event(String nombre, String lugar, String fechaInicio, String urlImg, String latitud, String longitud, String direccion, String fechaFin) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlImg = urlImg;
        this.longitud = longitud;
        this.latitud = latitud;
        this.direccion = direccion;
    }

    public String getNombre() {return nombre;}

    public String getUrlImg() {return urlImg;}

    public String getLugar() {return lugar;}

    public String getFechaInicio() {return fechaInicio;}

    public String getFechaFin() {return fechaFin;}

    public String getLongitud() {return longitud;}

    public String getLatitud() {return latitud;}

    public String getDireccion() {return direccion;}
}
