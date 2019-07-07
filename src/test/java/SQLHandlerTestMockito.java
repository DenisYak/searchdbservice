import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SQLHandlerTestMockito extends Mockito {

    @Mock
    SQLHandler sqlHandler;

    @Test
    public void searchByFirstName() {
        when(sqlHandler.searchByFirstName("bob"));
    }




}
