/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JCVELMON
 */
public class ViewLogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Variables de la vista
    private JFXButton btnIniciar, btnRegistrar;
    private JFXTextField txtCorreo;
    private JFXPasswordField txtPass;
    @FXML 
    private Label lblError;
    //Metodo que se usa para cerrar la aplicacion, por medio de un evento
    @FXML
    private void handleClose( MouseEvent event ){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtCorreo = new JFXTextField();
        txtPass = new JFXPasswordField();
    }

    //Metodos para la funcionalidd de los botones
   
    /*Método iniciar Sesion:
    Recibe como parametro 2 String el Correo y el Mail.
    Ejecuta un método del modelo Usuario que hace toda
    la logica de loggeo
    */
    @FXML
    private void iniciarSesion( ActionEvent event ) throws IOException{
     try{
        if("123".equals(txtPass.getText()) && txtCorreo.getText().equals("user")){
            //((Node)event.getSource()).getScene().getWindow().hide(); //Hide this view
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
            Parent page = loader.load();         
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else{
            System.out.println(txtCorreo.getText());
            System.out.println(txtPass.getText());
            lblError.setText("Correo o contraseña incorrectos");
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /*Metodo goToRegistro
    Método que envia al formulario de registro
    */
    private void goToRegistro(){
        
    }
    
   
}
