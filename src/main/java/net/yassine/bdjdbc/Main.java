package net.yassine.bdjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @author $ {USER}
 **/
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        String query = "SELECT * FROM users";

        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(query);

            System.out.println("ID | Name     | Email");
            System.out.println("--------------------------");
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");

                System.out.println(id + " | " + name + " | " + email);
            }
            res.close();
            st.close();
            conn.close();
            System.out.println("Connection closed.");
        } catch(Exception e){
            e.printStackTrace();
            //System.out.println(e);
        }
    }
}
