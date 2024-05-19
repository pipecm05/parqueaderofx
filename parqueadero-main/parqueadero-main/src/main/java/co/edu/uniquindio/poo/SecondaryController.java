package co.edu.uniquindio.poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDateTime;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//investiguen esta implementacion "initializable"
public class SecondaryController implements Initializable {

    public double tarifaMotoClasica;
    public double tarifaMotoHibrida;
    public double tarifaCarro;

    String cadena = "";
    Parqueadero par = new Parqueadero();
    PrimaryController primary = new PrimaryController();

    @FXML
    private Button boton_registrar;

    @FXML
    private ComboBox<TipoMoto> combo_tipoMoto;

    @FXML
    private ComboBox<Vehiculo> combo_tipoVehiculo;

    @FXML
    private TextField txt_cedula;

    @FXML
    private TextField txt_modeloMoto;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_velocidadMaxima;

    @FXML
    private TextField txt_placa;

    @FXML
    private TextField txt_placaCarro;

    @FXML
    private TextField txt_modeloCarro;

    @FXML
    private Button boton_registrarCarro;

    @FXML
    private TextField txt_tiempoDeUso;

    @FXML
    private Button boton_actualizarPrecios;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button boton_RevisarIngresos;

    @FXML
    private Button boton_De_Registros;

    @FXML
    private TextField txt_posicion_I;

    @FXML
    private TextField txt_posicion_J;

    // METODO PARA RECIBIR LAS 3 TARIFAS DE PRIMARYCONTROLLER
    public double recibir_tarifas(double t1, double t2, TipoMoto tipo, int tiempouso) {

        this.tarifaMotoClasica = t1;
        this.tarifaMotoHibrida = t2;

        if (tipo.equals(TipoMoto.CLASICA)) {
            double total = tarifaMotoClasica * tiempouso;
            System.out.println("la moto clasica debe pagar : " + total);
            return total;
        } else {
            double total = tarifaMotoHibrida * tiempouso;
            System.out.println("la moto hibrida debe pagar :" + total);
            return total;
        }

    }

    @FXML
    void accion_registrarMoto(ActionEvent event) throws IOException {

        System.out.println("---------------------------------------------------------------------------------------");
        double totalPagar;
        tarifaMotoClasica = 1000;
        tarifaMotoHibrida = 1500;
        int pos1 ;
        int pos2;

        String nombre = txt_nombre.getText();
        String cedula = txt_cedula.getText();
        Propietario p1 = new Propietario(nombre, cedula, null);

        TipoMoto tipoMoto = combo_tipoMoto.getSelectionModel().getSelectedItem();
        String placa = txt_placa.getText();
        int velocidaMaxima = Integer.parseInt(txt_velocidadMaxima.getText());
        String modeloVehiculo = txt_modeloMoto.getText();

        Moto m1 = new Moto(placa, modeloVehiculo, p1, velocidaMaxima);

        par.agregarMoto(m1);
        par.imprimirListaMotos();

        int tiempoDeUso = Integer.parseInt(txt_tiempoDeUso.getText());

        if (tipoMoto.equals(TipoMoto.CLASICA)) {
            totalPagar = tiempoDeUso * tarifaMotoClasica;
        } else {
            totalPagar = tiempoDeUso * tarifaMotoHibrida;
        }


        int posicion_i = Integer.parseInt(txt_posicion_I.getText());
        int posicion_J = Integer.parseInt(txt_posicion_J.getText());

        String auxi = posicion_i + "" + posicion_J;
        int posicion = Integer.parseInt(auxi);



        txtArea.setText("COMPROBANTE :" + "\n " + "Nombre propietario : " + nombre + "\n" + cedula + "\n" + tipoMoto + "\n" +
         placa + "\n" + velocidaMaxima + "\n" + modeloVehiculo + "\n"+ totalPagar + "\n" + posicion);

        //CREACION DEL REGISTRO DE UNA MOTO
        Registro registro = new Registro(m1, totalPagar, posicion, LocalDateTime.now(), p1.getIdentificacion());
        //AGREGO EL REGISTRO A LA LISTA EN PARQUEADERO

        Puesto puesto = new Puesto(posicion, registro);

        par.agregarRegistro(puesto, posicion_i, posicion_J);

    

    }


    @FXML
    void acccion_registrarCarro(ActionEvent event) throws IOException {

        tarifaCarro = 2000;
        //ASIGNACION DE NOMBRE Y CEDULA , SEGUN LA INFORMACION QUE SE COLOCA EN LOS CAMPOS 
        String nombre = txt_nombre.getText();
        String cedula = txt_cedula.getText();
        // CREACION DEL PROPIETARIO DEL CARRO
        Propietario p2 = new Propietario(nombre, cedula, null);

        //ASIGNACION DE PLACA Y MODELO , SEGUN LA INFORMACION QUE SE COLOCA EN LOS CAMPOS 
        String placaCarro = txt_placaCarro.getText();
        String modeloCarro = txt_modeloCarro.getText();
        // CREACION DEL CARRO
        Carro c1 = new Carro(placaCarro, modeloCarro, p2);
        par.agregarCarro(c1);
        par.imprimirListaCarros();

        int tiempoDeUso = Integer.parseInt(txt_tiempoDeUso.getText());

        //TOTAL A PAGAR , CALCULO ENTRE LA TARIFA DE CARRO Y EL TIEMPO QUE USARA EL PARQUEADERO
        double totalPagar = tarifaCarro * tiempoDeUso;

        int posicion_i = Integer.parseInt(txt_posicion_I.getText());
        int posicion_J = Integer.parseInt(txt_posicion_J.getText());

        String auxi = posicion_i + "" + posicion_J;
        int posicion = Integer.parseInt(auxi);

        //USO DEL TEXTFIELAREA PARA CARGAR LOS DATOS RECIEN AGREGADOS
        txtArea.setText("COMPROBANTE :" + "\n " + nombre + "\n" + cedula + "\n" + "\n" + placaCarro + "\n" + 
         "\n" + modeloCarro + "\n" + totalPagar + "\n" + posicion);

         //CREACION DE EL REGISTRO DE CARRO
         Registro registro = new Registro(c1, totalPagar, posicion, LocalDateTime.now(), p2.getIdentificacion());
         //AGREGO EL REGISTRO A LA LISTA EN PARQUEADERO
         par.agregarRegistros(registro);

         Puesto puesto = new Puesto(posicion, registro);

         par.agregarRegistro(puesto, posicion_i, posicion_J);
        

    }

    // METODO SOBREESCRITO DE LA IMPLEMENTACION DE LA CLASE INITIALIZABLE
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //INICIALIZACION DEL COMBOBOX CON LOS DOS TIPOS DE MOTOS DE LA CLASE "TIPOMOTO" 
        ObservableList<TipoMoto> list = FXCollections.observableArrayList(TipoMoto.values());
        combo_tipoMoto.setItems(list);
    }


    @FXML
    void accion_actualizarprecios(ActionEvent event) {
    }



    //ACCION DEL BOTON PARA REVISAR LOS INGRESOS QUE LLEVA EL PARQUEADERO
    @FXML
    void accion_RevisarIngresos(ActionEvent event) {

        String cadenaIngresosTotales = "el total recaudado es : ";
        String cadenaIngresosMotos = "el total recaudado con motos es :";
        String cadenaIngresosCarros = "el total recaudado con carros es : ";
        
        double totalMotos =  par.mostrarIngresosMotos();
        double totalCarros = par.mostrarIngresosCarros();
        double total = totalCarros + totalMotos;
        
        txtArea.setText(cadenaIngresosTotales + total + " \n " + cadenaIngresosMotos + totalMotos + 
        " \n " + cadenaIngresosCarros + totalCarros);
    }

    @FXML
    void accion_mostrarRegistros(ActionEvent event) {

        String cadena = par.imprimirRegistros();
        txtArea.setText(cadena);
    }

}