import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHandler {
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionName = "jdbc:mysql://127.0.0.1:3306/test_db";
    private final String login = "geek";
    private final String password = "geek";
    private static Connection connection;

    public SQLHandler() {
    }

    public void connectToDB() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't connect. No driver found");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection(connectionName, login, password);
        } catch (SQLException e) {
            System.out.println("Can't connect. Incorrect URL/login/password");
            e.printStackTrace();
            return;
        }
    }

    public void disconnectFromDB() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't disconnect. Connection don't exist");
            e.printStackTrace();
        }
    }
}
