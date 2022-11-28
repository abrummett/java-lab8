import java.sql.*;
public class DB {
    public static Connection connect_DB_MY_SQL() {
        Connection con = null;
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://MYSQL8001.site4now.net/db_a8ed12_group5",
                    "a8ed12_group5", "Group5123");
            //here sonoo is database name, root is username and password
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}