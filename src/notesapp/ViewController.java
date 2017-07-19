/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
    @FXML private ListView ListaNotas;
    
    private List<Note> notas;
    private List<String> resumen_de_notas;
    
    private ListProperty<String> propiedades_resumen_de_notas;
    
    private Note nota_actual; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resumen_de_notas = new ArrayList<>();
        notas = new ArrayList<>();
        propiedades_resumen_de_notas = new SimpleListProperty<>(FXCollections.observableArrayList(resumen_de_notas));
        ListaNotas.itemsProperty().bind(propiedades_resumen_de_notas);
        
        
        nuevaNota();
        
        ContenidoPrincipal.textProperty().addListener((ObservableValue<? extends String> av, String oldValue, String newValue) ->{
        
               nota_actual.change(newValue);
        });
    }    
    
    public void nuevaNota(){
         nota_actual = new Note();
         notas.add(nota_actual);
        propiedades_resumen_de_notas.add(nota_actual.resumen());
        
    }
    
}
