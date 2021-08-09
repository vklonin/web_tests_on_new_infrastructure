package tests;

import org.junit.jupiter.api.Test;
import utils.TestData;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationTest extends TestBase {

    @Test
    void fillingAndSubmittingForm(){
        StudentRegPage studentRegPage = new StudentRegPage();
        TestData testData = new TestData();

        step("Open main page" , studentRegPage::openPage);
        step("Input first name" , () -> studentRegPage.inputFirstName(testData.firstName));
        step("Input last name" , () -> studentRegPage.inputLastName(testData.lastName));
        step("Input email" , () -> studentRegPage.inputEMail(testData.emailAddress));
        step("Input gender" , () -> studentRegPage.inputGender(testData.gender));
        step("Input cell phone" , () -> studentRegPage.inputMPhone(testData.cellPhone));
        step("Input date of birth" , () -> studentRegPage.inputBirthDate(testData.dateOfBirth));
        step("Input subject 1" , () -> studentRegPage.inputSubject(testData.subjects[0]));
        step("Input subject 2" , () -> studentRegPage.inputSubject(testData.subjects[1]));
        step("Input hobby 1" , () -> studentRegPage.inputHobby(testData.hobbys[0]));
        step("Input hobby 2" , () -> studentRegPage.inputHobby(testData.hobbys[1]));
        step("Input picture" , () -> studentRegPage.uploadPicture(testData.picPath));
        step("Input address" , () -> studentRegPage.inputAddress(testData.currentAddress));
        step("Input state" , () -> studentRegPage.inputState(testData.state));
        step("Input city" , () -> studentRegPage.inputCity(testData.city));
        step("Submit form" , studentRegPage::clickSubmit);
        step("Check results" , () -> studentRegPage.checkOutcome(testData));
    }
}