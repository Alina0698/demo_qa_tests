package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v131.filesystem.model.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm extends TestBase {

    @Test
    void SuccessfulSubmitAllFields() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alina");
        $("[id=lastName]").setValue("Test");
        $("[id=userEmail]").setValue("test@mail.com");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("1234567891");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption("1991");
        $("[class=react-datepicker__month-select]").selectOption("September");
        $(".react-datepicker__day.react-datepicker__day--016").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Moscow, Lermontova street, 25-70");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        //check submitted values
        $(".table-responsive").shouldHave(text("Alina"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("test@mail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567891"));
        $(".table-responsive").shouldHave(text("1991"));
        $(".table-responsive").shouldHave(text("September"));
        $(".table-responsive").shouldHave(text("16"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Moscow, Lermontova street, 25-70"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Delhi"));
    }

    @Test
    void SuccessfulSubmitRequiredFields() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alina");
        $("[id=lastName]").setValue("Test");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("1234567891");
        $("#submit").click();

        //check submitted values
        $(".table-responsive").shouldHave(text("Alina"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("1234567891"));
        $(".table-responsive").shouldHave(text("Female"));
    }

    @Test
    void NegativeSubmitEmptyFields() {
        open("/automation-practice-form");
        $("#submit").click();

        //check modal window not exist
        $(".modal-content").shouldNot(exist);
    }

    @Test
    void PhoneFieldValidation() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alina");
        $("[id=lastName]").setValue("Test");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("1234567");
        $("#submit").click();

        //check phone field validation
        $(".modal-content").shouldNot(exist);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void FirstNameFieldValidation() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue("Test");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("1234567890");
        $("#submit").click();

        //check first name field validation
        $(".modal-content").shouldNot(exist);
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void LastNameFieldValidation() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alina");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("1234567890");
        $("#submit").click();

        //check last name field validation
        $(".modal-content").shouldNot(exist);
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
