/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Conexion.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JCVELMON
 */
public class Usuario {
    
    private int id;
    private String correo;
    private String pass;
    private CRUD crud;
    
    public Usuario(){
     crud = new CRUD();   
    }

    public Usuario(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
        crud = new CRUD();
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
        String sql = "INSET INTO usuarios VALUES( "+this.correo+","+this.pass+")";
        if(crud.insertar(sql))
            System.out.println("Usuaario Registrado");
    }
    
    //Para consulat un usuario
    public String consultarUsuario(String correo){
        String camp = "";
        String update = null;
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE correo ='"+correo+"'";
        rs = crud.consultar(sql);
        try {
            while(rs.next())
            {
                camp = rs.getString("correo");
            }
            return camp;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String consultarPss(String pass){
        String camp = "";
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE pass ='"+pass+"'";
        rs = crud.consultar(sql);
        try {
            while(rs.next())
            {
                camp = rs.getString("pass");
            }
            return camp;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public boolean comprabarPassword(){
        if(this.pass.length() <= 6)
            return false;
        return true;
    }
}
