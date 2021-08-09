package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestData {

    static Faker faker = new Faker();
    static String[] genderList = {"Male", "Female", "Other"};
    static Random random = new Random();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String cellPhone = "1234567890";
    public String emailAddress = faker.internet().emailAddress();
    public String gender = genderList[random.nextInt(genderList.length-1)];
    public String[] dateOfBirth = ("30 April 2001").split(" ");
    public String[] subjects = {"Maths", "Chemistry"};
    public String[] hobbys = {"Sports", "Music"};
    public String picPath = "pic.png";
    public String currentAddress = faker.address().fullAddress();
    public String state = "NCR";
    public String city = "Noida";

    public Map<String,String> expectedData = new HashMap<String,String>()
    {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", emailAddress);
        put("Gender", gender);
        put("Mobile", cellPhone);
        put("Date of Birth", dateOfBirth[0] + " " + dateOfBirth[1] +"," + dateOfBirth[2]);
        put("Subjects", subjects[0] +", " + subjects[1]);
        put("Hobbies", hobbys[0] + ", " + hobbys[1]);
        put("Picture", picPath);
        put("Address", currentAddress);
        put("State and City", state + " " + city);

    }};

}