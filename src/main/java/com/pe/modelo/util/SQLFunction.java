/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.util;

import com.pe.modelo.dto.ModulosDTO;
import com.pe.modelo.dto.RecibosDTO;
import com.pe.modelo.dto.RolesDTO;
import com.pe.modelo.dto.ServiciosDTO;
import com.pe.modelo.dto.UsuariosDTO;
import com.pe.modelo.dto.Usuarios_ServiciosDTO;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author dbermudez
 */
public class SQLFunction {

    /**
     * 
     * @param lista
     * @param clase 0 modulo <br> 1 recibos <br> 2 roles <br> 3 servicios <br> 4 usuarios <br> 5 usuarios_servicios
     * @return 
     */
    public static String construirCondicional(List lista, int clase) {
        System.out.println("lista.size(): " + lista.size() + " clase: " + clase);
        String sRet = "";
        switch (clase) {
            case 0:
                sRet = construirCondicionalModulo(lista);
                break;
            case 1:
                sRet = construirCondicionalRecibo(lista);
                break;
            case 2:
                sRet = construirCondicionalRol(lista);
                break;
            case 3:
                sRet = construirCondicionalServicio(lista);
                break;
            case 4:
                sRet = construirCondicionalUsuario(lista);
                break;
            case 5:
                sRet = construirCondicionalUsuarioServicio(lista);
                break;
        }
        return sRet;
    }

    private static String construirCondicionalModulo(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            ModulosDTO objectDTO = (ModulosDTO) lista.get(i);
            if (objectDTO.getIdmodulo() > 0) {
                if (pand) {
                    condicion = condicion + " idmodulo = " + objectDTO.getIdmodulo();
                    pand = false;
                } else {
                    condicion = condicion + " AND idmodulo = " + objectDTO.getIdmodulo();
                }
            }
            if (objectDTO.getNombremodulo() != null && !objectDTO.getNombremodulo().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " nombremodulo = '" + objectDTO.getNombremodulo() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND nombremodulo = '" + objectDTO.getNombremodulo() + "'";
                }
            }
            if (objectDTO.getNivelesmodulo() > 0) {
                if (pand) {
                    condicion = condicion + " nivelmodulo = " + objectDTO.getNivelesmodulo();
                    pand = false;
                } else {
                    condicion = condicion + " AND nivelmodulo = " + objectDTO.getNivelesmodulo();
                }
            }
            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String construirCondicionalRecibo(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            RecibosDTO objectDTO = (RecibosDTO) lista.get(i);
            if (objectDTO.getIdrecibo() > 0) {
                if (pand) {
                    condicion = condicion + " idrecibo = " + objectDTO.getIdrecibo();
                    pand = false;
                } else {
                    condicion = condicion + " AND idrecibo = " + objectDTO.getIdrecibo();
                }
            }
            if (objectDTO.getUsuario_servicio() != null && objectDTO.getUsuario_servicio().getIdusuario_servicio() > 0) {
                if (pand) {
                    condicion = condicion + " idusuario_servicio = " + objectDTO.getUsuario_servicio().getIdusuario_servicio() + "";
                    pand = false;
                } else {
                    condicion = condicion + " AND idusuario_servicio = " + objectDTO.getUsuario_servicio().getIdusuario_servicio() + "";
                }
            }
            if (objectDTO.getServicio() != null && objectDTO.getServicio().getIdservicio() > 0) {
                if (pand) {
                    condicion = condicion + " idservicio = " + objectDTO.getServicio().getIdservicio();
                    pand = false;
                } else {
                    condicion = condicion + " AND idservicio = " + objectDTO.getServicio().getIdservicio();
                }
            }
            if (objectDTO.getPeriodorecibo() > 0) {
                if (pand) {
                    condicion = condicion + " periodorecibo = " + objectDTO.getPeriodorecibo();
                    pand = false;
                } else {
                    condicion = condicion + " AND periodorecibo = " + objectDTO.getPeriodorecibo();
                }
            }
            if (objectDTO.getMedicioninicial() > 0) {
                if (pand) {
                    condicion = condicion + " medicioninicial = " + objectDTO.getMedicioninicial();
                    pand = false;
                } else {
                    condicion = condicion + " AND medicioninicial = " + objectDTO.getMedicioninicial();
                }
            }
            if (objectDTO.getMedicionfinal() > 0) {
                if (pand) {
                    condicion = condicion + " medicionfinal = " + objectDTO.getMedicionfinal();
                    pand = false;
                } else {
                    condicion = condicion + " AND medicionfinal = " + objectDTO.getMedicionfinal();
                }
            }
            if (objectDTO.getFechami() != null) {
                if (pand) {
                    condicion = condicion + " fechami = '" + objectDTO.getFechami() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechami = " + objectDTO.getFechami() + "'";
                }
            }
            if (objectDTO.getFechamf() != null) {
                if (pand) {
                    condicion = condicion + " fechamf = '" + objectDTO.getFechamf() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechamf = " + objectDTO.getFechamf() + "'";
                }
            }
            if (objectDTO.getMontorecibo() > 0) {
                if (pand) {
                    condicion = condicion + " montorecibo = " + objectDTO.getMontorecibo();
                    pand = false;
                } else {
                    condicion = condicion + " AND montorecibo = " + objectDTO.getMontorecibo();
                }
            }
            if (objectDTO.getConsumorecibo() > 0) {
                if (pand) {
                    condicion = condicion + " consumorecibo = " + objectDTO.getConsumorecibo();
                    pand = false;
                } else {
                    condicion = condicion + " AND consumorecibo = " + objectDTO.getConsumorecibo();
                }
            }
            if (objectDTO.getPreciounidad() > 0) {
                if (pand) {
                    condicion = condicion + " preciounidad = " + objectDTO.getPreciounidad();
                    pand = false;
                } else {
                    condicion = condicion + " AND preciounidad = " + objectDTO.getPreciounidad();
                }
            }
            if (objectDTO.getFechavencimiento() != null) {
                if (pand) {
                    condicion = condicion + " fechavencimiento = '" + objectDTO.getFechavencimiento() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechavencimiento = " + objectDTO.getFechavencimiento() + "'";
                }
            }
            if (objectDTO.getEstadorecibo() > 0) {
                if (pand) {
                    condicion = condicion + " estadorecibo = " + objectDTO.getEstadorecibo();
                    pand = false;
                } else {
                    condicion = condicion + " AND estadorecibo = " + objectDTO.getEstadorecibo();
                }
            }
            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String construirCondicionalRol(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            RolesDTO objectDTO = (RolesDTO) lista.get(i);
            if (objectDTO.getIdrol() > 0) {
                if (pand) {
                    condicion = condicion + " idrol = " + objectDTO.getIdrol();
                    pand = false;
                } else {
                    condicion = condicion + " AND idrol = " + objectDTO.getIdrol();
                }
            }
            if (objectDTO.getUsuario() != null && objectDTO.getUsuario().getIdusuario() > 0) {
                if (pand) {
                    condicion = condicion + " idusuario = " + objectDTO.getUsuario().getIdusuario() + "";
                    pand = false;
                } else {
                    condicion = condicion + " AND idusuario = " + objectDTO.getUsuario().getIdusuario() + "";
                }
            }
            if (objectDTO.getModulo() != null && objectDTO.getModulo().getIdmodulo() > 0) {
                if (pand) {
                    condicion = condicion + " idmodulo = " + objectDTO.getModulo().getIdmodulo() + "";
                    pand = false;
                } else {
                    condicion = condicion + " AND idmodulo = " + objectDTO.getModulo().getIdmodulo() + "";
                }
            }
            /*
            if (objectDTO.getIdrol() > 0) {
                if (pand) {
                    condicion = condicion + " nivelmodulo = " + objectDTO.getNivelModulo();
                    pand = false;
                } else {
                    condicion = condicion + " AND nivelmodulo = " + objectDTO.getNivelModulo();
                }
            }
            */
            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String construirCondicionalServicio(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            ServiciosDTO objectDTO = (ServiciosDTO) lista.get(i);
            if (objectDTO.getIdservicio() > 0) {
                if (pand) {
                    condicion = condicion + " idservicio = " + objectDTO.getIdservicio();
                    pand = false;
                } else {
                    condicion = condicion + " AND idservicio = " + objectDTO.getIdservicio();
                }
            }
            if (objectDTO.getNombreservicio() != null && !objectDTO.getNombreservicio().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " nombreservicio = '" + objectDTO.getNombreservicio() + "' ";
                    pand = false;
                } else {
                    condicion = condicion + " AND nombreservicio = '" + objectDTO.getNombreservicio() + "' ";
                }
            }
            if (objectDTO.getFecharegistroservicio() != null) {
                if (pand) {
                    condicion = condicion + " fecharegistroservicio = '" + objectDTO.getFecharegistroservicio() + "' ";
                    pand = false;
                } else {
                    condicion = condicion + " AND fecharegistroservicio = '" + objectDTO.getFecharegistroservicio() + "' ";
                }
            }
            if (objectDTO.getFechaaltaservicio() != null) {
                if (pand) {
                    condicion = condicion + " fechaaltaservicio = '" + objectDTO.getFechaaltaservicio() + "' ";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechaaltaservicio = '" + objectDTO.getFechaaltaservicio() + "' ";
                }
            }
            if (objectDTO.getEstadoservicio() > 0) {
                if (pand) {
                    condicion = condicion + " estadoservicio = " + objectDTO.getEstadoservicio();
                    pand = false;
                } else {
                    condicion = condicion + " AND estadoservicio = " + objectDTO.getEstadoservicio();
                }
            }
            if (objectDTO.getDescripcion() != null && !objectDTO.getDescripcion().equals("")) {
                if (pand) {
                    condicion = condicion + " descripcion = '" + objectDTO.getDescripcion() + "' ";
                    pand = false;
                } else {
                    condicion = condicion + " AND descripcion = '" + objectDTO.getDescripcion() + "' ";
                }
            }
            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String construirCondicionalUsuario(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            UsuariosDTO objectDTO = (UsuariosDTO) lista.get(i);
            if (objectDTO.getIdusuario() > 0) {
                if (pand) {
                    condicion = condicion + " idusuario = " + objectDTO.getIdusuario();
                    pand = false;
                } else {
                    condicion = condicion + " AND idusuario = " + objectDTO.getIdusuario();
                }
            }
            if (objectDTO.getTipousuario() > 0) {
                if (pand) {
                    condicion = condicion + " tipousuario = " + objectDTO.getTipousuario();
                    pand = false;
                } else {
                    condicion = condicion + " AND tipousuario = " + objectDTO.getTipousuario();
                }
            }
            if (objectDTO.getNombreusuario() != null && !objectDTO.getNombreusuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " nombreusuario = '" + objectDTO.getNombreusuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND nombreusuario = '" + objectDTO.getNombreusuario() + "'";
                }
            }
            if (objectDTO.getApellidousuario() != null && !objectDTO.getApellidousuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " apellidousuario = '" + objectDTO.getApellidousuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND apellidousuario = '" + objectDTO.getApellidousuario() + "'";
                }
            }
            if (objectDTO.getAccusuario() != null && !objectDTO.getAccusuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " accusuario = '" + objectDTO.getAccusuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND accusuario = '" + objectDTO.getAccusuario() + "'";
                }
            }
            if (objectDTO.getPassusuario() != null && !objectDTO.getPassusuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " passusuario = '" + objectDTO.getPassusuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND passusuario = '" + objectDTO.getPassusuario() + "'";
                }
            }
            if (objectDTO.getTelefonousuario() != null && !objectDTO.getTelefonousuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " telefonousuario = '" + objectDTO.getTelefonousuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND telefonousuario = '" + objectDTO.getTelefonousuario() + "'";
                }
            }
            if (objectDTO.getCorreousuario() != null && !objectDTO.getCorreousuario().equalsIgnoreCase("")) {
                if (pand) {
                    condicion = condicion + " correousuario = '" + objectDTO.getCorreousuario() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND correousuario = '" + objectDTO.getCorreousuario() + "'";
                }
            }

            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String construirCondicionalUsuarioServicio(List lista) {
        String condicion = " WHERE ( ";
        for (int i = 0; i < lista.size(); i++) {
            boolean pand = true;
            if (i > 0 && condicion.length() > 8) {
                condicion = condicion + " OR ( ";
            }
            Usuarios_ServiciosDTO objectDTO = (Usuarios_ServiciosDTO) lista.get(i);
            if (objectDTO.getIdusuario_servicio() > 0) {
                if (pand) {
                    condicion = condicion + " idusuario_servicio = " + objectDTO.getIdusuario_servicio();
                    pand = false;
                } else {
                    condicion = condicion + " AND idusuario_servicio = " + objectDTO.getIdusuario_servicio();
                }
            }
            if (objectDTO.getServicio() != null && objectDTO.getServicio().getIdservicio() > 0) {
                if (pand) {
                    condicion = condicion + " idservicio = " + objectDTO.getServicio().getIdservicio() + "";
                    pand = false;
                } else {
                    condicion = condicion + " AND idservicio = " + objectDTO.getServicio().getIdservicio() + "";
                }
            }
            if (objectDTO.getUsuario() != null && objectDTO.getUsuario().getIdusuario() > 0) {
                if (pand) {
                    condicion = condicion + " idusuario = " + objectDTO.getUsuario().getIdusuario() + "";
                    pand = false;
                } else {
                    condicion = condicion + " AND idusuario = " + objectDTO.getUsuario().getIdusuario() + "";
                }
            }
            if (objectDTO.getFechaalta() != null) {
                if (pand) {
                    condicion = condicion + " fechaalta = '" + objectDTO.getFechaalta() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechaalta = '" + objectDTO.getFechaalta() + "'";
                }
            }
            if (objectDTO.getFechainicio() != null) {
                if (pand) {
                    condicion = condicion + " fechainicio = '" + objectDTO.getFechainicio() + "'";
                    pand = false;
                } else {
                    condicion = condicion + " AND fechainicio = '" + objectDTO.getFechainicio() + "'";
                }
            }
            if (objectDTO.getEstado() > 0) {
                if (pand) {
                    condicion = condicion + " estado = " + objectDTO.getEstado();
                    pand = false;
                } else {
                    condicion = condicion + " AND estado = " + objectDTO.getEstado();
                }
            }
            condicion = condicion + " ) ";
        }
        condicion = limpiarCondicion(condicion);
        if (condicion.length() > 8) {
            return condicion;
        }
        return "";
    }

    private static String limpiarCondicion(String condicion) {
        String retorno = "";
        retorno = condicion.replaceAll(Pattern.quote(" OR (  ) "), "");
        retorno = retorno.replaceAll(Pattern.quote(" (  ) "), "");
        retorno = retorno.replaceAll(Pattern.quote("WHERE OR"), "WHERE");
        return retorno;
    }
}
