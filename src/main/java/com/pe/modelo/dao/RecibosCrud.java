/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.dao;

import com.pe.interfaces.ICrud;
import com.pe.interfaces.IConexion;
import com.pe.modelo.conexion.JavaConexion;
import com.pe.modelo.dto.RecibosDTO;
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
@Component(UtilDefines.INSTANCE_RECIBOS)
public class RecibosCrud implements ICrud<RecibosDTO> {

    private static IConexion cnn = null;

    public String insertar(RecibosDTO objetoNuevo) throws BussinessException {
        String retorno = UtilDefines.INSERT_ERROR;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.RECIBOS_SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, objetoNuevo.getUsuario_servicio().getIdusuario_servicio());
            pst.setInt(2, objetoNuevo.getServicio().getIdservicio());
            pst.setInt(3, objetoNuevo.getPeriodorecibo());
            pst.setInt(4, objetoNuevo.getMedicioninicial());
            pst.setInt(5, objetoNuevo.getMedicionfinal());
            pst.setDate(6, objetoNuevo.getFechami());
            pst.setDate(7, objetoNuevo.getFechamf());
            pst.setInt(8, objetoNuevo.getMontorecibo());
            pst.setInt(9, objetoNuevo.getConsumorecibo());
            pst.setInt(10, objetoNuevo.getPreciounidad());
            pst.setDate(11, objetoNuevo.getFechavencimiento());
            pst.setInt(12, objetoNuevo.getEstadorecibo());
            if (pst.executeUpdate() > 0) {
                rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getString(1);
                }
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean actualizar(RecibosDTO objetoAntiguo, RecibosDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement pst = null;
        Connection con = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.RECIBOS_SQL_UPDATE);
            pst.setInt(1, objetoAntiguo.getUsuario_servicio().getIdusuario_servicio());
            pst.setInt(2, objetoAntiguo.getServicio().getIdservicio());
            pst.setInt(3, objetoAntiguo.getPeriodorecibo());
            pst.setInt(4, objetoAntiguo.getMedicioninicial());
            pst.setInt(5, objetoAntiguo.getMedicionfinal());
            pst.setDate(6, objetoAntiguo.getFechami());
            pst.setDate(7, objetoAntiguo.getFechamf());
            pst.setInt(8, objetoAntiguo.getMontorecibo());
            pst.setInt(9, objetoAntiguo.getConsumorecibo());
            pst.setInt(10, objetoAntiguo.getPreciounidad());
            pst.setDate(11, objetoAntiguo.getFechavencimiento());
            pst.setInt(12, objetoActualizar.getEstadorecibo());
            pst.setInt(13, objetoAntiguo.getIdrecibo());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, null);
            cnn.cerrarConexion(con);
            return retorno;
        }
    }

    public boolean eliminar(RecibosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecibosDTO> consultarTodo() throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<RecibosDTO> arrayListRetorno = null;
        RecibosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.RECIBOS_SQL_CONSULTAR_TODO);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new RecibosDTO(rs.getInt(1),
                        new Usuarios_ServiciosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ServiciosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getDate(12),
                        rs.getInt(13));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public List<RecibosDTO> consultarTodo(List<RecibosDTO> listaParametros) throws BussinessException {
        String condicion = SQLFunction.construirCondicional(listaParametros, 1);
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList<RecibosDTO> arrayListRetorno = null;
        RecibosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.RECIBOS_SQL_CONSULTAR_TODO + condicion);
            rs = pst.executeQuery();
            arrayListRetorno = new ArrayList();
            while (rs.next()) {
                objetoDTO = new RecibosDTO(rs.getInt(1),
                        new Usuarios_ServiciosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ServiciosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getDate(12),
                        rs.getInt(13));
                arrayListRetorno.add(objetoDTO);
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closes(pst, rs);
            cnn.cerrarConexion(con);
            return arrayListRetorno;
        }
    }

    public RecibosDTO consultarUnoByPK(Object primaryKey) throws BussinessException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        RecibosDTO objetoDTO = null;
        try {
            verificarConexion();
            pst = (con = cnn.getCnn()).prepareStatement(SQLDefine.RECIBOS_SQL_SELECT);
            pst.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = pst.executeQuery();
            if (rs.next()) {
                objetoDTO = new RecibosDTO(rs.getInt(1),
                        new Usuarios_ServiciosCrud().consultarUnoByPK(rs.getInt(2)),
                        new ServiciosCrud().consultarUnoByPK(rs.getInt(3)),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getDate(12),
                        rs.getInt(13));
            }
            System.out.println(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecibosCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verificarConexion() {
        if (cnn == null) {
            cnn = JavaConexion.crearConexion();
        }
    }
}
