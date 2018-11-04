/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.RolesDTO;
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
@Component(UtilDefines.INSTANCE_ROLES)
public class RolesCrud implements ICrud<RolesDTO> {

    private static IConexion cnn = null;

    public String insertar(RolesDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.ROLES_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, objetoNuevo.getUsuario().getIdusuario());
            pst.setInt(2, objetoNuevo.getModulo().getIdmodulo());
            pst.setInt(3, objetoNuevo.getNivelModulo());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(RolesDTO objetoAntiguo, RolesDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.ROLES_SQL_UPDATE);
            pst.setInt(1, objetoActualizar.getUsuario().getIdusuario());
            pst.setInt(2, objetoActualizar.getModulo().getIdmodulo());
            pst.setInt(3, objetoActualizar.getNivelModulo());
            pst.setInt(4, objetoAntiguo.getIdrol());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;

        }
    }

    public boolean eliminar(RolesDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RolesDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<RolesDTO> arrayListRetorno = null;
        RolesDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.ROLES_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new RolesDTO(rs.getInt(1),
                        new UsuariosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ModulosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<RolesDTO> consultarTodo(List<RolesDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 2);
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<RolesDTO> arrayListRetorno = null;
        RolesDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.ROLES_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new RolesDTO(rs.getInt(1),
                        new UsuariosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ModulosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public RolesDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        RolesDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.ROLES_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new RolesDTO(rs.getInt(1),
                        new UsuariosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ModulosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RolesCrud.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verificarConexion() {
        if (cnn == null) {
            cnn = JavaConexion.crearConexion();
        }
    }
}
