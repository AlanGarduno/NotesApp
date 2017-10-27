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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author JCVELMON
 */
public class ViewSingInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private JFXButton btnAtras, btnRegistro;
    @FXML private JFXTextField txtCorreo;
    @FXML private JFXPasswordField txtPass, txtConfPass;
    
    @FXML
    private void handleClose( MouseEvent event ){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnRegistro.setOnAction(event -> registrar());
    }
    @FXML
    private void registrar(){
        
    }
    @FXML
    private void goToLogIn(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide(); //Hide this view
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLogIn.fxml"));
        Parent page = loader.load();         
        Scene scene = new Scene(page);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
