/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.ModulosDTO;
import com.pe.modelo.util.SQLDefine;
import com.pe.util.BussinessException;
import com.pe.modelo.util.SQLFunction;
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
@Component(UtilDefines.INSTANCE_MODULOS)
public class ModulosCrud implements ICrud<ModulosDTO> {

    private static IConexion cnn = null;

    public String insertar(ModulosDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.MODULOS_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, objetoNuevo.getNombremodulo());
            pst.setInt(2, objetoNuevo.getNivelesmodulo());
            pst.setString(3,objetoNuevo.getPage());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(ModulosDTO objetoAntiguo, ModulosDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.MODULOS_SQL_UPDATE);
            pst.setString(1, objetoActualizar.getNombremodulo());
            pst.setInt(2, objetoActualizar.getNivelesmodulo());
            pst.setString(3, objetoActualizar.getPage());
            pst.setInt(4, objetoAntiguo.getIdmodulo());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean eliminar(ModulosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ModulosDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<ModulosDTO> arrayListRetorno = null;
        ModulosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.MODULOS_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new ModulosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<ModulosDTO> consultarTodo(List<ModulosDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 0);
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        ArrayList<ModulosDTO> arrayListRetorno = null;
        ModulosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.MODULOS_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new ModulosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public ModulosDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ModulosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.MODULOS_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new ModulosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModulosCrud.class.getName()).log(Level.SEVERE, null, ex);
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
