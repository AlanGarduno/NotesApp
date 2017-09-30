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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author JCVELMON
 */
public class ViewLogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Metoto que se usa para cerrar la aplicacion, por medio de un evento
    @FXML
    private void handleClose( MouseEvent event ){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
