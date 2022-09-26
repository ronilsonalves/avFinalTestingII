package com.parasoft.parabank.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.logging.Logger;

public class BasePage {

    public static WebDriver driver;

    protected static final String URL = "https://parabank.parasoft.com/parabank/index.htm";

    private static final Logger log = Logger.getLogger(BasePage.class.getName());

    public BasePage() {
        // No meu ambiente fora utilizado o EdgeDriver junto ao Selenium, para não ter a necessidade de setar aqui
        // (System.setProperty("webdriver.edge.driver","src/test/resources/msedgedriver.exe")); precisei usar uma
        // versão mais recente do Selenium.
        driver = new EdgeDriver();
    }

    public void openApp() {
        getDriver().get(URL);
        getDriver().manage().window().maximize();
    }

    public WebElement getWebElement(By locator) {
        WebElement element = null;

        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            log.info("Elemento não encontrado!");
            log.info("Mensagem de erro: "+e.getMessage());
        }

        return element;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDrive() {
        getDriver().quit();
    }
}
