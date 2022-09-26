package com.parasoft.parabank.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends RegisterPage {
    protected static final String openNewAccountLinkHref = "//*[@id=\"leftPanel\"]/ul/li[1]/a"; // XPath
    protected static final String selectFieldTypeAccount = "//*[@id=\"type\"]"; // XPath
    protected static final String openNewAccountBtn = "//*[@id=\"rightPanel\"]/div/div/form/div/input"; // XPath
    protected static final String txtOpenNewAccountResult = "//*[@id=\"rightPanel\"]/div/div/p[1]"; // XPath
    protected static final String accountsOverviewLinkHref = "//*[@id=\"leftPanel\"]/ul/li[2]/a"; // XPath
    protected static final String txtAccountsOverviewPage = "//*[@id=\"accountTable\"]/tfoot/tr/td"; // XPath
    protected static final String firstAccountFromListLinkHref = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"; // XPath
    protected static final String txtAccountDetails = "//*[@id=\"rightPanel\"]/div/div[1]/h1"; // XPath
    protected static final String goButton =
            "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input"; // XPath
    protected static final String transferFundsLinkHref = "//*[@id=\"leftPanel\"]/ul/li[3]/a"; // XPath
    protected static final String txtTransferFundsPage = "//*[@id=\"rightPanel\"]/div/div/h1"; // XPath
    protected static final String ammountInputField = "//*[@id=\"amount\"]"; // XPath
    protected static final String fromAccountSelectField = "//*[@id=\"fromAccountId\"]"; // XPath
    protected static final String toAccountSelectField = "//*[@id=\"toAccountId\"]"; // XPath
    protected static final String transferBtn = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input"; // XPath
    protected static final String txtTransferStatusResult = "//*[@id=\"rightPanel\"]/div/div/h1"; // XPath

    public void clickOnOpenNewAccountLink() {
        WebElement openNewAccountLinkEl = getWebElement(By.xpath(openNewAccountLinkHref));
        openNewAccountLinkEl.click();
    }

    public void performActionOpenNewAccount() {
        Select selectTypeEl = new Select(getWebElement(By.xpath(selectFieldTypeAccount)));
        selectTypeEl.selectByIndex(1);
        WebElement openAccountBtnEl = getWebElement(By.xpath(openNewAccountBtn));
        openAccountBtnEl.click();
    }

    public String getTxtOpenNewAccountResult() {
        WebElement resultEl = getWebElement(By.xpath(txtOpenNewAccountResult));
        return resultEl.getText();
    }

    public void clickOnAccountsOverview() {
        WebElement accountsOverviewLinkEl = getWebElement(By.xpath(accountsOverviewLinkHref));
        accountsOverviewLinkEl.click();
    }

    public String getTxtAccountsOverviewPage() {
        WebElement resultEl = getWebElement(By.xpath(txtAccountsOverviewPage));
        return resultEl.getText();
    }

    public void clickOnTransferFundsLink() {
        WebElement transferFundsLinkEl = getWebElement(By.xpath(transferFundsLinkHref));
        transferFundsLinkEl.click();
    }

    public String getTxtTransferFundsPage() {
        WebElement resultEl = getWebElement(By.xpath(txtTransferFundsPage));
        return  resultEl.getText();
    }

    public void insertTransferData(String ammount) {
        WebElement ammountInputEl = getWebElement(By.xpath(ammountInputField));
        ammountInputEl.clear();
        ammountInputEl.sendKeys(ammount);

        Select selectFromEl = new Select(getWebElement(By.xpath(fromAccountSelectField)));
        selectFromEl.selectByIndex(0);

        Select selectToEl = new Select(getWebElement(By.xpath(toAccountSelectField)));
        selectToEl.selectByIndex(1);
    }

    public void clickOnTransferButton() {
        WebElement transferBtnEl = getWebElement(By.xpath(transferBtn));
        transferBtnEl.click();
    }

    public String getTxtTransferStatusResult() {
        WebElement resultEl = getWebElement(By.xpath(txtTransferStatusResult));
        return resultEl.getText();
    }

    public void clickOnFirstAccountFromList() {
        WebElement firstAccountLinkEl = getWebElement(By.xpath(firstAccountFromListLinkHref));
        firstAccountLinkEl.click();
    }

    public String getTxtAccountDetails() {
        WebElement resultEl = getWebElement(By.xpath(txtAccountDetails));
        return resultEl.getText();
    }

    public void clickOnGoBtn() {
        WebElement goBtnEl = getWebElement(By.xpath(goButton));
        goBtnEl.click();
    }


}
