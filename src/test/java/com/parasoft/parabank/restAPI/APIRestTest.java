package com.parasoft.parabank.restAPI;

import org.junit.jupiter.api.*;
import java.util.logging.Logger;

import static io.restassured.RestAssured.*;

@Tag("IntegrationTests")
public class APIRestTest {
    private static final Logger LOGGER = Logger.getLogger(APIRestTest.class.getName());
    // Para obter o JSESSIONID, é necessário realizar o login no site do ParaBank, e obter o valor do cookie.
    // Então, basta substituir o valor abaixo pelo valor do cookie. O Cookie abaixo é do usuario criado no teste
    // automatizado com o Selenium. RegisterPageTest.java
    private static final String JSESSIONID = "JSESSIONID=1B40E9B63D76B0F54FCB17E14268A496";

    // Ao usar as URLs da aplicação front-end será necessário que o usuário esteja logado para que o teste funcione.
    // Para isso, utilize o JSESSIONID gerado após o login no site.
    protected static final String URL_TEMPLATE = "https://parabank.parasoft.com/parabank/";
    protected static final String URL_TEMPLATE_API = "https://parabank.parasoft.com/parabank/services/bank/";

    // Ao usar o endpoint que contém o services_proxy o mesmo irá requerer autenticação, por isso, é necessário passar o JSESSIONID.
    protected static final String URL_TEMPLATE_API_PROXIED = "https://parabank.parasoft.com/parabank/services_proxy/bank/";

    @BeforeAll
    public static void setUp() {
        LOGGER.info("Starting integration tests with the API REST...");
        LOGGER.warning("Using the JSESSIONID Cookie: " + JSESSIONID);
        LOGGER.warning("Please, make sure that the user is logged in the ParaBank application and have been extracted" +
                " the JSESSION Cookie value and updated here at JSESSIONID Const.");
    }

    @Test
    @DisplayName("Register Account Status Code Test")
    public void givenThatIPerformAGetRequest_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        given()
                .when()
                .get(URL_TEMPLATE+"register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Open New Account Test")
    public void givenThatIPerformAPostRequest_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        LOGGER.info("Openning a new account...");
        given()
                .when()
                .header("Cookie", JSESSIONID)
                .post(URL_TEMPLATE_API + "createAccount/?customerId=12545&newAccountType=1" +
                        "&fromAccountId=13566").
                then()
                .statusCode(200);
        LOGGER.info("Account opened successfully!");
    }

    @Test
    @DisplayName("Accounts Overview Test")
    public void givenThatIPerformAGetRequestToAccountOverview_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        LOGGER.info("Getting the accounts overview...");
        given().
                when()
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                .get(URL_TEMPLATE + "overview.htm")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Transfer Funds Test")
    public void givenThatIPerformAPostRequestToTransferFunds_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        LOGGER.info("Transfering funds...");
        given()
                .when()
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                .post(URL_TEMPLATE_API_PROXIED + "transfer?fromAccountId=14454&toAccountId=14565&amount=31")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Account`s Activities Test")
    public void givenThatIPerformAGetRequestToAccountActivities_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        LOGGER.info("Getting the account`s activities...");
        given()
                .when()
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                .get(URL_TEMPLATE_API_PROXIED + "accounts/13566/transactions/month/All/type/All")
                .then()
                .statusCode(200);
    }

}
