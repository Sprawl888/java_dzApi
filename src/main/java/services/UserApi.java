package services;

import DTO.User;
import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class UserApi {
    private final String BASE_URL = "https://petstore.swagger.io/v2";
    private final String SWAGGER_JSON = "https://petstore.swagger.io/v2/swagger.json";
    private final OpenApiValidationFilter ValidationFilter = new OpenApiValidationFilter(SWAGGER_JSON);
    private static RequestSpecification spec;
    private static RequestSpecification spec2;
    private static RequestSpecification spec3;

    public UserApi(){
    spec = given()
            .log().all()
            .baseUri(BASE_URL)
            .filter(ValidationFilter)
            .contentType(ContentType.JSON);

    spec2 = given()
            .log().all()
            .baseUri(BASE_URL)
            .filter(ValidationFilter);

    spec3 = given()
            .log().all()
            .baseUri(BASE_URL)
            .contentType(ContentType.JSON);
    }


    public Response createOneUser(User user) {
       return given(spec)

               .body(user)
               .when()
               .post("/user");
    }
    public static Response createArrayUser(User[] users) {
        return given(spec)
                .body(users)
                .when()
                .post("/user/createWithArray");
    }
    public static Response createListUser(ArrayList<User> users){
        return given(spec)
                .body(users)
                .when()
                .post("/user/createWithList");
    }

    public static Response getUserByName(String name){
        return given(spec2)
                .when()
                .get("/user/" + name);
    }

    public Response updateUserByName(String name, User user){
        return given(spec3)
                .body(user)
                .when()
                .put("/user/" + name);
    }

    public Response deleteUserByName(String name, User user){
        return given(spec3)
                .body(user)
                .when()
                .delete("/user/" + name);
    }

    public  Response getLoginUser(String name, String password){
        return given(spec3)
                .when()
                .get("/user/login?"+ "username=" + name + "&password=" + password);
    }

    public  Response getLoginOut(){
        return given(spec3)
                .when()
                .get("/user/logout");

    }
}
