package co.edu.uniquindio.poo;

import java.util.Collection;

public class Propietario {
    private String nombre;
    private String identificacion;
    private Collection <Vehiculo> vehiculos;
    
    public Propietario(String nombre, String identificacion, Collection<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.vehiculos = vehiculos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    @Override
    public String toString() {
        return "Propietario [nombre=" + nombre + ", identificacion=" + identificacion + ", vehiculos=" + vehiculos
                + "]";
    }
    

    
}
