

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SQLHandlerTestMockito extends Mockito {

    @Mock
    SQLHandler sqlHandler;

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
        when(sqlHandler.searchByFirstName("bob")).thenReturn(1);
        verify(sqlHandler).searchByFirstName("bob");
    }


}
