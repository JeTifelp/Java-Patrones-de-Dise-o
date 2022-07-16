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
public class EnRevision implements EstadoVehiculo{
    @Override
    public void mantenimiento(Estado estado) {
        estado.setMensaje("Ya no Puedes estar en Mantenimiento");
        estado.setEstadoActual("Revision");
    }

    @Override
    public void reparacion(Estado estado) {
        estado.setEstado(new EnReparacion());
        estado.setMensaje("Ya estas en Reparación otra vez");   
        estado.setEstadoActual("Reparacion");
    }

    @Override
    public void revision(Estado estado) {
        estado.setMensaje("Ya estas en Revisión");
        estado.setEstadoActual("Revision");
    }

    @Override
    public void entregado(Estado estado) {
        estado.setEstado(new Entregado());
        estado.setMensaje("Ya fue entregado");
        estado.setEstadoActual("Entregado");
    }
}
