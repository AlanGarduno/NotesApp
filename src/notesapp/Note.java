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
    public int position;
    private String guid;
    private String oldText;
    
    
    public Note(){
        
        this.texto = new SimpleStringProperty("");
        this.resumen = new SimpleStringProperty("Nueva nota");
        this.guid = "";
        this.oldText="";
        
        texto.addListener((ObservableValue<? extends String> av, String oldValue, String newValue) ->{
        
                this.resumen.set(texto.get().substring(0,Math.min(texto.get().length(),20) ) );
                //System.out.println(resumen);
        });
    }
    
    public Note(String content, String title,String guid){
        this.texto = new SimpleStringProperty(content);
        this.resumen = new SimpleStringProperty(title);
        this.guid = guid;
        this.oldText = content;
         texto.addListener((ObservableValue<? extends String> av, String oldValue, String newValue) ->{
        
                this.resumen.set(texto.get().substring(0,Math.min(texto.get().length(),20) ) );
                //System.out.println(resumen);
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
    
    public void  set_guid(String guid){
        this.guid = guid;
    }
    
    public String get_guid(){
        
        return this.guid;
    }
    
    public boolean is_new(){
        return this.guid.equals("");
    }
    
    public boolean is_valid(){
        return  this.oldText == this.get();
    }
    
    public String getTitle(){
        if(this.texto.get().length() <= 20){
            return this.get();
        }else{
            return this.texto.get().substring(0, 20);
        }
    }
}
