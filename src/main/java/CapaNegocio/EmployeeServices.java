package CapaNegocio;

import Entidades.Employee;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luiscelano
 */
public class EmployeeServices {
    /**
     *Evento para crear un empleado
     */
    public void CreateEmployee(Employee employee) {
        try {
        DatabaseService server = new DatabaseService();
            System.out.println(employee.getInsertQuery());
        server.query(employee.getInsertQuery());
        JOptionPane.showMessageDialog(null, "Empleado agregado!");
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    /**
     *Evento para editar un empleado
     */
    public void EditEmployee(Employee employee) {
        try {
        DatabaseService server = new DatabaseService();
        server.query(employee.getUpdateQuery());
        JOptionPane.showMessageDialog(null, "Empleado actualizado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    /**
     *Evento para eliminar un empleado
     */
    public void DeleteEmployee(Employee employee) {
        try {
        DatabaseService server = new DatabaseService();
        server.query(employee.getDeleteQuery());
        JOptionPane.showMessageDialog(null, "Empleado eliminado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    /**
     *Evento para obtener todos los empleados
     */
    public DefaultTableModel fetchEmployees() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRES");
        model.addColumn("APELLIDOS");
        model.addColumn("CEDULA");
        model.addColumn("ESTADO CIVIL");
        model.addColumn("GENERO");
        model.addColumn("EDAD");
        try {
        DatabaseService server = new DatabaseService();
        String query = "SELECT * FROM EMPLOYEES";
        
            ResultSet response = server.query(query);
            System.out.println(response); 
        while(response.next()) {
        Employee empleado = new Employee();
        empleado.setLine(response);
            model.addRow(empleado.getTableRow()); 
        }       
        return model;
        } catch (Exception e) {
            throw new Error(e.toString());
        }
        
    }
}
