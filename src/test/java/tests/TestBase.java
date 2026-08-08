package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "144.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000; // default 4000
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}