package com.example.shoppingcart2;

public class Productos {

    private int id_producto;
    private String nombre_producto;
    private String proveedor;
    private float precio_por_unidad;
    private int cantidad_de_unidades;
    private String url_imagen;

    public Productos(){

    }

    public Productos(int id_producto, String nombre_producto, String proveedor, float precio_por_unidad, int cantidad_de_unidades, String url_imagen) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.proveedor = proveedor;
        this.precio_por_unidad = precio_por_unidad;
        this.cantidad_de_unidades = cantidad_de_unidades;
        this.url_imagen = url_imagen;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public float getPrecio_por_unidad() {
        return precio_por_unidad;
    }

    public void setPrecio_por_unidad(float precio_por_unidad) {
        this.precio_por_unidad = precio_por_unidad;
    }

    public int getCantidad_de_unidades() {
        return cantidad_de_unidades;
    }

    public void setCantidad_de_unidades(int cantidad_de_unidades) {
        this.cantidad_de_unidades = cantidad_de_unidades;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
