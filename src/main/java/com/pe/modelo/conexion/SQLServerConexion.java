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
public class SQLServerConexion implements IConexion {

    public static IConexion instance;
    private Connection cnn;
    private String url = "jdbc:sqlserver://192.168.61.11:1433;databaseName=DBHCENTER2",
            user = "sa", pass = "MCperu1425";

    private SQLServerConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://192.168.61.11:1433;databaseName=DBHCENTER2",
                    "sa",
                    "MCperu1425");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServerConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private SQLServerConexion(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        try {
            Class.forName("jdbc:sqlserver://192.168.61.11:1433;databaseName=DBHCENTER2");
            cnn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServerConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //@Override
    public static synchronized IConexion crearConexion(String url, String user, String pass) {
        if (instance == null) {
            instance = new SQLServerConexion(url, user, pass);
        }
        return instance;
    }

    //@Override
    public static synchronized IConexion crearConexion() {
        if (instance == null) {
            instance = new SQLServerConexion();
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
