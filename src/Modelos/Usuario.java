/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author JCVELMON
 */
public class Usuario {
    
    private int id;
    private String correo;
    private String pass;
    
    public Usuario(){
        
    }

    public Usuario(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //Para el registro de los usuarios
    public void registrarUsuario(){
        
    }
    //Para el inicio de sesion
    public void iniciarSesion(){
        
    }
    
    //Para consulat un usuario
    public void consultarUsuario(){
        
    }
    
    public boolean comprabarPassword(){
        if(this.pass.length() <= 6)
            return false;
        return true;
    }
    
    
}
