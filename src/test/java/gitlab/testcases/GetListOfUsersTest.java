package gitlab.testcases;


import gitlab.requests.post.CreateProject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GetListOfUsersTest extends CreateProject {
    CreateProject project = new CreateProject();


    @Test
    public void getListOfUsersTest01() {

        String actual = listOfMembers();
        System.out.println(actual);
        String expected = "11326545";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void getListOfUsersTest02() {
        String actual = listOfMembers();
        System.out.println(actual);
        String expected = "113264567";
        Assert.assertNotEquals(actual, expected);

    }
}
