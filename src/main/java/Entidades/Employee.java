package Entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author luiscelano
 */
public class Employee {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the names
     */
    public String getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * @return the lastnames
     */
    public String getLastnames() {
        return lastnames;
    }

    /**
     * @param lastnames the lastnames to set
     */
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    /**
     * @return the cedula
     */
    public Long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee(Integer id, String names, String lastnames, Long cedula, String maritalStatus, String gender, Integer age) {
        this.id = id;
        this.names = names;
        this.lastnames = lastnames;
        this.cedula = cedula;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.age = age;
    }
    
    public void setLine(ResultSet response) throws SQLException {
        this.setId((Integer) Integer.parseInt(response.getString("id")));
        this.setNames(response.getString("names"));
        this.setLastnames(response.getString("lastnames"));
        this.setCedula((Long) Long.parseLong(response.getString("cedula").trim()));
        this.setMaritalStatus(response.getString("maritalStatus"));
        this.setGender(response.getString("gender"));
        this.setAge((Integer) Integer.parseInt(response.getString("age")));
    }
    public void setLineAsObject(Vector<Object> response) {
        this.setId((Integer) Integer.parseInt(response.get(0).toString()));
        this.setNames(response.get(1).toString());
        this.setLastnames(response.get(2).toString());
        this.setCedula((Long) Long.parseLong(response.get(3).toString().trim()));
        this.setMaritalStatus(response.get(4).toString());
        this.setGender(response.get(5).toString());
        this.setAge((Integer) Integer.parseInt(response.get(6).toString()));
    }
    
    public Employee() {
        
    }
    
    private Integer id;
    private String names;
    private String lastnames;
    private Long cedula;
    private String maritalStatus;
    private String gender;
    private Integer age;
    
    public Object[] getTableRow() {
        return new Object[]{ getId(), getNames(), getLastnames(), getCedula().longValue(), getMaritalStatus(), getGender(), getAge()};
    }
    
    public String getInsertQuery() {
        return "INSERT INTO EMPLOYEES (ID, NAMES, LASTNAMES, CEDULA, MARITALSTATUS, GENDER, AGE) values(id.nextval,'"+getNames()+"','"+getLastnames()+"',"+getCedula()+",'"+getMaritalStatus()+"','"+getGender()+"',"+getAge()+")";
    }
    
    public String getUpdateQuery() {
        return "UPDATE EMPLOYEES SET NAMES = '"+getNames()+"', "
               +"LASTNAMES = '"+getLastnames()+"', "
               +"CEDULA = "+getCedula()+", "
               +"MARITALSTATUS = '"+getMaritalStatus()+"', "
               +"GENDER = '"+getGender()+"', "
               +"AGE = "+getAge()+ " WHERE ID = "+getId();
    }
    
    public String getDeleteQuery() {
        return "DELETE FROM EMPLOYEES WHERE ID = "+ getId();
    }
}
