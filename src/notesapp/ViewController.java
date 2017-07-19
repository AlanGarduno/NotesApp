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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author AGV
 */
public class ViewController implements Initializable {

    
    @FXML private Button btnDelete,btnAdd;
    @FXML private TextArea ContenidoPrincipal;
    @FXML private ListView ListaDeNotas;
    
    
    
    
    private Note nota_actual; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
