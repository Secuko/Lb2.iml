package Base.Database;
import java.sql.*;
import java.util.Scanner;

public class Db {
    public static Connection getConn() throws SQLException {
        String pass = "pass";
        String user = "root";
        String url = "jdbc:mysql://localhost/rps";
        return DriverManager.getConnection(url,user,pass);
    }

    public static void insertVolunteer(Connection conn) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Volunteer (name, qualification, admission) Values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        Scanner in = new Scanner(System.in);
        preparedStatement.setString(1, in.nextLine());
        preparedStatement.setInt(2, in.nextInt());
        in.nextLine();
        preparedStatement.setString(3, in.nextLine());
        int rows = preparedStatement.executeUpdate();
        ResultSet key = preparedStatement.getGeneratedKeys();
        key.next();
        System.out.printf("id = %d \n%d rows added\n", key.getInt(1), rows);
    }

    public static void deleteVolunteer(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Volunteer WHERE id = ?");
        Scanner in = new Scanner(System.in);
        preparedStatement.setInt(1, in.nextInt());
        in.nextLine();
        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows deleted\n", rows);
    }

    public static void updateVolunteer(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Volunteer SET name = ? WHERE id = ?");
        Scanner in = new Scanner(System.in);
        preparedStatement.setInt(2, in.nextInt());
        in.nextLine();
        preparedStatement.setString(1, in.nextLine());
        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows updated\n", rows);
    }

    public static void selectVolunteer(Connection conn) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Volunteer WHERE qualification = ?");
        Scanner in = new Scanner(System.in);
        preparedStatement.setInt(1, in.nextInt());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int id = resultSet.getInt("Id");
            String name = resultSet.getString("name");
            String qualification = resultSet.getString("qualification");
            String admission = resultSet.getString("admission");
            System.out.printf("%d. %s \n Квалификация: %s \n Присоединился: %s \n\n", id, name, qualification, admission);
        }
    }
}
