package TestNGAssertionDemos;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @Test
    void testTitle () {
        String actualtitle = "Openshop";
        String mytitle = "Openshop";

        Assert.assertEquals(actualtitle, mytitle);

//        if (actualtitle.equals(mytitle)) {
//            System.out.println("Test passed");
//        }
//        else {
//            System.out.println("Test failed");
//        }
    }
}
