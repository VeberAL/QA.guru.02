package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.CssValue;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $(".col-md-9 div"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            dropListState = $("#state"),
            dropListCity = $("#city"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            checkResult = $(".table-responsive"),
            checkErrorColorInput = $("#firstName");
    CalendarComponent calendarComponent = new CalendarComponent();

    public LoginPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public LoginPage setFirstName(String fname) {
        firstNameInput.setValue(fname);
        return this;
    }

    public LoginPage setLastName(String lname) {
        lastNameInput.setValue(lname);
        return this;
    }

    public LoginPage setEmail(String mail) {
        emailInput.setValue(mail);
        return this;
    }

    public LoginPage setGender(String gender) {
        genderWrapper.$(withText(gender)).click();
        return this;
    }

    public LoginPage setPhoneNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public LoginPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public LoginPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public LoginPage setHobbies(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    public LoginPage uploadPicture(String picName) {
        uploadPicture.uploadFromClasspath(picName);
        return this;
    }

    public LoginPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public LoginPage setState(String state) {
        dropListState.click();
        dropListState.$(byText(state)).click();
        return this;
    }

    public LoginPage setCity(String city) {
        dropListCity.click();
        dropListCity.$(byText(city)).click();
        return this;
    }

    public LoginPage clickButton(String Bname) {
        $(Bname).click();
        return this;
    }

    public LoginPage checkResult(String key, String value) {
        checkResult.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public LoginPage checkErrorColorInput(String color) {
        checkErrorColorInput.shouldHave(new CssValue("border-color", color));
        return this;
    }
}
