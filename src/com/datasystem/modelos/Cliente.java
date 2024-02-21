package com.datasystem.modelos;

public class Cliente {

    private int id_cliente;
    private String nombre_cliente;
    private String email;
    private String telefono;
    private String direccion;
    private String ultima_modificacion;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre_cliente, String email, String telefono, String direccion, String ultima_modificacion) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ultima_modificacion = ultima_modificacion;
    }

      public Cliente(int id_cliente, String nombre_cliente, String email, String telefono, String ultima_modificacion) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.email = email;
        this.telefono = telefono;
        this.ultima_modificacion = ultima_modificacion;
    }
    public Cliente(String nombre_cliente, String mail, String telefono, String direccion, String ultima_modificacion) {
        this.nombre_cliente = nombre_cliente;
        this.email = mail;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ultima_modificacion = ultima_modificacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUltima_modificacion() {
        return ultima_modificacion;
    }

    public void setUltima_modificacion(String ultima_modificacion) {
        this.ultima_modificacion = ultima_modificacion;
    }

}
