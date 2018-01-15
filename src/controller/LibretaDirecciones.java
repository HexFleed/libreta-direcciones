/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.VistaPersonaController;

/**
 *
 * @author franp
 */
public class LibretaDirecciones extends Application{
    
    private ObservableList datosPersona = FXCollections.observableArrayList();
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaPersona;

    @Override
    public void start(Stage escenarioPrincipal) {
        
        this.escenarioPrincipal = escenarioPrincipal;
        
        this.escenarioPrincipal.setTitle("Libreta de Direcciones");
        
        initLayoutPrincipal();
        
        muestraVistaPersona();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Método para devolver los datos como lista observable de personas
    public ObservableList getDatosPersona() {
        return datosPersona;
    }
    
    private void initLayoutPrincipal(){
        
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDirecciones.class.getResource("../view/VistaPrincipal.fxml");
        loader.setLocation(location);
        
        try {
            layoutPrincipal = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //carga la escena que contiene ese layout principal.
        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    private void muestraVistaPersona() {
        
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDirecciones.class.getResource("../view/VistaPersona.fxml");
        loader.setLocation(location);
        
        try {
            vistaPersona = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        layoutPrincipal.setCenter(vistaPersona);
        
        //Doy acceso al controlador VistaPersonaCOntroller a LibretaDirecciones
        VistaPersonaController controller = loader.getController();
        controller.setLibretaDirecciones(this);
        
    }
    
    public Stage getPrimarystage(){
        return escenarioPrincipal;
    }
    
   
    
    
}
