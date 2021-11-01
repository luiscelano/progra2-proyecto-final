package CapaNegocio;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author luiscelano
 */
public class DatabaseService {
    
    public DatabaseService() {
        
    }
    /**
     * Evento de conexion
     */
    public Statement connection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando con base de datos...");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "dev2", "12345");
            Statement st = connection.createStatement();
            
            return st;
        } catch (Exception e) {
            System.out.println("Error al abrir la conexion: " + e);
        return null;
        }
    }
    /**
     *Evento que ejecuta una consulta
     */
    public ResultSet query(String query) throws Exception {
    
        try {
            Statement st = connection();
            
            ResultSet resultSet = st.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            throw new Exception(e.toString());
        }
    }
}
