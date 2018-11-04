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
public class RecibosDTO {

    int idrecibo = -1;
    Usuarios_ServiciosDTO usuario_servicio = null;//int idusuario_servicio;
    ServiciosDTO servicio = null;//int idservicio;
    int periodorecibo = -1;
    int medicioninicial = -1;
    int medicionfinal = -1;
    Date fechami = null;
    Date fechamf = null;
    int montorecibo = -1;
    int consumorecibo = -1;
    int preciounidad = -1;
    Date fechavencimiento = null;
    int estadorecibo = -1;

    public RecibosDTO() {
    }

    public RecibosDTO(int idrecibo, Usuarios_ServiciosDTO usuario_servicio, ServiciosDTO servicio, int periodorecibo, int medicioninicial, int medicionfinal, Date fechami, Date fechamf, int montorecibo, int consumorecibo, int preciounidad, Date fechavencimiento, int estadorecibo) {
        this.idrecibo = idrecibo;
        this.usuario_servicio = usuario_servicio;
        this.servicio = servicio;
        this.periodorecibo = periodorecibo;
        this.medicioninicial = medicioninicial;
        this.medicionfinal = medicionfinal;
        this.fechami = fechami;
        this.fechamf = fechamf;
        this.montorecibo = montorecibo;
        this.consumorecibo = consumorecibo;
        this.preciounidad = preciounidad;
        this.fechavencimiento = fechavencimiento;
        this.estadorecibo = estadorecibo;
    }

    public int getConsumorecibo() {
        return consumorecibo;
    }

    public void setConsumorecibo(int consumorecibo) {
        this.consumorecibo = consumorecibo;
    }

    public int getEstadorecibo() {
        return estadorecibo;
    }

    public void setEstadorecibo(int estadorecibo) {
        this.estadorecibo = estadorecibo;
    }

    public Date getFechamf() {
        return fechamf;
    }

    public void setFechamf(Date fechamf) {
        this.fechamf = fechamf;
    }

    public Date getFechami() {
        return fechami;
    }

    public void setFechami(Date fechami) {
        this.fechami = fechami;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getIdrecibo() {
        return idrecibo;
    }

    public void setIdrecibo(int idrecibo) {
        this.idrecibo = idrecibo;
    }

    public int getMedicionfinal() {
        return medicionfinal;
    }

    public void setMedicionfinal(int medicionfinal) {
        this.medicionfinal = medicionfinal;
    }

    public int getMedicioninicial() {
        return medicioninicial;
    }

    public void setMedicioninicial(int medicioninicial) {
        this.medicioninicial = medicioninicial;
    }

    public int getMontorecibo() {
        return montorecibo;
    }

    public void setMontorecibo(int montorecibo) {
        this.montorecibo = montorecibo;
    }

    public int getPeriodorecibo() {
        return periodorecibo;
    }

    public void setPeriodorecibo(int periodorecibo) {
        this.periodorecibo = periodorecibo;
    }

    public int getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(int preciounidad) {
        this.preciounidad = preciounidad;
    }

    public ServiciosDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServiciosDTO servicio) {
        this.servicio = servicio;
    }

    public Usuarios_ServiciosDTO getUsuario_servicio() {
        return usuario_servicio;
    }

    public void setUsuario_servicio(Usuarios_ServiciosDTO usuario_servicio) {
        this.usuario_servicio = usuario_servicio;
    }
}
