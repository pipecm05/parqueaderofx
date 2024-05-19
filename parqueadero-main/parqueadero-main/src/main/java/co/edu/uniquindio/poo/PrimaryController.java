package co.edu.uniquindio.poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    public int filas;
    public int columnas;

    @FXML
    private Button boton_crearParqueadero;

    @FXML
    private TextField txt_columnas;

    @FXML
    private TextField txt_filas;
    
    @FXML
    void accion_crearParqueadero(ActionEvent event) throws IOException {
        //APP.SETROOT PARA CARGAR LA SEGUNDA VISTA 
        App.setRoot("secondary");

        //SE OBTIENEN LAS FILAS Y COLUMNAS PARA CREAR EL PARQUEADERO 
        filas = Integer.parseInt(txt_filas.getText());
        columnas = Integer.parseInt(txt_columnas.getText());
        Parqueadero parqueadero = new Parqueadero();
        //parqueadero.recibirFIlasColumnas(filas, columnas );
        System.out.println("parqueadero creado de " + filas + "x" + columnas);
    }

}
