package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    //Elements
    CalendarComponent calendar = new CalendarComponent();
    private SelenideElement userFirstNameInput = $("#firstName");
    private SelenideElement userLastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesList = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#react-select-3-input");
    private SelenideElement citySelect = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement submittedForm = $(".table-responsive");
    private SelenideElement modalWindow = $(".modal-content");


    //Actions
    public PracticeFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public PracticeFormPage typeUserFirstName(String value) {
        userFirstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeUserLastName(String value) {
        userLastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setUserGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage selectSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage selectHobbies(String value) {
        hobbiesList.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelect.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        citySelect.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();

        return this;
    }

    public PracticeFormPage checkFieldResult(String value) {
        submittedForm.shouldHave(text(value));

        return this;
    }

    public PracticeFormPage checkModalWindowNotExist() {
        modalWindow.shouldNot(exist);

        return this;
    }

    public PracticeFormPage checkErrorPhoneField(String borderColor, String borderColorRCG) {
        userNumberInput.shouldHave(cssValue(borderColor, borderColorRCG));

        return this;
    }

    public PracticeFormPage checkErrorFirstNameField(String borderColor, String borderColorRCG) {
        userFirstNameInput.shouldHave(cssValue(borderColor, borderColorRCG));

        return this;
    }

    public PracticeFormPage checkErrorLastNameField(String borderColor, String borderColorRCG) {
        userLastNameInput.shouldHave(cssValue(borderColor, borderColorRCG));

        return this;
    }
}
