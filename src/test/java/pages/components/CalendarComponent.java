package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement monthSelection = $(".react-datepicker__month-select");
    private final SelenideElement yearSelection = $(".react-datepicker__year-select");
    private final SelenideElement clickCalendar = $("#dateOfBirthInput");
    private SelenideElement daySelection(int day) {
        return $(".react-datepicker__day--" + String.format("%03d", day) + ":not(.react-datepicker__day--outside-month)");
    };

    public void setDate(int day, String month, String year) {
        clickCalendar.click();
        monthSelection.selectOption(month);
        yearSelection.selectOption(year);
        daySelection(day).click();
    }
}