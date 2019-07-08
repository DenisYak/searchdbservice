

public class Main {



    public static void main(String[] args) {
        SQLHandler sqlHandler = new SQLHandler();
        sqlHandler.connectToDB();

        sqlHandler.createTableUsers();
        sqlHandler.insertSpecificUser("bob", "marley");
        sqlHandler.insertSpecificUser("rob", "thomas");
        sqlHandler.insertSpecificUser("james", "hetfield");

//        sqlHandler.insertAnyUser();
//        sqlHandler.searchByFirstName();
//        sqlHandler.updateLastNameByFirstName();


        sqlHandler.disconnectFromDB();

    }
}
