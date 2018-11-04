/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.conexion;

import com.pe.interfaces.IConexion;
import com.pe.util.FileFunction;
import com.pe.util.UtilDefines;
import java.io.File;

/**
 *
 * @author dbermudez
 */
public class JavaConexion {

    private static String url = null, user = null, pass = null, drive = null, con = null;
    private static String imaxActive = null, iminIdle = null, imaxIdle = null, iinitialSize = null;
    private static IConexion conn = null;
    private static String nombreAux = "";

    public static IConexion crearConexion() {
        nombreAux = UtilDefines.PATH + File.separator + UtilDefines.PROPERTIES;
        if (url == null || user == null || pass == null || drive == null || con == null) {
            url = FileFunction.getPropertie(UtilDefines.URL, nombreAux);
            user = FileFunction.getPropertie(UtilDefines.USER, nombreAux);
            pass = FileFunction.getPropertie(UtilDefines.PASS, nombreAux);
            drive = FileFunction.getPropertie(UtilDefines.DRIVER, nombreAux);
            con = FileFunction.getPropertie(UtilDefines.SGBD, nombreAux);
            System.out.println("Parametros de conexion, leyendo...");
            System.out.println("DATOS DE CONEXION : \nURL: " + url + "\nUSER: " + user + "\nPASS: " + pass + "\nDRIVE: " + drive + "\nCON: " + con);
        }
        if (imaxActive == null || iminIdle == null || imaxIdle == null || iinitialSize == null) {
            imaxActive = FileFunction.getPropertie(UtilDefines.MAX_ACTIVE, nombreAux);
            iminIdle = FileFunction.getPropertie(UtilDefines.MIN_IDLE, nombreAux);
            imaxIdle = FileFunction.getPropertie(UtilDefines.MAX_IDLE, nombreAux);
            iinitialSize = FileFunction.getPropertie(UtilDefines.INITIAL_SIZE, nombreAux);
            System.out.println("Parametros del pool, leyendo...");
            System.out.println("DATOS DE CONEXION : \nMAX_ACTIVE: " + imaxActive + "\nMIN_IDLE: " + iminIdle + "\nMAX_IDLE: " + imaxIdle + "\nINITIAL_SIZE: " + iinitialSize);
        }
        if (conn == null && url != null && user != null && pass != null && drive != null && con != null) {
            //conn = SQLConexion.crearConexion(url, user, pass, drive);
            conn = JavaPoolConexion.crearConexion(url, user, pass, drive, imaxActive, iminIdle, imaxIdle, iinitialSize);
            System.out.println("creando conexion " + conn);
        }
        if(conn != null){
            System.out.println("ya existe la conexion retornando..." + conn);
        }
        return conn;
    }
}
