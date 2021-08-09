package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.CalendarPicker;
import org.assertj.core.api.SoftAssertions;
import utils.TestData;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegPage {

    private static final String FORM_TITLE = "Student Registration Form";
    private static final String CONF_FORM_TITLE = "Thanks for submitting the form";

    SoftAssertions softAssertions = new SoftAssertions();
    CalendarPicker calendarPicker = new CalendarPicker();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(FORM_TITLE));
    }

    public void inputFirstName(String firstName){
        $("#firstName").setValue(firstName);
    }

    public void inputLastName(String lastName){
        $("#lastName").setValue(lastName);
    }

    public void inputEMail(String eMail){
        $("#userEmail").setValue(eMail);
    }

    public void inputGender(String gender){
        $("[name=gender][value="+gender+"]").parent().click();
    }

    public void inputMPhone(String mPhone){
        $("#userNumber").setValue(mPhone);
    }

    public void inputBirthDate(String[] dateArr) {
        calendarPicker.setDate(dateArr[0],dateArr[1],dateArr[2]);
    }

    public void inputSubject(String subj) {
        $("#subjectsInput").setValue(subj).pressTab();
    }
    public void inputHobby(String hobby){
        SelenideElement selenideElement = $(byText(hobby));
        String locator = selenideElement.getAttribute("for");
        $("#"+locator).parent().click();
    }

    public void uploadPicture(String pathP) {
        $("#uploadPicture").uploadFromClasspath(pathP);
    }

    public void inputAddress(String addr) {
        $("#currentAddress").setValue(addr);
    }

    public void inputState(String state) {
        $("#stateCity-wrapper #state input").setValue(state).pressTab();
    }

    public void inputCity(String city) {
        $("#stateCity-wrapper #city input").setValue(city).pressTab();
    }

    public void clickSubmit() {
        $("#submit").pressEnter();
    }

    public void checkOutcome(TestData testData){

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(CONF_FORM_TITLE));
        ElementsCollection lines = $$(".table-responsive tbody tr").snapshot();
        for (SelenideElement line: lines) {

            String key = line.$("td").text();
            String value = line.$("td",1).text();
            String expValue = testData.expectedData.get(key);
            softAssertions.assertThat(value)
                    .as("line" + key + " has value " + value + " should have be " + expValue)
                    .isEqualTo(expValue);
        }
        softAssertions.assertAll();
    }









}
