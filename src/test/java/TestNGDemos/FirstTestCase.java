package TestNGDemos;
/*
    open app
    login
    logout
*/

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 1)
    void openapp () {
        System.out.println("app opened");
    }

    @Test(priority = 2)
    void login () {
        System.out.println("logged in");
    }

    @Test(priority = 3)
    void logout () {
        System.out.println("logged out");
    }

}
