/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author JeTf
 */
public class DCliente {
    private int idCliente;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String correoElectronico;
    private int    celular;
    private String direccion;
    
    private Conexion conexion;
    private Connection con;

    public DCliente() {
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void agregar(){
        conexion   = new Conexion();
        con        = conexion.conectar();
        PreparedStatement ps 
                   = null;
        String sql = "INSERT INTO cliente (nombre, appaterno, apmaterno, correoelectronico, celular, direccion) VALUES (?,?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);
            ps.setString(4, this.correoElectronico);
            ps.setInt(5, this.celular);
            ps.setString(6, this.direccion);
            ps.execute();
            System.out.println("Cliente Insertado exitosamente...");  
        } catch (Exception e) {
            System.out.println(" Error al Insertar Cliente... "+ e.getMessage());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
     public void eliminar(){
        conexion    = new Conexion();
        con         = conexion.conectar();
        PreparedStatement ps 
                    = null;
        String sql  = "DELETE FROM cliente WHERE idcliente="+this.idCliente;
         try {
             ps= con.prepareCall(sql);
             ps.execute();
             ps.close();
             System.out.println("Cliente Eliminado exitosamente...");
         } catch (Exception e) {
             System.out.println("Error al Elimar Cliente... ");
         }
     }
     
    public ArrayList listar(){
        conexion    = new Conexion();
        con         = conexion.conectar();
        PreparedStatement ps    = null;
        ArrayList<Object[]> cli = new ArrayList<>();
        String sql              = "SELECT *FROM cliente";
        try {
            ps= con.prepareCall(sql);
            ResultSet r;
            r= ps.executeQuery();
            while (r.next()) {                
                cli.add( new  Object[]{
                r.getInt(1),//id
                r.getString(2),//nombre
                r.getString(3),
                r.getString(4),
                r.getString(5),
                r.getInt(6),
                r.getString(7),//direccion
                });
                //System.out.println("lis "+ r.getInt(1)+" " +r.getString(2));
            }
           System.out.println("listando Clientes... "); 
        } catch (Exception e) {
            System.out.println("Error al listar....");
            return null;
        }
        return cli;
    } 
    public void modificar(){
        conexion   = new Conexion();
        con        = conexion.conectar();
        PreparedStatement ps 
                   = null;
        String sql = "UPDATE cliente SET nombre=?, appaterno=?, apmaterno=?, correoelectronico=?, celular=?, direccion=? WHERE idcliente="+this.idCliente;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);
            ps.setString(4, this.correoElectronico);
            ps.setInt(5, this.celular);
            ps.setString(6, this.direccion);
            ps.execute();
            ps.close();
            System.out.println("modificador exitosamente");
        } catch (Exception e) {
            System.out.println("error al modificar.."+e.getMessage());
        }
    } 
    
    
    
}
