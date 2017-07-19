/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author AGV
 */
public class Note {
    
    public SimpleStringProperty texto, resumen;
    
    public Note(){
        
        this.texto = new SimpleStringProperty("");
        this.resumen = new SimpleStringProperty();
             
    }
}
