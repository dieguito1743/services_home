/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dto;

import java.sql.Date;

/**
 *
 * @author dbermudez
 */
public class Usuarios_ServiciosDTO {

    private int idusuario_servicio = -1;
    private ServiciosDTO servicio = null;//int idservicio;
    private UsuariosDTO usuario = null;//int idusuario;
    private Date fechainicio = null;
    private Date fechaalta = null;
    private int estado = -1;

    public Usuarios_ServiciosDTO() {
    }

    public Usuarios_ServiciosDTO(int idusuario_servicio, ServiciosDTO servicio, UsuariosDTO usuario, Date fechainicio, Date fechaalta, int estado) {
        this.idusuario_servicio = idusuario_servicio;
        this.servicio = servicio;
        this.usuario = usuario;
        this.fechainicio = fechainicio;
        this.fechaalta = fechaalta;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public int getIdusuario_servicio() {
        return idusuario_servicio;
    }

    public void setIdusuario_servicio(int idusuario_servicio) {
        this.idusuario_servicio = idusuario_servicio;
    }

    public ServiciosDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServiciosDTO servicio) {
        this.servicio = servicio;
    }

    public UsuariosDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosDTO usuario) {
        this.usuario = usuario;
    }
}
