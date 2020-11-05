package lab5;

import java.sql.*;

public class Ex1JdbcInsertTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ){
            String sqlDelete = "delete from books where id >1001 and id <=1003";
            System.out.println("The SQL statement is "+sqlDelete+"\n");
            int countDeleted =stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted+" records deleted.\n");

            String sqlInsert = "insert into books values (1006,'Gone fishing','Kumar',11.11,66)";
            System.out.println("The SQL statement is: "+sqlInsert+"\n");
            int countInserted=stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" recoreds inserted.\n");

            sqlInsert = "insert into books values"+
                    "(1007,'Gone fishing 2','Kumar',22.22,22),"+
                    "(1008,'GOne fishing 3','Kumar',33.33,33)";
            System.out.println("The SQL statement is: "+sqlInsert+"\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" records inserted.\n");

            String str = "Select * from books";
            System.out.println("The SQL statement is: "+str);
            ResultSet rset = stmt.executeQuery(str);
            while(rset.next()){
                System.out.println(rset.getInt("id")+","+
                        rset.getString("author")+","+
                        rset.getString("title")+","+
                        rset.getDouble("price")+","+
                        rset.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
