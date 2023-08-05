package source;

import java.sql.*;
import static source.Constants.*;

public class SqlQueriesJdbc {

    public static String getIdAndActivationCodeFromDataBase(String userEmail) throws SQLException {
        String result = "";
        Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        try (PreparedStatement selectStatement =
                     dbConnection.prepareStatement("SELECT id, activationCode FROM users WHERE email = ?")) {
            selectStatement.setString(1, userEmail);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("id") + ";" + resultSet.getString("activationCode");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.close();
        return result;
    }

    public static void getAllInformationAboutUsersFromDataBase() throws SQLException {
        Connection dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        int column;
        int field = 0;
        try (PreparedStatement selectStatement = dbConnection.prepareStatement("SELECT * FROM users")) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                System.out.format("#" + "%-4.4s", ++field);
                System.out.print(" | ");
                column = 0;
                while (++column < 12) {
                    if (column == 2)
                        System.out.format("%25.25s", resultSet.getString(column));
                    else if (column == 3)
                        System.out.format("%20.20s", resultSet.getString(column));
                    else if (column == 5)
                        System.out.format("%5.5s", resultSet.getString(column));
                    else if (column == 7)
                        ++column;
                    else
                        System.out.print(resultSet.getString(column));
                    System.out.print(" | ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}