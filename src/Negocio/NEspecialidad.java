/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEspecialidad;
import java.util.ArrayList;

/**
 *
 * @author JeTf
 */
public class NEspecialidad {
    private DEspecialidad despecialidad;

    public NEspecialidad() {
        despecialidad= new DEspecialidad();
    }
    
    
    public void agregar(String nombre){
        this.despecialidad.setNombre(nombre);
        this.despecialidad.agregar();
    }
    public void eliminar(int id){
        this.despecialidad.setIdespecialidad(id);
        this.despecialidad.eliminar();
    }
    public ArrayList listar(){
        return this.despecialidad.listar();
    }
    public void modificar(int id, String nombre){
        this.despecialidad.setIdespecialidad(id);;
        this.despecialidad.setNombre(nombre);
        this.despecialidad.modificar();
    }
    
    
    
    
}
