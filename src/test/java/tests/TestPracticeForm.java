package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class TestPracticeForm extends TestBase {

    @Test
    void successfulSubmitAllFieldsTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .typeUserFirstName(data.firstName)
                .typeUserLastName(data.lastName)
                .typeUserEmail(data.userEmail)
                .setUserGender(data.gender)
                .typeUserNumber(data.userNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .selectSubject(data.subject)
                .selectHobbies(data.hobby)
                .uploadPicture("test.jpg")
                .setCurrentAddress(data.currentAddress)
                .setState(data.state).setCity(data.city)
                .submitForm()
                //check submitted values
                .checkFieldResult(data.firstName)
                .checkFieldResult(data.lastName)
                .checkFieldResult(data.userEmail)
                .checkFieldResult(data.gender)
                .checkFieldResult(data.userNumber)
                .checkFieldResult(data.yearOfBirth)
                .checkFieldResult(data.monthOfBirth)
                .checkFieldResult(String.valueOf(data.dayOfBirth))
                .checkFieldResult(data.subject)
                .checkFieldResult(data.hobby)
                .checkFieldResult("test.jpg")
                .checkFieldResult(data.currentAddress)
                .checkFieldResult(data.state)
                .checkFieldResult(data.city);
    }

    @Test
    void successfulSubmitRequiredFieldsTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .typeUserFirstName(data.firstName)
                .typeUserLastName(data.lastName)
                .typeUserEmail(data.userEmail)
                .setUserGender(data.gender)
                .typeUserNumber(data.userNumber)
                .submitForm()
                //check submitted values
                .checkFieldResult(data.firstName)
                .checkFieldResult(data.lastName)
                .checkFieldResult(data.userEmail)
                .checkFieldResult(data.gender)
                .checkFieldResult(data.userNumber);
    }

    @Test
    void negativeSubmitEmptyFieldsTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .submitForm()
                //check modal window not exist
                .checkModalWindowNotExist();
    }

    @Test
    void phoneFieldValidationTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .typeUserFirstName(data.firstName)
                .typeUserLastName(data.lastName)
                .setUserGender(data.gender)
                .typeUserNumber(data.userInvalidNumber)
                .submitForm()
                //check phone field validation
                .checkModalWindowNotExist()
                .checkErrorPhoneField(data.borderColor, data.borderColorRGB);
    }

    @Test
    void firstNameFieldValidationTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .typeUserLastName(data.lastName)
                .setUserGender(data.gender)
                .typeUserNumber(data.userNumber)
                .submitForm()
                //check first name field validation
                .checkModalWindowNotExist()
                .checkErrorFirstNameField(data.borderColor, data.borderColorRGB);
    }

    @Test
    void lastNameFieldValidationTest() {
        TestData data = new TestData();
        practiceFormPage.openPage()
                .typeUserFirstName(data.firstName)
                .setUserGender(data.gender)
                .typeUserNumber(data.userNumber)
                .submitForm()
                //check last name field validation
                .checkModalWindowNotExist()
                .checkErrorLastNameField(data.borderColor, data.borderColorRGB);
    }

}
