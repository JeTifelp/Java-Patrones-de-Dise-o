/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DMecanico;
import Datos.PatronPlantilla.ListarPorID;
import Datos.PatronPlantilla.ListarTodos;
import java.util.ArrayList;

/**
 *
 * @author JeTf
 */
public class NMecanico {
    private DMecanico dmecanico;

    public NMecanico() {
       // this.dmecanico = new DMecanico();
       this.dmecanico = new ListarPorID();
    }
    public void agregar(String nombre,String apPaterno,String apMaterno, int celular, int idEspecialidad){
        this.dmecanico.setNombre(nombre);
        this.dmecanico.setApPaterno(apPaterno);
        this.dmecanico.setApMaterno(apMaterno);
        this.dmecanico.setCelular(celular);
        this.dmecanico.setIdEspecialidad(idEspecialidad);        
        this.dmecanico.agregar();
    }
    public void eliminar(int id){
        this.dmecanico.setIdMecanico(id);
        this.dmecanico.eliminar();
    }
    public ArrayList listar(){
       // return this.dmecanico.listar();
       dmecanico = new ListarTodos();
       return this.dmecanico.MetodoTemplate_listar();               
    }
    public ArrayList listar(int idmecanico){
        this.dmecanico.setIdMecanico(idmecanico);
        return this.dmecanico.MetodoTemplate_listar();
    }
    public void modificar(int id,String nombre, String apPaterno,String apMaterno, int celular, int idEspecialidad){
        this.dmecanico.setIdMecanico(id);
        this.dmecanico.setNombre(nombre);
        this.dmecanico.setApPaterno(apPaterno);
        this.dmecanico.setApMaterno(apMaterno);
        this.dmecanico.setCelular(celular);
        this.dmecanico.setIdEspecialidad(idEspecialidad);        
        this.dmecanico.modificar();
    }
}
