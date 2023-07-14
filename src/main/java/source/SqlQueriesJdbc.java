package source;

import java.sql.*;
import static source.Constants.*;

public class SqlQueriesJdbc {

    public static String getIdAndActivationCode(String userEmail) throws SQLException {
        String result = "";
        Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        try (PreparedStatement selectStatement =
                     dbConnection.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?")) {
            selectStatement.setString(1, userEmail);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("id") + ";" + resultSet.getString("activationCode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void getTopFivePopularNamesFromDB() throws SQLException {
        Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        try (PreparedStatement selectStatement = dbConnection.prepareStatement(
                             "SELECT COUNT(*), name FROM users" +
                                " GROUP BY name" +
                                " HAVING COUNT(*) > 2" +
                                " AND name IS NOT NULL" +
                                " ORDER BY COUNT(*) DESC" +
                                " Limit 5")) {
            ResultSet resultSet = selectStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                System.out.print(++i + ")");
                System.out.format("%3s", resultSet.getString(1));
                System.out.print(" | ");
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllInformationAboutUsersFromDB() throws SQLException {
        Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        try (PreparedStatement selectStatement = dbConnection.prepareStatement("SELECT * FROM users")) {
            ResultSet resultSet = selectStatement.executeQuery();
            int i = 0;
            int j = 0;
            while (resultSet.next()) {
                System.out.print(++j + ") ");
                while (++i < 12) {
                    if (i == 2)
                        System.out.format("%35s", resultSet.getString(i));
                    else if (i == 3)
                        System.out.format("%25s", resultSet.getString(i));
                    else
                        System.out.print(resultSet.getString(i));
                    System.out.print(" | ");
                }
                i = 0;
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}