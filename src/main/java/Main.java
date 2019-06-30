

public class Main {



    public static void main(String[] args) {
        SQLHandler sqlHandler = new SQLHandler();
        sqlHandler.connectToDB();

//        sqlHandler.insertSpecificUser();
//        sqlHandler.insertAnyUser();
        sqlHandler.searchByFirstName();
        sqlHandler.updateLastNameByFirstName();
        sqlHandler.selectAllRows();

        sqlHandler.disconnectFromDB();

    }
}
