package com.parasoft.parabank.Page;

import com.parasoft.parabank.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    protected static final String registerLinkHref = "//*[@id=\"loginPanel\"]/p[2]/a"; // XPath
    protected static final String usernameField = "//*[@id=\"loginPanel\"]/form/div[1]/input"; // XPath
    protected static final String passwordField = "//*[@id=\"loginPanel\"]/form/div[2]/input"; // XPath
    protected static final String loginBtn = "//*[@id=\"loginPanel\"]/form/div[3]/input"; // XPath
    protected static final String txtLoginResult = "//*[@id=\"leftPanel\"]/p"; // XPath

    public void clickInRegisterLinkHref() {
        WebElement registerLinkEl = getWebElement(By.xpath(registerLinkHref));
        registerLinkEl.click();
    }

    public void insertLoginDataFields(String username, String password) {
        WebElement usernameInputEl = getWebElement(By.xpath(usernameField));
        usernameInputEl.clear();
        usernameInputEl.sendKeys(username);
        WebElement passwordInputEl = getWebElement(By.xpath(passwordField));
        passwordInputEl.clear();
        passwordInputEl.sendKeys(password);
    }

    public void clikLoginBtn() {
        WebElement loginBtnEl = getWebElement(By.xpath(loginBtn));
        loginBtnEl.click();
    }

    public String getLoginResult() {
        WebElement resultEl = getWebElement(By.xpath(txtLoginResult));
        return resultEl.getText(); // must contains "Welcome"
    }
}
