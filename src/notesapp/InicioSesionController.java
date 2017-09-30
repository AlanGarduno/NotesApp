/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Modelos.Usuario;

/**
 * FXML Controller class
 *
 * @author JCVELMON
 */
public class InicioSesionController implements Initializable {

    @FXML private TextField txtMail;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnIniciar,btnSalir,btnRegistro;
    private Usuario user;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btnIniciar.setOnAction(event -> iniciarSesion(txtMail.getText(),txtPassword.getText()));
    }

    public void iniciarSesion(String mail, String pass){
       if(mail == "user" && pass == "123")
            System.out.println("Hola");
        System.out.println("Adios");
       //Falta metodo para iniciar sesion en Usuario
    }
    
    public void salir(){
        
    }
    
    public void cambioVista(){
        
    }
    
}
