package tests.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExamples {


    @BeforeEach
    void startBrowse() {
        System.out.println("startBrowser");
    }
    @AfterEach
    void closeBrowse() {
        System.out.println("closeBrowser");
    }

    @Test
    void firstTest() {
        System.out.println("firstTest");
    }
    @Test
    void secondTest() {
        System.out.println("secondTest");
    }
}
