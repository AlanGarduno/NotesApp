/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JCVELMON
 */
public class Conexion {
    private static Connection conn;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "0709";
    private static final String url = "jdbc:mysql://localhost:3306/NoteAppDB";
 
    public Conexion ()
    {
        conn = null;
        try
        {
          Class.forName(driver);
          conn = (Connection) DriverManager.getConnection(url, user, pass);
          if(conn != null)
          {
              System.out.println("Conexion establecida");
          }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Error al conectar"+e);
        }
    }
    
    public Connection getConnection()
    {
        return conn;
    }
    
    public void desconectar()
    {
        conn = null;
        if(conn == null)
        {
            System.out.println("Conexion terminada");
        }
    }
}
