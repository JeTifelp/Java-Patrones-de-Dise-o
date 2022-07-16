/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCliente;
import PatronProxy.ICliente;
import java.util.ArrayList;

/**
 *
 * @author JeTf
 */
public class NCliente  implements ICliente{
    private DCliente dcliente;

    public NCliente() {
        this.dcliente = new DCliente();
    }
    @Override
    public void agregar(String nombre,String apPaterno,String apMaterno, String correoElectronico, int celular, String direccion){
        this.dcliente.setNombre(nombre);
        this.dcliente.setApPaterno(apPaterno);
        this.dcliente.setApMaterno(apMaterno);
        this.dcliente.setCorreoElectronico(correoElectronico);
        this.dcliente.setCelular(celular);
        this.dcliente.setDireccion(direccion);
        this.dcliente.agregar();
    }
    @Override
    public void eliminar(int id){
        this.dcliente.setIdCliente(id);
        this.dcliente.eliminar();
    }
    @Override
    public ArrayList listar(){
        return this.dcliente.listar();
    }
    @Override
    public void modificar(int id, String nombre,String apPaterno,String apMaterno, String correoElectronico, int celular, String direccion){
        this.dcliente.setIdCliente(id);
        this.dcliente.setNombre(nombre);
        this.dcliente.setApPaterno(apPaterno);
        this.dcliente.setApMaterno(apMaterno);
        this.dcliente.setCorreoElectronico(correoElectronico);
        this.dcliente.setCelular(celular);
        this.dcliente.setDireccion(direccion);
        this.dcliente.modificar();
    }
    
    
}
