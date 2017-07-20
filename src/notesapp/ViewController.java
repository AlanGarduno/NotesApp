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
    @FXML private ListView<String> ListaNotas;
    
    private List<Note> notas;
    private List<String> resumen_de_notas;
    
    private ListProperty<String> propiedades_resumen_de_notas;
    
    private Note nota_actual; 
    
    private final String token = "S=s1:U=93df9:E=164b528cdd0:C=15d5d779f78:P=1cd:A=en-devtoken:V=2:H=b5f0ceca2dcd67cb05dc8a378e195fe8";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resumen_de_notas = new ArrayList<>();
        notas = new ArrayList<>();
        propiedades_resumen_de_notas = new SimpleListProperty<>(FXCollections.observableArrayList(resumen_de_notas));
        ListaNotas.itemsProperty().bind(propiedades_resumen_de_notas);
        
          btnDelete.setOnAction(event -> {
            
            //int i = (-1);
            for(int i=nota_actual.position+1;i<notas.size();i++){
                Note note = notas.get(i);
                note.position = notas.get(i).position - 1;
            }
            notas.remove(nota_actual);
            propiedades_resumen_de_notas.remove(nota_actual.position);
            if(notas.size() == 0){
                nuevaNota();
            }else{
                nota_actual = notas.get(0);
            }
            selectNote();
            
        });
        
        ContenidoPrincipal.textProperty().addListener((ObservableValue<? extends String> av, String oldValue, String newValue) ->{
        
               nota_actual.change(newValue);
               propiedades_resumen_de_notas.set(nota_actual.position,nota_actual.resumen());
        });
        
        
        
       btnAdd.setOnAction(event -> nuevaNota());
        
        ListaNotas.setOnMouseClicked(event -> {
            int index = ListaNotas.getSelectionModel().getSelectedIndex();
            nota_actual = notas.get(index);
            selectNote();
        });
        
        
        nuevaNota();
        initEvernote();
    }    
    
    public void initEvernote(){
        try{
        Evernote evernote = new Evernote(this.token);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void nuevaNota(){
         nota_actual = new Note();
         notas.add(nota_actual);
         nota_actual.position = notas.size() -1;
        propiedades_resumen_de_notas.add(nota_actual.resumen());
        selectNote();
        
    }
    
    public void selectNote(){
       ContenidoPrincipal.setText(nota_actual.get());
    }
    
}
