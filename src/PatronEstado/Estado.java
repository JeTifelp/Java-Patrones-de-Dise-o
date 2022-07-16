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
public class Estado {
    protected EstadoVehiculo estadoVehiculo;
    private String   estadoActual = "";
    private String   mensaje      = "";

    public Estado( EstadoVehiculo estado) {
        this.estadoVehiculo = estado;
    }
    public Estado( String estadoActual, String mensaje) {        
        this.estadoActual  = estadoActual;
        this.mensaje = mensaje;
    }
    
    public void setEstado(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public void setEstadoActual(String estado) {
        this.estadoActual = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstadoActual() {
        return this.estadoActual;
    }

    public EstadoVehiculo getEstado() {
        return this.estadoVehiculo;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
    
}
