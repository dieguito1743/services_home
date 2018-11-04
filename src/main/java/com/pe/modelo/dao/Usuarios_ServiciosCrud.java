/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.Usuarios_ServiciosDTO;
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
@Component(UtilDefines.INSTANCE_USUARIOS_SERVICIOS)
public class Usuarios_ServiciosCrud implements ICrud<Usuarios_ServiciosDTO> {

    private static IConexion cnn = null;

    public String insertar(Usuarios_ServiciosDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SERVICIOS_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, objetoNuevo.getServicio().getIdservicio());
            pst.setInt(2, objetoNuevo.getUsuario().getIdusuario());
            pst.setDate(3, objetoNuevo.getFechainicio());
            pst.setDate(4, objetoNuevo.getFechaalta());
            pst.setInt(5, objetoNuevo.getEstado());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(Usuarios_ServiciosDTO objetoAntiguo, Usuarios_ServiciosDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SERVICIOS_SQL_UPDATE);
            pst.setInt(1, objetoActualizar.getServicio().getIdservicio());
            pst.setInt(2, objetoActualizar.getUsuario().getIdusuario());
            pst.setDate(3, objetoActualizar.getFechainicio());
            pst.setDate(4, objetoActualizar.getFechainicio());
            pst.setInt(5, objetoActualizar.getEstado());
            pst.setInt(6, objetoAntiguo.getIdusuario_servicio());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean eliminar(Usuarios_ServiciosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Usuarios_ServiciosDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<Usuarios_ServiciosDTO> arrayListRetorno = null;
        Usuarios_ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SERVICIOS_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new Usuarios_ServiciosDTO(rs.getInt(1),
                        new ServiciosCrud().consultarUnoByPK(rs.getString(2)),
                        new UsuariosCrud().consultarUnoByPK(rs.getString(3)),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getInt(6));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<Usuarios_ServiciosDTO> consultarTodo(List<Usuarios_ServiciosDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 5);
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<Usuarios_ServiciosDTO> arrayListRetorno = null;
        Usuarios_ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SERVICIOS_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new Usuarios_ServiciosDTO(rs.getInt(1),
                        new ServiciosCrud().consultarUnoByPK(rs.getString(2)),
                        new UsuariosCrud().consultarUnoByPK(rs.getString(3)),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getInt(6));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public Usuarios_ServiciosDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        Usuarios_ServiciosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SERVICIOS_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new Usuarios_ServiciosDTO(rs.getInt(1),
                        new ServiciosCrud().consultarUnoByPK(rs.getString(2)),
                        new UsuariosCrud().consultarUnoByPK(rs.getString(3)),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getInt(6));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Usuarios_ServiciosCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verificarConexion() {
        if (cnn == null) {
            cnn = JavaConexion.crearConexion();
        }
    }
}
