import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public void connectDb(){
        //register driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // establish connection

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Manoj@85");
                System.out.println("Database connected Successfully");
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
