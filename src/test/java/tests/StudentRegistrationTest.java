package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.TestData;

public class StudentRegistrationTest {

    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        Configuration.browser = "safari";
    }

    @Test
    void fillingAndSubmittingForm(){
        StudentRegPage studentRegPage = new StudentRegPage();

        TestData testData = new TestData();

        studentRegPage.openPage();
        studentRegPage.inputFirstName(testData.firstName);
        studentRegPage.inputLastName(testData.lastName);
        studentRegPage.inputEMail(testData.emailAddress);
        studentRegPage.inputGender(testData.gender);
        studentRegPage.inputMPhone(testData.cellPhone);
        studentRegPage.inputBirthDate(testData.dateOfBirth);
        studentRegPage.inputSubject(testData.subjects[0]);
        studentRegPage.inputSubject(testData.subjects[1]);
        studentRegPage.inputHobby(testData.hobbys[0]);
        studentRegPage.inputHobby(testData.hobbys[1]);
        studentRegPage.uploadPicture(testData.picPath);
        studentRegPage.inputAddress(testData.currentAddress);
        studentRegPage.inputState(testData.state);
        studentRegPage.inputCity(testData.city);
        studentRegPage.clickSubmit();
        studentRegPage.checkOutcome(testData);


    }
}