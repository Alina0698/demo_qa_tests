package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TestPracticeForm extends TestBase {

    @Test
    void successfulSubmitAllFieldsTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText(genderFemale)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption(yearOfBirth);
        $("[class=react-datepicker__month-select]").selectOption(monthOfBirth);
        $(".react-datepicker__day.react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //check submitted values
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(genderFemale));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(yearOfBirth));
        $(".table-responsive").shouldHave(text(monthOfBirth));
        $(".table-responsive").shouldHave(text(String.valueOf(TestData.dayOfBirth)));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));
    }

    @Test
    void successfulSubmitRequiredFieldsTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userNumber]").setValue(userNumber);
        $("#genterWrapper").$(byText(genderFemale)).click();
        $("#submit").click();

        //check submitted values
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(genderFemale));
    }

    @Test
    void negativeSubmitEmptyFieldsTest() {
        open("/automation-practice-form");
        $("#submit").click();

        //check modal window not exist
        $(".modal-content").shouldNot(exist);
    }

    @Test
    void phoneFieldValidationTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("#genterWrapper").$(byText(genderFemale)).click();
        $("[id=userNumber]").setValue(userInvalidNumber);
        $("#submit").click();

        //check phone field validation
        $(".modal-content").shouldNot(exist);
        $("#userNumber").shouldHave(cssValue(borderColor, borderColorRGB));
    }

    @Test
    void firstNameFieldValidationTest() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue(lastName);
        $("#genterWrapper").$(byText(genderFemale)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("#submit").click();

        //check first name field validation
        $(".modal-content").shouldNot(exist);
        $("#firstName").shouldHave(cssValue(borderColor, borderColorRGB));
    }

    @Test
    void lastNameFieldValidationTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("#genterWrapper").$(byText(genderFemale)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("#submit").click();

        //check last name field validation
        $(".modal-content").shouldNot(exist);
        $("#lastName").shouldHave(cssValue(borderColor, borderColorRGB));
    }

}
