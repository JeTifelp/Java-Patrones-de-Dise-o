/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronProxy;

import java.util.ArrayList;

/**
 *
 * @author JeTf
 */
public interface ICliente {
    public void agregar(String nombre,String apPaterno,String apMaterno, String correoElectronico, int celular, String direccion);
    public void modificar(int id, String nombre,String apPaterno,String apMaterno, String correoElectronico, int celular, String direccion);
    public void eliminar(int id);
    public ArrayList listar();
}
