package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Collection;

public class Registro {
   
    private Collection<Puesto> puestos;
    private Carro carro;
    private Moto moto;
    private double ingresos;
    private double ingresosMotos;
    private double ingresosCarros;
    private int puestoOcupado;
    private LocalDateTime horaIngreso;
    private String idPropietario;

    //CONSTRUCTOR 
    public Registro(Collection<Puesto> puestos, Carro carro , Moto moto, double ingresos, int puestoOcupado,
            LocalDateTime horaIngreso, String idPropietario) {
        this.puestos = puestos;
        this.carro = carro;
        this.moto = moto;
        this.ingresos = ingresos;
        this.puestoOcupado = puestoOcupado;
        this.horaIngreso = horaIngreso;
        this.idPropietario = idPropietario;
    }

    //CONSTRUCTOR PARA HACER UN REGISTRO DE UNA MOTO
    public Registro(Moto moto, double ingresosMotos, int puestoOcupado, LocalDateTime horaIngreso, String idPropietario) {
        this.moto = moto;
        this.ingresosMotos = ingresosMotos;
        this.puestoOcupado = puestoOcupado;
        this.horaIngreso = horaIngreso;
        this.idPropietario = idPropietario;
    }

    //CONSTRUCTOR PARA HACER UN REGISTRO DE UN CARRO
    public Registro(Carro carro, double ingresosCarros, int puestoOcupado, LocalDateTime horaIngreso, String idPropietario) {
        this.carro = carro;
        this.ingresosCarros = ingresosCarros;
        this.puestoOcupado = puestoOcupado;
        this.horaIngreso = horaIngreso;
        this.idPropietario = idPropietario;
    }


    //GETTERS Y SETTERS
    public Collection<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(Collection<Puesto> puestos) {
        this.puestos = puestos;
    }
    
    public double getIngresos() {
        return ingresos;
    }
    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
    public int getPuestoOcupado() {
        return puestoOcupado;
    }
    public void setPuestoOcupado(int puestoOcupado) {
        this.puestoOcupado = puestoOcupado;
    }
    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }
    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
    public String getIdPropietario() {
        return idPropietario;
    }
    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }
    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public Moto getMoto() {
        return moto;
    }
    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public double getIngresosMotos() {
        return ingresosMotos;
    }

    public void setIngresosMotos(double ingresosMotos) {
        this.ingresosMotos = ingresosMotos;
    }

    public double getIngresosCarros() {
        return ingresosCarros;
    }

    public void setIngresosCarros(double ingresosCarros) {
        this.ingresosCarros = ingresosCarros;
    }

    public char charAt(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charAt'");
    }

    
   
}