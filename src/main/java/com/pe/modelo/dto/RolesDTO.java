/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dto;

/**
 *
 * @author dbermudez
 */
public class RolesDTO {

    private int idrol = -1;
    private UsuariosDTO usuario = null;//int idusuario;
    private ModulosDTO modulo = null;//int idmodulo;
    private int nivelModulo = -1;

    public RolesDTO() {
    }

    public RolesDTO(int idrol, UsuariosDTO usuario, ModulosDTO modulo, int nivelModulo) {
        this.idrol = idrol;
        this.usuario = usuario;
        this.modulo = modulo;
        this.nivelModulo = nivelModulo;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public ModulosDTO getModulo() {
        return modulo;
    }

    public void setModulo(ModulosDTO modulo) {
        this.modulo = modulo;
    }

    public UsuariosDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosDTO usuario) {
        this.usuario = usuario;
    }

    public int getNivelModulo() {
        return nivelModulo;
    }

    public void setNivelModulo(int nivelModulo) {
        this.nivelModulo = nivelModulo;
    }
}
