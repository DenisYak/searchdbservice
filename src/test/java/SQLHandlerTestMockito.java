import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class SQLHandlerTestMockito extends Mockito {

    @Mock
    private SQLHandler sqlHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sqlHandler.connectToDB();
        sqlHandler.createTableUsers();
//        sqlHandler.insertSpecificUser("bob", "marley");
//        sqlHandler.insertSpecificUser("rob", "thomas");
//        sqlHandler.insertSpecificUser("james", "hetfield");
    }

    @Test
    public void searchByFirstNameTest() {
        when(sqlHandler.searchByFirstName("bob")).thenReturn(1);
        sqlHandler.searchByFirstName("bob");
        verify(sqlHandler).searchByFirstName("bob");
        Assert.assertTrue(sqlHandler.searchByFirstName("bob") == 1);
    }

    @Test
    public void updateLastNameByFirstNameTest() {
        sqlHandler.updateLastNameByFirstName("bob", "dylan");
        verify(sqlHandler).updateLastNameByFirstName("bob", "dylan");
        when(sqlHandler.selectLastNameByFirstName("bob")).thenReturn("dylan");
        String actual = sqlHandler.selectLastNameByFirstName("bob");
        verify(sqlHandler).selectLastNameByFirstName("bob");
        String expected = "dylan";
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        sqlHandler.disconnectFromDB();
    }
}
