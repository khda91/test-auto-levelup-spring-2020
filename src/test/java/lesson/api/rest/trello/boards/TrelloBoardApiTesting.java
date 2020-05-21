package lesson.api.rest.trello.boards;

import lesson.api.rest.trello.TrelloApiBaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;

public class TrelloBoardApiTesting extends TrelloApiBaseTest {

    @Test
    public void createBoardTest() {
//        given()
//                .baseUri("https://api.trello.com/1/boards")
//                .queryParam("key", "e73ecdfe9fa6c8e5e50efc10ddb09e74")
//                .queryParam("token", "7a5f868fe44e8d7197100a8c8dfd38bf7cbbff5c7bf94b340fee807b9770375b")
//                .contentType(ContentType.JSON)
//                .log().all()
//        .when()
//                .body("{ \"name\": \"Api RestAssured Board\" }")
//                .post()
//        .then()
//                .statusCode(200)
//                .body("id", not(emptyString()),
//                        "name", equalTo("Api RestAssured Board"));

//                given()
//                        .spec(requestSpecification)
//        .when()
//                .body("{ \"name\": \"Api RestAssured Board\" }")
//                .post("boards")
//        .then()
//                .statusCode(200)
//                .body("id", not(emptyString()),
//                        "name", equalTo("Api RestAssured Board"));

        given()
                .body("{ \"name\": \"Api RestAssured Board1\" }")
                .when()
                .post("boards")
                .then()
                .statusCode(200)
                .body("id", not(emptyString()),
                        "name", equalTo("Api RestAssured Board1"));
    }

    @Test
    public void createLabelForBoardTest() {
        LabelRequest label = new LabelRequest("Test label", "pink");
        given()
                .body(label)
                .when()
                .post("boards/5ec2e1cf94e842117f9f8d9a/labels")
                .then()
                .statusCode(200);
    }

    @Test
    public void createLabelForBoardTest1() {
        LabelRequest label = new LabelRequest("Label red", "blue");
        LabelResponse labelResponse = given()
                .body(label)
                .when()
                .post("boards/5ec2e1cf94e842117f9f8d9a/labels")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(LabelResponse.class);

        System.out.println(labelResponse);
    }
}
