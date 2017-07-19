/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notesapp;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author AGV
 */
public class Note {
    
    public SimpleStringProperty texto, resumen;
    
    public Note(){
        
        this.texto = new SimpleStringProperty("");
        this.resumen = new SimpleStringProperty();
        
        texto.addListener((ObservableValue<? extends String> av, String oldValue, String newValue) ->{
        
                this.resumen.set(texto.get().substring(0,Math.min(texto.get().length(),20) ) );
        });
    }
    
    public String get(){
        return texto.get();
    }
    
    public String resumen(){
        return resumen.get();
    }
    
    public void change(String txt){
        texto.set(txt);
    }
}