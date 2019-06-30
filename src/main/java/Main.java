

public class Main {



    public static void main(String[] args) {
        SQLHandler sqlHandler = new SQLHandler();
        sqlHandler.connectToDB();

        sqlHandler.createTableUsers();
        sqlHandler.insertSpecificUser("bob", "marley");
        sqlHandler.insertSpecificUser("rob", "zombie");
        sqlHandler.insertSpecificUser("james", "hetfield");

//        sqlHandler.insertAnyUser();
//        sqlHandler.searchByFirstName();
//        sqlHandler.updateLastNameByFirstName();

        sqlHandler.selectAllRows();

        sqlHandler.disconnectFromDB();

    }
}
