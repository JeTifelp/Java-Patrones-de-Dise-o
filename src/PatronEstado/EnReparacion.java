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
public class EnReparacion  implements EstadoVehiculo{
    @Override
    public void mantenimiento(Estado estado) {
        estado.setMensaje("No puedes volver a estar en Mantenimiento");
        estado.setEstadoActual("Reparación");
    }

    @Override
    public void reparacion(Estado estado) {
        estado.setMensaje("Ya estas en Reparación");
        estado.setEstadoActual("Reparación");
    }

    @Override
    public void revision(Estado estado) {
        estado.setEstado(new EnRevision());
        estado.setMensaje("el Vehiculo  esta Revisión");
        estado.setEstadoActual("Revisión");
    }

    @Override
    public void entregado(Estado estado) {
        estado.setMensaje("Aún estas en Reparación, no Puedes cambiar a Entregado");
        estado.setEstadoActual("Reparación");
    }
}
