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
public abstract class DMecanico {
   protected int    idMecanico;
   private String nombre;
   private String apPaterno;
   private String apMaterno;
   private int    celular;
   private int    idEspecialidad;
   
   private Conexion conexion;
   private Connection con;        
   protected String sentenciaSQL;
    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
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

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    

    public int getIdMecanico() {
        return idMecanico;
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

    public int getCelular() {
        return celular;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }
    
    public void agregar(){
        conexion   = new Conexion();
        con        = conexion.conectar();
        PreparedStatement ps 
                   = null;
        String sql = "INSERT INTO mecanico (nombre, appaterno, apmaterno, celular,idespecialidad) VALUES (?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);
            ps.setInt(4, this.celular);
            ps.setInt(5, this.idEspecialidad);
            ps.execute();
            System.out.println("Mecanico Insertado exitosamente...");  
        } catch (Exception e) {
            System.out.println(" Error al Insertar Mecanico... "+ e.getMessage());
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
        String sql  = "DELETE FROM mecanico WHERE idmecanico="+this.idMecanico;
         try {
             ps= con.prepareCall(sql);
             ps.execute();
             ps.close();
             System.out.println("Mecanico Eliminado exitosamente...");
         } catch (Exception e) {
             System.out.println("Error al Elimar Mecanico... ");
         }
     }
     
//    public ArrayList listar(){
//        conexion    = new Conexion();
//        con         = conexion.conectar();
//        PreparedStatement ps    = null;
//        ArrayList<Object[]> mec = new ArrayList<>();
//        String sql              = "SELECT *FROM mecanico";
//        try {
//            ps= con.prepareCall(sql);
//            ResultSet r;
//            r= ps.executeQuery();
//            while (r.next()) {                
//                mec.add( new  Object[]{
//                r.getInt(1),//id
//                r.getString(2),//nombre
//                r.getString(3),
//                r.getString(4),
//                r.getInt(5),
//                r.getInt(6)  //idEspecialidad              
//                });
//                //System.out.println("lis "+ r.getInt(1)+" " +r.getString(2));
//            }
//           System.out.println("listando Mecanicos... "); 
//        } catch (Exception e) {
//            System.out.println("Error al listar Mecanicos....");
//            return null;
//        }
//        return mec;
//    } 
    public void modificar(){
        conexion   = new Conexion();
        con        = conexion.conectar();
        PreparedStatement ps 
                   = null;
        String sql = "UPDATE mecanico SET nombre=?, appaterno=?, apmaterno=?, celular=?, idespecialidad=? WHERE idmecanico="+this.idMecanico;
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setString(2, this.apPaterno);
            ps.setString(3, this.apMaterno);            
            ps.setInt(4, this.celular);
            ps.setInt(5, this.idEspecialidad);
            ps.execute();
            ps.close();
            System.out.println("Mecanico modificado exitosamente");
        } catch (Exception e) {
            System.out.println("error al modificar.."+e.getMessage());
        }
    } 
    
    //===== Metodo Plantilla ===
   public ArrayList MetodoTemplate_listar(){
        conexion    = new Conexion();
        con         = conexion.conectar();
        PreparedStatement ps    = null;
        ArrayList<Object[]> mec = new ArrayList<>();
        //String sql              = "SELECT *FROM mecanico";
        this.operacionListar();
        try {
            ps= con.prepareCall(this.sentenciaSQL);
            ResultSet r;
            r= ps.executeQuery();
            while (r.next()) {                
                mec.add( new  Object[]{
                r.getInt(1),//id
                r.getString(2),//nombre
                r.getString(3),
                r.getString(4),
                r.getInt(5),
                r.getInt(6)  //idEspecialidad              
                });
                //System.out.println("lis "+ r.getInt(1)+" " +r.getString(2));
            }
           System.out.println("listando Mecanicos... "); 
        } catch (Exception e) {
            System.out.println("Error al listar Mecanicos....");
            return null;
        }
        return mec;
        
    }
   //== metodo Operacion de patron Plantilla ===
   public abstract void operacionListar();

   
    
}//fin class
