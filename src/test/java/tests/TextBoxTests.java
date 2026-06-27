package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Alina Test");
        $("[id=userEmail]").setValue("mail@mail.com");
        $("[id=currentAddress]").setValue("Address Belgrade");
        $("[id=permanentAddress]").setValue("Permanent Address");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Alina Test"));
        $("[id=output] [id=email]").shouldHave(text("mail@mail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("Address Belgrade"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("Permanent Address"));
    }
}
