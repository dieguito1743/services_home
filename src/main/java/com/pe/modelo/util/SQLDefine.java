/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.modelo.util;

/**
 *
 * @author dbermudez
 */
public class SQLDefine {

    public static final String POSTGRESQL = "postgresql";
    public static final String SQLSERVER = "sqlserver";
    public static final String ORACLE = "oracle";
    public static final String MYSQL = "mysql";
    public static final String MODULOS_SQL_INSERT = "INSERT "
            + "INTO modulos "
            + "(nombremodulo, nivelesmodulo, page) "
            + "VALUES (?,?,?) ";
    public static final String MODULOS_SQL_UPDATE = "UPDATE "
            + "modulos "
            + "SET nombremodulo = ?, nivelesmodulo = ?, page = ? "
            + "WHERE idmodulo = ? ";
    public static final String MODULOS_SQL_SELECT = "SELECT "
            + "idmodulo, nombremodulo, nivelesmodulo, page "
            + "FROM modulos "
            + "WHERE idmodulo = ? ";
    public static final String MODULOS_SQL_CONSULTAR_TODO = "SELECT "
            + "idmodulo, nombremodulo, nivelesmodulo, page "
            + "FROM modulos ";
    public static final String RECIBOS_SQL_INSERT = "INSERT "
            + "INTO recibos "
            + "(idusuario_servicio, idservicio, periodorecibo, medicioninicial, medicionfinal, fechami, fechamf, montorecibo, consumorecibo, preciounidad, fechavencimiento, estadorecibo) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
    public static final String RECIBOS_SQL_UPDATE = "UPDATE "
            + "recibos "
            + "SET idusuario_servicio = ?, idservicio = ?, periodorecibo = ?, medicioninicial = ?, medicionfinal = ?, fechami = ?, fechamf = ?, montorecibo = ?, consumorecibo = ?, preciounidad = ?, fechavencimiento = ?, estadorecibo  = ? "
            + "WHERE idrecibo = ? ";
    public static final String RECIBOS_SQL_SELECT = "SELECT "
            + "idrecibo, idusuario_servicio, idservicio, periodorecibo, medicioninicial, medicionfinal, fechami, fechamf, montorecibo, consumorecibo, preciounidad, fechavencimiento, estadorecibo "
            + "FROM recibos "
            + "WHERE idrecibo = ? ";
    public static final String RECIBOS_SQL_CONSULTAR_TODO = "SELECT "
            + "idrecibo, idusuario_servicio, idservicio, periodorecibo, medicioninicial, medicionfinal, fechami, fechamf, montorecibo, consumorecibo, preciounidad, fechavencimiento, estadorecibo "
            + "FROM recibos ";
    public static final String ROLES_SQL_INSERT = "INSERT "
            + "INTO roles "
            + "(idusuario, idmodulo, nivelmodulo) "
            + "VALUES (?,?,?) ";
    public static final String ROLES_SQL_UPDATE = "UPDATE "
            + "roles "
            + "SET idusuario = ?, idmodulo = ?, nivelmodulo = ? "
            + "WHERE idrol = ? ";
    public static final String ROLES_SQL_SELECT = "SELECT "
            + "idrol, idusuario, idmodulo, nivelmodulo "
            + "FROM roles "
            + "WHERE idrol = ? ";
    public static final String ROLES_SQL_CONSULTAR_TODO = "SELECT "
            + "idrol, idusuario, idmodulo, nivelmodulo "
            + "FROM roles ";
    public static final String SERVICIOS_SQL_INSERT = "INSERT "
            + "INTO servicios "
            + "(nombreservicio, fecharegistroservicio, fechaaltaservicio, estadoservicio, descripcion ) "
            + "VALUES (?,?,?,?,?) ";
    public static final String SERVICIOS_SQL_UPDATE = "UPDATE "
            + "servicios "
            + "SET nombreservicio = ? , fecharegistroservicio = ? , fechaaltaservicio = ? , estadoservicio = ? , descripcion = ? "
            + "WHERE idservicio = ? ";
    public static final String SERVICIOS_SQL_SELECT = "SELECT "
            + "idservicio, nombreservicio, fecharegistroservicio, fechaaltaservicio, estadoservicio, descripcion "
            + "FROM servicios "
            + "WHERE idservicio = ? ";
    public static final String SERVICIOS_SQL_CONSULTAR_TODO = "SELECT "
            + "idservicio, nombreservicio, fecharegistroservicio, fechaaltaservicio, estadoservicio, descripcion "
            + "FROM servicios ";
    public static final String USUARIOS_SQL_INSERT = "INSERT "
            + "INTO usuarios1 "
            + "(tipousuario, nombreusuario, apellidousuario, accusuario, passusuario, telefonousuario, correousuario ) "
            + "VALUES (?,?,?,?,?,?,?) ";
    public static final String USUARIOS_SQL_UPDATE = "UPDATE "
            + "usuarios1 "
            + "SET tipousuario = ? , nombreusuario = ? , apellidousuario = ? , accusuario = ? , passusuario = ?, telefonousuario = ?, correousuario = ? "
            + "WHERE idusuario = ? ";
    public static final String USUARIOS_SQL_SELECT = "SELECT "
            + "idusuario, tipousuario, nombreusuario, apellidousuario, accusuario, passusuario, telefonousuario, correousuario "
            + "FROM usuarios1 "
            + "WHERE idusuario = ? ";
    public static final String USUARIOS_SQL_CONSULTAR_TODO = "SELECT "
            + "idusuario, tipousuario, nombreusuario, apellidousuario, accusuario, passusuario, telefonousuario, correousuario "
            + "FROM usuarios1 ";
    public static final String USUARIOS_SERVICIOS_SQL_INSERT = "INSERT "
            + "INTO usuarios_servicios "
            + "(idservicio, idusuario, fechainicio, fechaalta, estado ) "
            + "VALUES (?,?,?,?,?) ";
    public static final String USUARIOS_SERVICIOS_SQL_UPDATE = "UPDATE "
            + "usuarios_servicios "
            + "SET idservicio = ? , idusuario = ? , fechainicio = ? , fechaalta = ? , estado = ? "
            + "WHERE idusuario = ? ";
    public static final String USUARIOS_SERVICIOS_SQL_SELECT = "SELECT "
            + "idusuario, idservicio, idusuario, fechainicio, fechaalta, estado "
            + "FROM usuarios_servicios "
            + "WHERE idusuario_servicio = ? ";
    public static final String USUARIOS_SERVICIOS_SQL_CONSULTAR_TODO = "SELECT "
            + "idusuario, idservicio, idusuario, fechainicio, fechaalta, estado "
            + "FROM usuarios_servicios ";
}
