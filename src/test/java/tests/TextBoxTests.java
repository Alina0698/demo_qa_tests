package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase{

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(firstName + lastName)
                .typeEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(state + city)
                .submitForm()
                .checkField("name", firstName + lastName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", state + city);
    }
}
