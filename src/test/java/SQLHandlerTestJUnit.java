import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class SQLHandlerTestJUnit {

    private SQLHandler sqlHandler = new SQLHandler();

    @Before
    public void setUp() throws Exception {
        sqlHandler.connectToDB();
        sqlHandler.createTableUsers();
        sqlHandler.insertSpecificUser("bob", "marley");
        sqlHandler.insertSpecificUser("rob", "thomas");
        sqlHandler.insertSpecificUser("james", "hetfield");
    }

    @Test
    public void searchByFirstName() throws SQLException{
        int expected = sqlHandler.searchByFirstName("bob");
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateLastNameByFirstName() {
        sqlHandler.updateLastNameByFirstName("bob", "dylan");
        String expected = sqlHandler.selectLastNameByFirstName("bob");
        String actual = "dylan";
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws SQLException {
        sqlHandler.disconnectFromDB();
    }
}