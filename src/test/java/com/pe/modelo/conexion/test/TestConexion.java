/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.conexion.test;

import com.pe.interfaces.ICrud;
import com.pe.modelo.dao.UsuariosCrud;
import com.pe.modelo.dto.UsuariosDTO;
import com.pe.util.BussinessException;
import com.pe.util.UtilDefines;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbermudez
 */
public class TestConexion {

    public static void main(String args[]) {
        //IConexion connn = null;
        ICrud crud = null;
        File file = null;
        try {
            file = new File("");
            UtilDefines.PATH = file.getAbsolutePath();
            test(crud);
        } catch (BussinessException ex) {
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(connn);
    }

    public static void test(ICrud crud) throws BussinessException {
        crud = new UsuariosCrud();
        ArrayList<UsuariosDTO> users = (ArrayList<UsuariosDTO>) crud.consultarTodo();
        System.out.println(users.size());
    }
}
