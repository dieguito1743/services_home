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
public class MySQLConexion implements IConexion {

    public static IConexion instance;
    private Connection cnn;
    private String url = "",
            user = "", pass = "";

    private MySQLConexion() {
        try {
            Class.forName("");
            cnn = DriverManager.getConnection("",
                    "",
                    "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MySQLConexion(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        try {
            Class.forName("");
            cnn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //@Override
    public static synchronized IConexion crearConexion(String url, String user, String pass) {
        if (instance == null) {
            instance = new MySQLConexion(url, user, pass);
        }
        return instance;
    }

    //@Override
    public static synchronized IConexion crearConexion() {
        if (instance == null) {
            instance = new MySQLConexion();
        }
        return instance;
    }

    @Override
    public Connection getCnn() {
        return cnn;
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
}
