/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.PatronPlantilla;

import Datos.DMecanico;

/**
 *
 * @author JeTf
 */
public class ListarTodos   extends DMecanico{

    @Override
    public void operacionListar() {
    this.sentenciaSQL = "SELECT *FROM mecanico";
    }
    
}
