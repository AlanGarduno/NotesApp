/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JCVELMON
 */
public class CRUD {
    private String tabla;
    private String campo;
    private Conexion conexion = new Conexion(); 
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    

    public CRUD() 
    {
       try
       {
           if((conn=conexion.getConnection()) == null)
           {
             JOptionPane.showMessageDialog(null,"ERROR");
           }
           stm = conn.createStatement();
       }catch(HeadlessException | SQLException e)
       {
           e.printStackTrace();
       }
    }
    

    
    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
    
    public boolean insertar(String sql)
    {
        try
        {
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e)
        {
            return false;
        }
    }
        
    
    public ResultSet consultar(String sql)
    {
        try
        {
            rs = stm.executeQuery(sql);
            return rs;
        }catch(SQLException e)
        {
            return null;
        }
        
    }
    
}
