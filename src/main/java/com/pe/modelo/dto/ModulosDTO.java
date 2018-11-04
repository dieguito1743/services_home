/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dto;

/**
 *
 * @author dbermudez
 */
public class ModulosDTO {

    int idmodulo = -1;
    String nombremodulo = "";
    int nivelesmodulo = -1;

    public ModulosDTO() {
    }

    public ModulosDTO(int idmodulo, String nombremodulo, int nivelesmodulo) {
        this.idmodulo = idmodulo;
        this.nombremodulo = nombremodulo;
        this.nivelesmodulo = nivelesmodulo;
    }

    public int getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(int idmodulo) {
        this.idmodulo = idmodulo;
    }

    public int getNivelesmodulo() {
        return nivelesmodulo;
    }

    public void setNivelesmodulo(int nivelesmodulo) {
        this.nivelesmodulo = nivelesmodulo;
    }

    public String getNombremodulo() {
        return nombremodulo;
    }

    public void setNombremodulo(String nombremodulo) {
        this.nombremodulo = nombremodulo;
    }
}
