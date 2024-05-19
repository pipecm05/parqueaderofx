package co.edu.uniquindio.poo;

public class Puesto {
    private int numeroPuesto;
    private Registro registro;

    public Puesto(int numeroPuesto, Registro registro) {
        this.numeroPuesto = numeroPuesto;
        this.registro = registro;
    }

    private boolean ocupado;
    private Vehiculo vehiculo;

    public boolean isOcupado() {
        return ocupado;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
