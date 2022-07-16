/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JeTf
 */
public class Conexion {
    private Connection con;
    private String pass="admin";
    private String URL="jdbc:postgresql://127.0.0.1/tallerMec_arquitectura_db";
    private String user="postgres"; 
    
    //mysql
//    private Connection con;
//    private String pass="";
//    private String URL="jdbc:mysql://localhost:3306/tallermec_arquitectura_db";
//    private String user="root"; 
    
//    private Connection con;
//    private String pass="y6QdzaV34ubPzEb7zagE";
//    private String URL="jdbc:postgresql://127.0.0.1/tallerMec_arquitectura_db";
//    private String user="u1hxzi9chroh7sp9pw7j"; 

    public Conexion() {
    }
    public Connection conectar(){
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");//mysql
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection(URL,this.user,this.pass);
        } catch (ClassNotFoundException | SQLException e) {
                            System.out.println("Error conectar Postgres... "+e.getMessage());
        }
        return con;
    }
}
