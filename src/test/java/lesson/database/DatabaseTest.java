package lesson.database;

import lesson.database.model.TestTableDto;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class DatabaseTest {

    @Test
    public void databaseConnectionTest() {
        Connection connection = PostgresDatabaseConnection.getInstance().getConnection();
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void getDataFromDatabaseTest() {
        TestTableDto expectedDto = new TestTableDto(1, "test", "1991-07-08", "test.@email.com");
        TestTableDto actualDto = new TestTableDto();
        String SELECT_SQL = "SELECT * FROM \"TEST_TABLE\"";

        Connection connection = PostgresDatabaseConnection.getInstance().getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_SQL);
            while (resultSet.next()) {
                actualDto.setId(resultSet.getInt(1));
                actualDto.setName(resultSet.getString("name"));
                actualDto.setDateOfBirth(resultSet.getString("date_of_birth"));
                actualDto.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        System.out.println("Actual results from DB: " + actualDto);
        assertEquals(actualDto, expectedDto);
    }

    @Test
    public void createDataInDatabaseTest() {
        TestTableDto dto = new TestTableDto(2, "my user", "1994-12-15", "test.my_user@email.com");
        List<TestTableDto> actualDtos = new ArrayList<>();
        String SELECT_SQL = "SELECT * FROM \"TEST_TABLE\"";
        String INSERT_SQL = "INSERT INTO \"TEST_TABLE\" (name, date_of_birth, email) VALUES(?, ?, ?)";

        Connection connection = PostgresDatabaseConnection.getInstance().getConnection();

        PreparedStatement statement = null;
        Statement selectStatement = null;
        try {
            statement = connection.prepareStatement(INSERT_SQL);
            statement.setString(1, dto.getName());
            statement.setString(2, dto.getDateOfBirth());
            statement.setString(3, dto.getEmail());
            statement.execute();

            selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(SELECT_SQL);
            while (resultSet.next()) {
                TestTableDto actualDto = new TestTableDto();
                actualDto.setId(resultSet.getInt(1));
                actualDto.setName(resultSet.getString("name"));
                actualDto.setDateOfBirth(resultSet.getString("date_of_birth"));
                actualDto.setEmail(resultSet.getString("email"));
                actualDtos.add(actualDto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        System.out.println("Actual results from DB: " + actualDtos);
    }


}
