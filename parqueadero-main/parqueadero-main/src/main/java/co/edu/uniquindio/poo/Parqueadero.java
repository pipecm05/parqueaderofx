package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Parqueadero {
    private String nombre;
    Puesto[][] parqueadero = new Puesto[20][20];

    private Collection<Registro> listaRegistros = new ArrayList<>();
    private Collection<Moto> listaMotos = new ArrayList<>();
    private Collection<Carro> listaCarros = new ArrayList<>();
    private Collection<Vehiculo> vehiculos = new ArrayList<>();

    private Double tarifaHora;

    public Parqueadero(String nombre, Collection<Vehiculo> vehiculos, Puesto[][] parqueadero,
            Collection<Registro> listaRegistros) {
        this.nombre = nombre;
        this.vehiculos = vehiculos;
        //this.parqueadero = parqueadero;
        this.listaRegistros = listaRegistros;
        this.listaCarros = new ArrayList<>(); // Inicializar la lista de carros
        this.listaMotos = new ArrayList<>(); // Inicializar la lista de motos
    }

    // CONSTRUCTOR VACIO
    public Parqueadero() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Registro> getRegistros() {
        return listaRegistros;
    }

    public void setRegistros(Collection<Registro> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public Double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(Double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }




    //METODO PARA AGREGAR CARROS A LA LISTA
    public void agregarCarro(Carro carro) {
        listaCarros.add(carro); // Agrega el objeto de tipo Carro a la colección listaCarros
    }

    //METODO PARA AGREGAR MOTOS A LA LISTA
    public void agregarMoto(Moto moto) {
        listaMotos.add(moto); // Agrega el objeto de tipo moto a la colección listaCarros
    }

    //METODO PARA AGREGAR UN REGISTRO A LA LISTA DE REGISTROS
    public void agregarRegistros(Registro registro){
        listaRegistros.add(registro);
    }

    //IMPRIME LOS REGISTROS
    public String imprimirRegistros(){
        String cadena = " \n ";
        /*
         * Moto moto, double ingresosMotos, int puestoOcupado, LocalDateTime horaIngreso, String idPropietario
         */
        Moto moto;
        Carro carro;
        double ingresosTotales;
        double ingresosMotos;
        double ingresosCarros;
        int puesto;
        String idPropi;

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Registros actuales: ");
        for (Registro registro : listaRegistros) {
            moto = registro.getMoto();
            carro = registro.getCarro();
            ingresosTotales = registro.getIngresos();
            ingresosMotos = registro.getIngresosMotos();
            ingresosCarros = registro.getIngresosCarros();
            puesto = registro.getPuestoOcupado();
            idPropi = registro.getIdPropietario();
            System.out.println("\n");
            System.out.println(moto  + "\n" + carro + "\n" + ingresosTotales + "\n" + ingresosMotos + "\n" +  ingresosCarros + 
            "\n" + puesto + "\n" + idPropi + "\n" + LocalDateTime.now()); // Imprime cada objeto registro en la colección
        }
        return cadena;
    }

    //METODO PARA IMPRIMIR LA LISTA DE CARROS 
    public void imprimirListaCarros() {
        System.out.println("Carros actuales :");
        for (Carro carro : listaCarros) {
            System.out.println("");
            System.out.println(carro); // Imprime cada objeto Carro en la colección
        }
    }

    //METODO PARA IMPRIMIR LA LISTA DE MOTOS 
    public void imprimirListaMotos() {
        System.out.println("-----Motos actuales : ------");
        for (Moto moto : listaMotos) {
            System.out.println("");
            System.out.println(moto); // Imprime cada objeto moto en la colección
        }
    }

    //MOSTRAR LOS INGRESOS GENERADOS POR CARROS
    public double mostrarIngresosCarros(){

        double totalPagar =0;

        for (Registro registro : listaRegistros) {
            
            totalPagar += registro.getIngresosCarros();
        }
    
        return totalPagar;
    }

    //MOSTRAR LOS INGRESOS GENERADOS POR MOTOS
    public double mostrarIngresosMotos(){

        double totalPagar =0;

        for (Registro registro : listaRegistros) {
            totalPagar += registro.getIngresosMotos();
        }
        return totalPagar;

    }

    public void agregarRegistro(Puesto puesto, int filas, int columnas) {
        for (int i = filas; i < parqueadero.length; i++) {
            for (int j = columnas; j < parqueadero[i].length; j++) {
                if (parqueadero[filas][columnas] == null) {
                    parqueadero[filas][columnas] = puesto;
                    System.out.println("Puesto agregado con éxito en la posición [" + i + "][" + j + "]");
                    return; // Salir del método después de agregar el puesto
                } else {
                    System.out.println("El puesto está ocupado en la posición [" + i + "][" + j + "]");
                    
                }
                break;
            }
            break;
        }
    }



}
