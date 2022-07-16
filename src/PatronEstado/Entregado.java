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
public class Entregado implements EstadoVehiculo{
    @Override
    public void mantenimiento(Estado estado) {
        estado.setEstado(new EnMantenimiento());
        estado.setMensaje("Ya estas en Mantenimiento nuevamente");
        estado.setEstadoActual("Mantenimiento");
    }

    @Override
    public void reparacion(Estado estado) {
        estado.setMensaje("no puedes Cambiar a Reparación");
        estado.setEstadoActual("Entregado");
    }

    @Override
    public void revision(Estado estado) {
        estado.setMensaje("no puedes cambia a Revisión");
        estado.setEstadoActual("Entregado");
        
    }

    @Override
    public void entregado(Estado estado) {
        estado.setMensaje("Ya fuiste entregado");
        estado.setEstadoActual("Entregado");
    }
}
