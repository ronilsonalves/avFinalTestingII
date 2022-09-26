package com.parasoft.parabank;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

@Tag("IntegrationTests")
public class APIRestTest {

    private static final Logger LOGGER = Logger.getLogger(APIRestTest.class.getName());
    // Para obter o JSESSIONID, é necessário realizar o login no site do ParaBank, e obter o valor do cookie.
    // Então, basta substituir o valor abaixo pelo valor do cookie. O Cookie abaixo é do usuario criado no teste
    // automatizado com o Selenium. RegisterPageTest.java
    private static final String JSESSIONID = "JSESSIONID=7B3355CEF0DD51329E1686A906BACD38";

    // Ao usar as URLs da aplicação front-end será necessário que o usuário esteja logado para que o teste funcione.
    // Para isso, utilize o JSESSIONID gerado após o login no site.
    protected static final String URL_TEMPLATE = "https://parabank.parasoft.com/parabank/";
    protected static final String URL_TEMPLATE_API = "https://parabank.parasoft.com/parabank/services/bank/";

    // Ao usar o endpoint que contém o services_proxy o mesmo irá requerer autenticação, por isso, é necessário passar o JSESSIONID.
    protected static final String URL_TEMPLATE_API_PROXIED = "https://parabank.parasoft.com/parabank/services_proxy/bank/";

    @Test
    @DisplayName("Register Account Status Code Test")
    public void givenThatIPerformAGetRequest_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        given().
                when().
                get(URL_TEMPLATE+"register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Open New Account Test")
    public void givenThatIPerformAPostRequest_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        JSONObject requestParams = new JSONObject();
        requestParams.put("customerId", "andremendes");
        given()
                .when()
                .post(URL_TEMPLATE_API + "createAccount/?customerId=12545&newAccountType=1" +
                        "&fromAccountId=14454").
                then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Accounts Overview Test")
    public void givenThatIPerformAGetRequestToAccountOverview_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        given().
                when()
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                .get(URL_TEMPLATE + "overview.htm")
                .then()
                //.extract().response().prettyPrint(); // Para imprimir o body da resposta
                .statusCode(200);
    }

    @Test
    @DisplayName("Transfer Funds Test")
    public void givenThatIPerformAPostRequestToTransferFunds_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        given()
                .when()
                //.post(URL_TEMPLATE_API + "transfer?fromAccountId=14454&toAccountId=14565&amount=33")
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                .post(URL_TEMPLATE_API_PROXIED + "transfer?fromAccountId=14454&toAccountId=14565&amount=31")
                .then()
                //.extract().response().prettyPrint(); // Para imprimir o body da resposta
                .statusCode(200);
    }

    @Test
    @DisplayName("Account`s Activities Test")
    public void givenThatIPerformAGetRequestToAccountActivities_whenIGetTheResponseCode_theTheResponseStatusCodeIs200() throws Exception {
        given()
                .when()
                //Para que o teste funcione é necessário realizar o login no navegador e pegar os valores do cookie JSESSIONID
                .header("Cookie", JSESSIONID)
                //.get(URL_TEMPLATE_API + "accounts/13566/transactions/month/All/type/All")
                .get(URL_TEMPLATE_API_PROXIED + "accounts/13566/transactions/month/All/type/All")
                .then()
                //.extract().response().body().prettyPrint(); // Para imprimir o body da resposta
                .statusCode(200);
    }

}
