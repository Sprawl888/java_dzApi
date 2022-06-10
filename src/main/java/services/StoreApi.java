package services;

import DTO_STORE.Store;
import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class StoreApi {

    private final String BASE_URL = "https://petstore.swagger.io/v2";
    private final String SWAGGER_JSON = "https://petstore.swagger.io/v2/swagger.json";
    private final OpenApiValidationFilter ValidationFilter = new OpenApiValidationFilter(SWAGGER_JSON);
    private static RequestSpecification spec;
    private static RequestSpecification spec2;
    private static RequestSpecification spec3;


    public StoreApi(){
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
    public Response postStoreOrder(Store store) {
        return given(spec3)
                .body(store)
                .when()
                .post("/store/order");

    }

    public static Response getStoreOrderId(String id){
        return given(spec3)
                .body("")
                .when()
                .get("/store/order/" + id);
    }

    public static Response deleteStoreOrderId(String id){
        return given(spec3)
                .when()
                .delete("/store/order/" + id);
    }

    public static Response getStoreInventory(){
        return given(spec3)
                .body("")
                .when()
                .get("/store/inventory");
    }

}
