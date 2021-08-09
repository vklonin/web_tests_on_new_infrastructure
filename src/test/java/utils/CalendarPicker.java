package utils;

import static com.codeborne.selenide.Selenide.$;

public class CalendarPicker {

    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); // month -1
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }

}
