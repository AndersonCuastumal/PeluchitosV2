package com.lenovoexample.peluchitosv2;

public class Contacto {
    private int id;
    private String nombre, cantidad, precio;

    public Contacto(int id, String nombre, String cantidad, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {return cantidad;}

    public void setCantidad(String cantidad) {this.cantidad = cantidad;}

    public String getPrecio() {return precio;}

    public void setPrecio(String correo) {this.precio = correo;}
}