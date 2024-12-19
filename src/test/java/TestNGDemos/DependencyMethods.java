package TestNGDemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
    @Test(priority = 1)
    void openapp() {
        Assert.assertTrue(false);
    }

    @Test(priority = 2)
    void login() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    void search() {
        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    void advSearch() {
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    void logout() {
        Assert.assertTrue(true);
    }
}
