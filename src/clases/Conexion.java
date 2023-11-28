/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.*;

/**
 *
 * @author bm_vd
 */
public class Conexion {
    public static Connection conectar(){
        try {
            Connection cn =  DriverManager.getConnection("jdbc:mysql://localhost/bd_ds","root","");
            return cn;
        } catch (Exception e) {
            System.out.println(e);
        }
    return null;
    }
}
