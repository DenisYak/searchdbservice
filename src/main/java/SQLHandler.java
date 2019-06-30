import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SQLHandler {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionName = "jdbc:mysql://127.0.0.1:3306/test_db?serverTimezone=UTC";
    private static final String login = "geek";
    private static final String password = "geek";
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

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
            System.out.println("connection done");
        } catch (SQLException e) {
            System.out.println("Can't connect. Incorrect URL/login/password");
            e.printStackTrace();
            return;
        }
    }

    public void disconnectFromDB() {
        try {
            connection.close();
            statement.close();
            resultSet.close();
            System.out.println("disconnection done");
        } catch (SQLException e) {
            System.out.println("Can't disconnect. Connection don't exist");
            e.printStackTrace();
        }
    }

    public void selectAllRows() {
        String query = "SELECT id, first_name, last_name FROM USERS";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                System.out.println("id: " + id + ", first name: " + firstName + ", last name: " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSpecificUser() {
        String query = "INSERT INTO test_db.users (first_name, last_name) VALUES ('jack', 'nicholson')";
        try {
            statement.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAnyUser() {
        System.out.println("Input first name");
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstName = reader.readLine();
            System.out.println("Input last name");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String lastName = reader.readLine();

            String query = "INSERT INTO test_db.users (first_name, last_name) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchByFirstName() {
        System.out.println("For search input first name");
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String query = "SELECT * FROM USERS WHERE first_name = ?";
        try {
            String inputFirstName = reader.readLine();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inputFirstName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                System.out.println("id: " + id + ", first name: " + firstName + ", last name: " + lastName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLastNameByFirstName() {
        System.out.println("For replace input first name");
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputFirstName = reader.readLine();
            System.out.println("For replace input new last name");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String inputNewLastName = reader.readLine();
            String query = "UPDATE USERS SET last_name = ? WHERE first_name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inputNewLastName);
            preparedStatement.setString(2, inputFirstName);
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
