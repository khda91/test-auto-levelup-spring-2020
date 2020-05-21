package lesson.api.rest.trello;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public abstract class TrelloApiBaseTest {

    protected RequestSpecification requestSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/")
                .addQueryParam("key", "e73ecdfe9fa6c8e5e50efc10ddb09e74")
                .addQueryParam("token", "7a5f868fe44e8d7197100a8c8dfd38bf7cbbff5c7bf94b340fee807b9770375b")
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
        RestAssured.requestSpecification = requestSpecification;
    }
}
