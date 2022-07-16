/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronProxy;

import Negocio.NCliente;
import java.util.ArrayList;

/**
 *
 * @author JeTf
 */
public class ClienteProxy implements ICliente{
    private NCliente ncliente;    

    public ClienteProxy() {
        ncliente= new  NCliente();
    }

        
    @Override
    public void agregar(String nombre, String apPaterno, String apMaterno, String correoElectronico, int celular, String direccion) {
        ncliente.agregar(nombre, apPaterno, apMaterno, correoElectronico, celular, direccion);
    }

    @Override
    public void modificar(int id, String nombre, String apPaterno, String apMaterno, String correoElectronico, int celular, String direccion) {
        ncliente.modificar(id, nombre, apPaterno, apMaterno, correoElectronico, celular, direccion);
    }

    @Override
    public void eliminar(int id) {
        ncliente.eliminar(id);
    }

    @Override
    public ArrayList listar() {
        return ncliente.listar();
    }
    
}
