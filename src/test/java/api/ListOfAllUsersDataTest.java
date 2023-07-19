package api;
import org.testng.Assert;
import org.testng.annotations.Test;
import source.SingleUserData;
import java.util.List;
import static source.SingleUserData.isValidEmailAddress;

public class ListOfAllUsersDataTest {
    private List<SingleUserData> listOfAllUsers;

    @Test
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

    @Test (priority = 2)
    public void verifyAllUsersHaveValidEmails() {
        for (SingleUserData user : listOfAllUsers) {
            Assert.assertTrue(isValidEmailAddress(user.getEmail()));
        }
    }

    @Test (priority = 3)
    public void verifyMoreThanHalfOfUsersAreActivated() {
        int countActiveUsers = 0;
        int totalUsers = listOfAllUsers.size();
        for (SingleUserData user : listOfAllUsers) {
            if (user.getActive()) {
                countActiveUsers++;
            }
        }
        System.out.println("count="+countActiveUsers);
        System.out.println("total="+totalUsers);
        Assert.assertTrue(countActiveUsers > totalUsers / 2);
    }
}
