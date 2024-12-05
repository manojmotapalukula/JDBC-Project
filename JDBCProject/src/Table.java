import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {

    public void createTable(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Manoj@85");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("Create table employee(empid int, empname varchar(30), empsalary double, primary key (empid));");
            System.out.println("Table Created SuccessFully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
