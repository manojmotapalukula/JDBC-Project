import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Operations {
    //insert into database
    public void insert(){
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_details","root","Manoj@85"
            );
            String query = "insert into employee values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Enter Emp Id: ");
                int empid = Integer.parseInt(br.readLine());
                System.out.println("Enter Emp Name: ");
                String empname = br.readLine();
                System.out.println("Enter Emp Salary: ");
                double empsalary = Integer.parseInt(br.readLine());
                pstmt.setInt(1,empid);
                pstmt.setString(2,empname);
                pstmt.setDouble(3,empsalary);
                int count = pstmt.executeUpdate();
                if (count>0){
                    System.out.println(count+" record inserted successfully!");
                }
                else{
                    System.out.println("No record inserted!");
                    }
                System.out.println("Do you want yo exit YES/yes: ");
                String ch = br.readLine();
                if (ch.equalsIgnoreCase("YES")){
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //read from database
    public void read(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Manoj@85");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from employee");
            System.out.println("---EMPLOYEE DETAILS---");
            while (rs.next()){
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                double empSalary = rs.getDouble(3);
                System.out.println(empId+" "+empName+" "+empSalary);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //update data in the database
    public void update(){
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_details","root","Manoj@85"
            );
            Statement stmt = conn.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Emp Id: ");
            int empid = Integer.parseInt(br.readLine());
            System.out.println("Enter Emp Salary: ");
            double empsalary = Integer.parseInt(br.readLine());
            int count = stmt.executeUpdate("update employee set empsalary = "+empsalary+" where empid = "+empid);

            if (count>0){
                System.out.println(count+" record Updated successfully!");
            }
            else{
                System.out.println("No record Updated!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //delete from database
    public void delete(){
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_details","root","Manoj@85"
            );
            Statement stmt = conn.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Emp Id: ");
            int empid = Integer.parseInt(br.readLine());

            int count = stmt.executeUpdate("delete from employee where empid = "+empid);

            if (count>0){
                System.out.println(count+" record Deleted successfully!");
            }
            else{
                System.out.println("No record Deleted!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
