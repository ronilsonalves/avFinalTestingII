package com.parasoft.parabank.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class RegisterPage extends HomePage {
    protected static final String firstNameInputField = "//*[@id=\"customer.firstName\"]"; // XPath
    protected static final String lastNameInputField = "//*[@id=\"customer.lastName\"]"; // XPath
    protected static final String addressInputField = "//*[@id=\"customer.address.street\"]"; // XPath
    protected static final String cityInputField = "//*[@id=\"customer.address.city\"]"; // XPath
    protected static final String stateInputField = "//*[@id=\"customer.address.state\"]"; // XPath
    protected static final String zipCodeInputField = "//*[@id=\"customer.address.zipCode\"]"; // XPath
    protected static final String phoneNumberInputField = "//*[@id=\"customer.phoneNumber\"]"; // XPath
    protected static final String ssnInputField = "//*[@id=\"customer.ssn\"]"; // XPath
    protected static final String usernameInputField = "//*[@id=\"customer.username\"]"; // XPath
    protected static final String passwordInputField = "//*[@id=\"customer.password\"]"; // XPath
    protected static final String passwordConfirmationInputField = "//*[@id=\"repeatedPassword\"]"; // XPath
    protected static final String registerBtn = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"; // XPath
    protected static final String txtRegistrationResult = "//*[@id=\"rightPanel\"]/p"; // XPath

    public void insertRegisterDataFields (String firstName, String lastName, String address, String city,
                                             String zipcode, String state, String phoneNumber, String ssn,
                                             String username, String password, String passwordConfirmation) {
        WebElement fisrtNameInputEl = getWebElement(By.xpath(firstNameInputField));
        fisrtNameInputEl.clear();
        fisrtNameInputEl.sendKeys(firstName);

        WebElement lastNameInputEl = getWebElement(By.xpath(lastNameInputField));
        lastNameInputEl.clear();
        lastNameInputEl.sendKeys(lastName);

        WebElement addressInputEl = getWebElement(By.xpath(addressInputField));
        addressInputEl.clear();
        addressInputEl.sendKeys(address);

        WebElement cityInputEl = getWebElement(By.xpath(cityInputField));
        cityInputEl.clear();
        cityInputEl.sendKeys(city);

        WebElement stateInputEl = getWebElement(By.xpath(stateInputField));
        stateInputEl.clear();
        stateInputEl.sendKeys(state);

        WebElement zipCodeInputEl = getWebElement(By.xpath(zipCodeInputField));
        zipCodeInputEl.clear();
        zipCodeInputEl.sendKeys(zipcode);

        WebElement phoneNumberInputEl = getWebElement(By.xpath(phoneNumberInputField));
        phoneNumberInputEl.clear();
        phoneNumberInputEl.sendKeys(phoneNumber);

        WebElement ssnInputEl = getWebElement(By.xpath(ssnInputField));
        ssnInputEl.clear();
        ssnInputEl.sendKeys(ssn);

        WebElement usernameInputEl = getWebElement(By.xpath(usernameInputField));
        usernameInputEl.clear();
        usernameInputEl.sendKeys(username);

        WebElement passwordInputEl = getWebElement(By.xpath(passwordInputField));
        passwordInputEl.clear();
        passwordInputEl.sendKeys(password);

        WebElement passwordConfirmationEl = getWebElement(By.xpath(passwordConfirmationInputField));
        passwordConfirmationEl.clear();
        passwordConfirmationEl.sendKeys(passwordConfirmation);
    }

    public void clickRegisterBtn() {
        WebElement registerBtnEl = getWebElement(By.xpath(registerBtn));
        registerBtnEl.click();
    }

    public String getRegisterResult() {
        WebElement resultEl = getWebElement(By.xpath(txtRegistrationResult));
        return resultEl.getText(); // must contains "Your account was created successfully. You are now logged in."
    }
}
