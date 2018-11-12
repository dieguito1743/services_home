/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dto;

/**
 *
 * @author dbermudez
 */
public class UsuariosDTO {

    private int idusuario = -1;
    private int tipousuario = -1;
    private String nombreusuario = "";
    private String apellidousuario = "";
    private String accusuario = "";
    private String passusuario = "";
    private String telefonousuario = "";
    private String correousuario = "";

    public UsuariosDTO() {
    }

    public UsuariosDTO(int idusuario, int tipousuario, String nombreusuario, String apellidousuario, String accusuario, String passusuario, String telefonousuario, String correousuario) {
        this.idusuario = idusuario;
        this.tipousuario = tipousuario;
        this.nombreusuario = nombreusuario;
        this.apellidousuario = apellidousuario;
        this.accusuario = accusuario;
        this.passusuario = passusuario;
        this.telefonousuario = telefonousuario;
        this.correousuario = correousuario;
    }

    public String getAccusuario() {
        return accusuario;
    }

    public void setAccusuario(String accusuario) {
        this.accusuario = accusuario;
    }

    public String getApellidousuario() {
        return apellidousuario;
    }

    public void setApellidousuario(String apellidousuario) {
        this.apellidousuario = apellidousuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPassusuario() {
        return passusuario;
    }

    public void setPassusuario(String passusuario) {
        this.passusuario = passusuario;
    }

    public String getTelefonousuario() {
        return telefonousuario;
    }

    public void setTelefonousuario(String telefonousuario) {
        this.telefonousuario = telefonousuario;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }
}
