package com.parasoft.parabank;

import com.parasoft.parabank.Page.AccountPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageTest {

    private static AccountPage accountPage;

    @BeforeAll
    public static void setUp() {
        accountPage = new AccountPage() ;
        accountPage.openApp();
        accountPage.clickInRegisterLinkHref();
    }

    @Test
    @DisplayName("Register Test")
    public void testRegister() throws InterruptedException {
        // Ao rodar este teste sem limpar o banco de dados da aplicação com os dados abaixo o mesmo irá falhar.
        accountPage.insertRegisterDataFields("André","Mendes","234 St.","New York",
                "10010","NY","737-345-4444","050-98-2222","andremendes",
                "andremendes123", "andremendes123");
        accountPage.clickRegisterBtn();
        Thread.sleep(2000);
        assertTrue(accountPage.getRegisterResult().contains("Your account was created successfully. You are now " +
                "logged in."));
    }

    @AfterAll
    public static void tearDown() {
        accountPage.quitDrive();
    }

}
