package lesson.api.soap.userbgred;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.XML;
import static org.hamcrest.Matchers.equalTo;

public class DoRegisterUserTest {

    @Test
    public void doRegisterTest() {
        String email = RandomStringUtils.randomAlphanumeric(7) + "@email.com";
        String name = RandomStringUtils.randomAlphanumeric(10);
        String password = "test";
        String body = String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:wrap=\"http://foo.bar/wrappersoapserver\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <wrap:doRegister>\n" +
                "         <email>%s</email>\n" +
                "         <name>%s</name>\n" +
                "         <password>%s</password>\n" +
                "      </wrap:doRegister>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>", email, name, password);

        given()
                .log().all()
                .baseUri("http://users.bugred.ru/tasks/soap/WrapperSoapServer.php")
                .header(new Header("SOAPAction", "http://foo.bar/wrappersoapserver/#doRegister"))
                .contentType(XML)
                .body(body)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .contentType(XML)
                .body("doRegisterResponse.name", equalTo(name),
                        "doRegisterResponse.email", equalTo(email));
    }
}
