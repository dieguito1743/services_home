/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.ServiciosDTO;
import com.pe.modelo.util.SQLDefine;
import com.pe.modelo.util.SQLFunction;
import com.pe.util.BussinessException;
import com.pe.util.UtilDefines;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbermudez
 */
@Component(UtilDefines.INSTANCE_SERVICIOS)
public class ServiciosCrud implements ICrud<ServiciosDTO> {

    private static IConexion cnn = null;

    public String insertar(ServiciosDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.SERVICIOS_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, objetoNuevo.getNombreservicio());
            pst.setDate(2, objetoNuevo.getFecharegistroservicio());
            pst.setDate(3, objetoNuevo.getFechaaltaservicio());
            pst.setInt(4, objetoNuevo.getEstadoservicio());
            pst.setString(5, objetoNuevo.getDescripcion());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(ServiciosDTO objetoAntiguo, ServiciosDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.SERVICIOS_SQL_UPDATE);
            pst.setString(1, objetoActualizar.getNombreservicio());
            pst.setDate(2, objetoActualizar.getFecharegistroservicio());
            pst.setDate(3, objetoActualizar.getFechaaltaservicio());
            pst.setInt(4, objetoActualizar.getEstadoservicio());
            pst.setString(5, objetoActualizar.getDescripcion());
            pst.setInt(6, objetoAntiguo.getIdservicio());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean eliminar(ServiciosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ServiciosDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<ServiciosDTO> arrayListRetorno = null;
        ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.SERVICIOS_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new ServiciosDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<ServiciosDTO> consultarTodo(List<ServiciosDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 3);
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<ServiciosDTO> arrayListRetorno = null;
        ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.SERVICIOS_SQL_CONSULTAR_TODO + condicion);
            System.out.println(SQLDefine.SERVICIOS_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new ServiciosDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public ServiciosDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.SERVICIOS_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new ServiciosDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return objetoDTO;
        }
    }

    public void closes(PreparedStatement pst, ResultSet rs) {
        try {
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verificarConexion() {
        if (cnn == null) {
            cnn = JavaConexion.crearConexion();
        }
    }
}
