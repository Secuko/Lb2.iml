package Base;
import java.sql.*;
import Base.Database.*;

public class Main {

    public static void main(String[] args) {
        try{ Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = Db.getConn()){
                System.out.println("Connection to Database successfull!");
                //Db.insertVolunteer(conn);
                //Db.updateVolunteer(conn);
                //Db.deleteVolunteer(conn);
                //Db.selectVolunteer(conn);
            }
            catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        catch(Exception ex){ System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
