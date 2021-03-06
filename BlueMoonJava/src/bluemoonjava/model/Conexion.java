
package bluemoonjava.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Conexion {
    static Connection contacto = null;
        
    public static Connection getConexion(){
            //String connectionUrl ="jdbc:sqlserver://localhost:1433;databaseName=BLUEMOON2;integratedSecurity=true;";
            String connectionUrl ="jdbc:sqlserver://localhost:1433;databaseName=BLUEMOONFINAL;user=sa;password=123456;";
            //String connectionUrl = "jdbc:sqlserver://localhost;databaseName=ProyectoFinal;user=usuario;password=123456;";
            //String connectionUrl = "jdbc:sqlserver://localhost;databaseName=TrabajoFinalBD;user=usuario;password=123456;";
        
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//conecta con el driver
            }
            // Handle any errors that may have occurred.
            catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el driver "+ e.getMessage(),
                        "Error de conexion",JOptionPane.ERROR_MESSAGE);
            }
            
            try {
                contacto = DriverManager.getConnection(connectionUrl);
                JOptionPane.showMessageDialog(null, "Conexión establecida");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error "+e.getMessage(),
                        "Error de conexion", JOptionPane.ERROR_MESSAGE);
            }
            
            return contacto;
        }
    
    //recibe las consultas y nos devolvera los resultados
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();//conectar con la BD
        Statement declara;//representa una instruccion
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta); 
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage(),
                        "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
