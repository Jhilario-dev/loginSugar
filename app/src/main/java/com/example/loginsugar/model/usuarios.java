package com.example.loginsugar.model;

import com.orm.SugarRecord;

public class usuarios extends SugarRecord {

    String codigo;
    String Usuario;
    String Password;
    String direccion;
    String numeroTel;
    boolean singIn;

    public usuarios() {
    }

    public usuarios(String codigo, String usuario, String password, String direccion, String numeroTel, boolean singIn) {
        this.codigo = codigo;
        this.Usuario = usuario;
        this.Password = password;
        this.direccion = direccion;
        this.numeroTel = numeroTel;
        this.singIn = singIn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public boolean isSingIn() {
        return singIn;
    }

    public void setSingIn(boolean singIn) {
        this.singIn = singIn;
    }
}
