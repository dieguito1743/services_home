/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.conexion;

import com.pe.interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbermudez
 */
public class SQLConexion implements IConexion {

    public static IConexion instance;
    private Connection cnn;
    private String url = "",
            user = "", pass = "";

    private SQLConexion(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized IConexion crearConexion(String url, String user, String pass, String driver) {
        if (instance == null) {
            instance = new SQLConexion(url, user, pass, driver);
        }
        return instance;
    }

    @Override
    public Connection getCnn() {
        if (cnn != null) {
            return cnn;
        } else {
            System.out.println("conexion nula... reintentando");
            instance = new SQLConexion(url, user, pass, user);
            return cnn;
        }
    }

    @Override
    public void cerrarConexion() {
        instance = null;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    public void cerrarConexion(Connection cnn) {
        try {
            if (instance != null) {
                instance = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("no se puede cerrar conexion");
        }
    }
}
