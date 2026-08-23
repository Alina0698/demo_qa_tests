package tests.testdata;

import com.github.javafaker.Faker;

public class TestData {

    private final Faker faker = new Faker();
    // Common Test Data for PracticeForm and TestBox
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = stateCity(state);

    // Test Data for PracticeForm
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1930, 2010));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public int dayOfBirth = faker.number().numberBetween(1, 28);
    public String subject = faker.options().option("Physics", "English", "Maths", "Biology");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String currentAddress = faker.address().fullAddress();

    // Invalid Test Data
    public String userInvalidNumber = faker.phoneNumber().subscriberNumber(7);

    //Styles Field Validation
    public String borderColor = "border-color";
    public String borderColorRGB = "rgb(220, 53, 69)";

    private String stateCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "";
        }
    }
}