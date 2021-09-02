/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.util;

import java.sql.*;

/**
 *
 * @author Manu
 */
public class ConexionBaseDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/mi_muebleria";
    private static final String USERNAME = "root2";
    private static final String PASSWORD = "1234";

    /**
     * Metodo para crear una conexion hacia la base de datos
     * @return Retorna una conexion para utilizar la base de datos
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
