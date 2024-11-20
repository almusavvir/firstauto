package TestNGDemos;
/*
    open app
    login
    logout
*/

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test
    void openapp () {
        System.out.println("app opened");
    }

    @Test
    void login () {
        System.out.println("logged in");
    }

    @Test
    void logout () {
        System.out.println("logged out");
    }

}
