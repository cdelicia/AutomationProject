package api;
import org.testng.Assert;
import org.testng.annotations.Test;
import source.SingleUserData;
import java.util.List;

public class ListOfAllUsersDataTest {
    private List<SingleUserData> listOfAllUsers;

    @Test (priority = 0)
    public void verifyAllUsersEmailsIsNotNull() {
        listOfAllUsers = PredefinedDataTest.getList();
        for (SingleUserData user : listOfAllUsers) {
            Assert.assertFalse(user.getEmail().isEmpty());
        }
    }

    @Test (priority = 1)
    public void verifyAllUsersHaveNames() {
        for (SingleUserData user : listOfAllUsers) {
            Assert.assertFalse(user.getName().isEmpty());
        }
    }
}
