package GiftController;

import GiftModel.GiftJava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiftController {
    static List<GiftJava> listObj = new ArrayList<>();
    static int i = 0;

    public static void main(String[] args) {
        loading();
        select();
    }
    public static void loading() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String stt = "Select * from books";
            ResultSet resultset = stmt.executeQuery(stt);
            while (resultset.next()) {
                GiftJava objGiftShop = new GiftJava();
                objGiftShop.setId(resultset.getInt("id"));
                objGiftShop.setName(resultset.getString("title"));
                objGiftShop.setAuthor(resultset.getString("author"));
                objGiftShop.setPrice(resultset.getDouble("price"));
                objGiftShop.setQty(resultset.getInt("qty"));
                listObj.add(i, objGiftShop);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void select() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement statementmt = connection.createStatement();
        ) {
            String stt = "Select * from books";
            ResultSet rset = statementmt.executeQuery(stt);
            ResultSetMetaData resultsetMD = rset.getMetaData();
            int numColums = resultsetMD.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.printf("%-30s", resultsetMD.getColumnName(i));
            }
            System.out.println();
            for (int i = 0; i < listObj.size(); i++) {
                System.out.printf("%-20d%-20s%-20s%-20.2f%-40d\n", listObj.get(i).getId(), listObj.get(i).getName(), listObj.get(i).getAuthor(), listObj.get(i).getPrice(), listObj.get(i).getQty());
            }
            System.out.printf("There are %d records\n",listObj.size());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insert(GiftJava gift) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement statementmt = connection.createStatement();
        ) {
            String insert = "insert into books values("+gift.getId()+",'"+gift.getName()+"',"+"'"+gift.getAuthor()+"',"+gift.getPrice()+","+gift.getQty()+")";
            statementmt.executeUpdate(insert);
            System.out.println("Successfully added");
            listObj.add(gift);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement statement = connection.createStatement();
        ) {
            System.out.println(" you want to delete id : ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            int i = 0;

            for(i =0;i<listObj.size();i++){
                if(listObj.get(i).getId()==id){
                    listObj.remove(i);
                }
            }
            String delete = "delete from books where id ="+id;
            statement.executeUpdate(delete);
            System.out.printf("Deleted %d record(s)",i);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
