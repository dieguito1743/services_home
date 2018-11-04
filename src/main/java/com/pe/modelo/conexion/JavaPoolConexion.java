/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.conexion;

import com.pe.interfaces.IConexion;
import java.sql.Connection;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author dbermudez
 */
public class JavaPoolConexion implements IConexion {

    public static IConexion instance;
    private static String url = "",
            user = "", pass = "";
    private static int imaxActive = 0, iminIdle = 0, imaxIdle = 0, iinitialSize = 0;
    private static BasicDataSource basicDataSource = null;

    private JavaPoolConexion(String url, String user, String pass, String driver) {
        JavaPoolConexion.url = url;
        JavaPoolConexion.user = user;
        JavaPoolConexion.pass = pass;
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setMaxActive(JavaPoolConexion.imaxActive);
        basicDataSource.setMinIdle(JavaPoolConexion.iminIdle);
        basicDataSource.setMaxIdle(JavaPoolConexion.imaxIdle);
        basicDataSource.setInitialSize(JavaPoolConexion.iinitialSize);
    }

    public static synchronized IConexion crearConexion(String url, String user, String pass, String driver) {
        if (instance == null) {
            instance = new JavaPoolConexion(url, user, pass, driver);
        }
        return instance;
    }

    public static synchronized IConexion crearConexion(String url, String user, String pass, String driver, String imaxActive, String iminIdle, String imaxIdle, String iinitialSize) {
        if (instance == null) {
            try {
                JavaPoolConexion.imaxActive = Integer.parseInt(imaxActive);
                JavaPoolConexion.iminIdle = Integer.parseInt(iminIdle);
                JavaPoolConexion.imaxIdle = Integer.parseInt(imaxIdle);
                JavaPoolConexion.iinitialSize = Integer.parseInt(iinitialSize);
            } catch (Exception ex) {
                System.out.println("No puede parsearse");
            }
            instance = new JavaPoolConexion(url, user, pass, driver);
        }
        return instance;
    }

    public Connection getCnn() {
        Connection cnn = null;
        try {
            cnn = basicDataSource.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("no se puede obtener conexion");
        } finally {
            return cnn;
        }
    }

    public void cerrarConexion(Connection cnn) {
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("no se puede cerrar conexion");
        }
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUser(String user) {
        JavaPoolConexion.user = user;
    }

    public void setPass(String pass) {
        JavaPoolConexion.pass = pass;
    }

    public void setUrl(String url) {
        JavaPoolConexion.url = url;
    }

    public void cerrarConexion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
