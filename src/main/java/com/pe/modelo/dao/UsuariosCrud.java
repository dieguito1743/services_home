/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.UsuariosDTO;
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
@Component(UtilDefines.INSTANCE_USUARIOS)
public class UsuariosCrud implements ICrud<UsuariosDTO> {

    private static IConexion cnn = null;

    public String insertar(UsuariosDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, objetoNuevo.getTipousuario());
            pst.setString(2, objetoNuevo.getNombreusuario());
            pst.setString(3, objetoNuevo.getApellidousuario());
            pst.setString(4, objetoNuevo.getAccusuario());
            pst.setString(5, objetoNuevo.getPassusuario());
            pst.setString(6, objetoNuevo.getTelefonousuario());
            pst.setString(7, objetoNuevo.getCorreousuario());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(UsuariosDTO objetoAntiguo, UsuariosDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SQL_UPDATE);
            pst.setInt(1, objetoActualizar.getTipousuario());
            pst.setString(2, objetoActualizar.getNombreusuario());
            pst.setString(3, objetoActualizar.getApellidousuario());
            pst.setString(4, objetoActualizar.getAccusuario());
            pst.setString(5, objetoActualizar.getPassusuario());
            pst.setString(6, objetoActualizar.getTelefonousuario());
            pst.setString(7, objetoActualizar.getCorreousuario());
            pst.setInt(8, objetoAntiguo.getIdusuario());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean eliminar(UsuariosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UsuariosDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<UsuariosDTO> arrayListRetorno = null;
        UsuariosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new UsuariosDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                arrayListRetorno.add(objetoDTO);
            }
            if (arrayListRetorno.size() <= 0) {
                arrayListRetorno = null;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<UsuariosDTO> consultarTodo(List<UsuariosDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 4);
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<UsuariosDTO> arrayListRetorno = null;
        UsuariosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new UsuariosDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public UsuariosDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        UsuariosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.USUARIOS_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new UsuariosDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosCrud.class.getName()).log(Level.SEVERE, null, ex);
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
