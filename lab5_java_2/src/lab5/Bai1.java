package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String delete = "Delete from books where id >8000";
            System.out.println("The SQL statement is " + delete);
            int count = stmt.executeUpdate(delete);
            System.out.println(count + " row(s) effected");
            System.out.println("===============================================================");
            String sqlInsert = "insert into books values" +
                    "(8001,'Java Core','Dang Kim Thi',15.5,55)," +
                    "(8002,'Java Advanced','James Gosling',25.5,55)";
            System.out.println("The SQL statement is: " + sqlInsert);
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " row(s) infected");
            System.out.println("===============================================================");
            sqlInsert = "insert into books(id,title,author) values" +
                    "(2001,'Java JDBC MySQL','ThiDK')";
            System.out.println("The SQL statement is: " + sqlInsert);
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " row(s) infected");
            System.out.println("===============================================================");
            System.out.println("Enter bookID you want to delete: ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            delete = "delete from books where id ="+id;
            System.out.println("The SQL statement is " + delete);
            count = stmt.executeUpdate(delete);
            System.out.println(count + " row(s) effected");
            System.out.println("===============================================================");
            System.out.println(" You want to add:\n" +
                    "BookId: ");
            id = input.nextInt();
            System.out.println("Title: ");
            input.nextLine();
            String title = input.nextLine();
            System.out.println("Author: ");
            String author = input.nextLine();
            System.out.println("Price: ");
            double price = input.nextDouble();
            System.out.println("Qty: ");
            int qty = input.nextInt();
            sqlInsert = "Insert into books values"+
                    "("+id+",'"+title+"'"+",'"+author+"'"+","+price+","+qty+")";
            System.out.println("The SQL statement is "+sqlInsert);
            countInserted= stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" row effected\n");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
