package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class TestPracticeForm extends TestBase {

    @Test
    void successfulSubmitAllFieldsTest() {
        practiceFormPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .setUserGender(genderFemale)
                .typeUserNumber(userNumber)
                .setDateOfBirth(String.valueOf(TestData.dayOfBirth), monthOfBirth, yearOfBirth)
                .selectSubject(subject)
                .selectHobbies(hobby)
                .uploadPicture("test.jpg")
                .setCurrentAddress(currentAddress)
                .setState(state).setCity(city)
                .submitForm()
                //check submitted values
                .checkFieldResult(firstName)
                .checkFieldResult(lastName)
                .checkFieldResult(userEmail)
                .checkFieldResult(genderFemale)
                .checkFieldResult(userNumber)
                .checkFieldResult(yearOfBirth)
                .checkFieldResult(monthOfBirth)
                .checkFieldResult(String.valueOf(TestData.dayOfBirth))
                .checkFieldResult(subject)
                .checkFieldResult(hobby)
                .checkFieldResult("test.jpg")
                .checkFieldResult(currentAddress)
                .checkFieldResult(state)
                .checkFieldResult(city);
    }

    @Test
    void successfulSubmitRequiredFieldsTest() {
        practiceFormPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .setUserGender(genderFemale)
                .typeUserNumber(userNumber)
                .submitForm()
                //check submitted values
                .checkFieldResult(firstName)
                .checkFieldResult(lastName)
                .checkFieldResult(userEmail)
                .checkFieldResult(genderFemale)
                .checkFieldResult(userNumber);
    }

    @Test
    void negativeSubmitEmptyFieldsTest() {
        practiceFormPage.openPage()
                .submitForm()
                //check modal window not exist
                .checkModalWindowNotExist();
    }

    @Test
    void phoneFieldValidationTest() {
        practiceFormPage.openPage()
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setUserGender(genderFemale)
                .typeUserNumber(userInvalidNumber)
                .submitForm()
                //check phone field validation
                .checkModalWindowNotExist()
                .checkErrorPhoneField(borderColor, borderColorRGB);
    }

    @Test
    void firstNameFieldValidationTest() {
        practiceFormPage.openPage()
                .typeUserLastName(lastName)
                .setUserGender(genderFemale)
                .typeUserNumber(userNumber)
                .submitForm()
                //check first name field validation
                .checkModalWindowNotExist()
                .checkErrorFirstNameField(borderColor, borderColorRGB);
    }

    @Test
    void lastNameFieldValidationTest() {
        practiceFormPage.openPage()
                .typeUserFirstName(firstName)
                .setUserGender(genderFemale)
                .typeUserNumber(userNumber)
                .submitForm()
        //check last name field validation
                .checkModalWindowNotExist()
                .checkErrorLastNameField(borderColor, borderColorRGB);
    }

}
