package com.parasoft.parabank.front;

import com.parasoft.parabank.Page.AccountPage;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("RegressionTests")
public class A02AccountPageTest {

    private static Logger LOGGER = Logger.getLogger(A02AccountPageTest.class.getName());

    private static AccountPage accountPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        LOGGER.info("Starting test...");
        LOGGER.warning("We are running this tests using the user generated in the RegisterPageTest");
        accountPage = new AccountPage() ;
        accountPage.openApp();
        accountPage.insertLoginDataFields("andremendes", "andremendes123");
        accountPage.clikLoginBtn();
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("C1_Add Account Test")
    public void testAddAccount() throws InterruptedException {
        accountPage.clickOnOpenNewAccountLink();
        accountPage.performActionOpenNewAccount();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtOpenNewAccountResult().contains("Congratulations, your account is now open."));
        LOGGER.info(accountPage.getTxtOpenNewAccountResult());
    }

    @Test
    @DisplayName("C2_Accounts Overview Test")
    public void testAccountsOverview() throws InterruptedException {
        Thread.sleep(2000);
        accountPage.clickOnAccountsOverview();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtAccountsOverviewPage().contains("*Balance includes deposits that may be subject to holds"));
    }

    @Test
    @DisplayName("C3_Transfer Funds Test")
    public void testTransferFunds() throws InterruptedException {
        Thread.sleep(2000);
        accountPage.clickOnTransferFundsLink();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtTransferFundsPage().contains("Transfer Funds"));
        accountPage.insertTransferData("12");
        accountPage.clickOnTransferButton();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtTransferStatusResult().contains("Transfer Complete!"));
    }

    @Test
    @DisplayName("C4_Account's Activities Test")
    public void testAccountsActivitiesTest() throws InterruptedException {
        Thread.sleep(2000);
        accountPage.clickOnAccountsOverview();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtAccountsOverviewPage().contains("*Balance includes deposits that may be subject to holds"));
        accountPage.clickOnFirstAccountFromList();
        Thread.sleep(2000);
        assertTrue(accountPage.getTxtAccountDetails().contains("Account Details"));
        // Dado que seguindo as instru????es do teste informa pra selecionar All em todos os selects e visto que os mesmos
        // j?? encontram-se por padr??o selecionados, esses passos n??o foram reproduzidos no c??digo. Eventualmente essa
        // tela poder?? ser alterada e a?? sim entendemos a necessidade de uma manuten????o no teste ser realizada.
        accountPage.clickOnGoBtn();
    }

    @AfterEach
    public void tearDown() {
        accountPage.quitDrive();
    }
}
