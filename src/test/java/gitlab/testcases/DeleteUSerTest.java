package gitlab.testcases;

import gitlab.requests.delete.DeleteRequests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUSerTest extends DeleteRequests {
    DeleteRequests deleteRequests = new DeleteRequests();

    @Test()
    public void responseValidation() {
        int actual = deleteRequests.deleteProject();
        Assert.assertEquals(actual, 202);

    }

    @Test()
    public void deleteVariableValidation() {
        int actual = deleteRequests.deleteVariable();
        Assert.assertNotEquals(actual, 202);


    }
}
