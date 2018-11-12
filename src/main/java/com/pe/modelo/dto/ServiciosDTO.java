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
public class ServiciosDTO {

    private int idservicio = -1;
    private String nombreservicio = "";
    private Date fecharegistroservicio = null;
    private Date fechaaltaservicio = null;
    private int estadoservicio = -1;
    private String descripcion = "";

    public ServiciosDTO() {
    }

    public ServiciosDTO(int idservicio, String nombreservicio, Date fecharegistroservicio, Date fechaaltaservicio, int estadoservicio, String descripcion) {
        this.idservicio = idservicio;
        this.nombreservicio = nombreservicio;
        this.fecharegistroservicio = fecharegistroservicio;
        this.fechaaltaservicio = fechaaltaservicio;
        this.estadoservicio = estadoservicio;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstadoservicio() {
        return estadoservicio;
    }

    public void setEstadoservicio(int estadoservicio) {
        this.estadoservicio = estadoservicio;
    }

    public Date getFechaaltaservicio() {
        return fechaaltaservicio;
    }

    public void setFechaaltaservicio(Date fechaaltaservicio) {
        this.fechaaltaservicio = fechaaltaservicio;
    }

    public Date getFecharegistroservicio() {
        return fecharegistroservicio;
    }

    public void setFecharegistroservicio(Date fecharegistroservicio) {
        this.fecharegistroservicio = fecharegistroservicio;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }
}
