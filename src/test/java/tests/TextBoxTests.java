package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;

import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase{

    @Test
    void successfulFillFormTest() {
        TestData data = new TestData();
        textBoxPage.openPage()
                .typeUserName(data.firstName + data.lastName)
                .typeEmail(data.userEmail)
                .typeCurrentAddress(data.currentAddress)
                .typePermanentAddress(data.state + data.city)
                .submitForm()
                .checkField("name", data.firstName + data.lastName)
                .checkField("email", data.userEmail)
                .checkField("currentAddress", data.currentAddress)
                .checkField("permanentAddress", data.state + data.city);
    }
}
