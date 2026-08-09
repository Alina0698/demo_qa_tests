package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

    public class ResultTable {
        private final SelenideElement submittedForm = $(".table-responsive");
        private final SelenideElement modalWindow = $(".modal-content");

        public ResultTable checkValue(String value) {
            submittedForm.shouldHave(text(value));
            return this;
        }

        public ResultTable checkModalPresence() {
            modalWindow.shouldNot(exist);
            return this;
        }
    }