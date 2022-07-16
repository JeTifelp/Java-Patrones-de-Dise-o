/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronEstado;

/**
 *
 * @author JeTf
 */
public interface EstadoVehiculo {
    public void mantenimiento(Estado estado);
    public void reparacion(Estado estado);
    public void revision(Estado estado);
    public void entregado(Estado estado);
}
