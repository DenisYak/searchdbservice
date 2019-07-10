import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SQLHandlerTestJUnit {

    private SQLHandler sqlHandler = new SQLHandler();

    @Before
    public void setUp() {
        sqlHandler.connectToDB();
        sqlHandler.createTableUsers();
        sqlHandler.insertSpecificUser("bob", "marley");
        sqlHandler.insertSpecificUser("rob", "thomas");
        sqlHandler.insertSpecificUser("james", "hetfield");
    }

    @Test
    public void searchByFirstName() {
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
    public void tearDown() {
        sqlHandler.disconnectFromDB();
    }
}