package usersApi;

import DTO_STORE.Store;
import DTO_STORE.StoreOut;
import services.dataGenerator.StoreGenerator;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import services.StoreApi;

import static org.hamcrest.Matchers.lessThan;

public class storeApiTest {
    private StoreApi storeApi = new StoreApi();

    @Test
    public void postStoreOrderTest(){

        Store store = StoreGenerator.getStore();

        Response response = storeApi.postStoreOrder(store);

        StoreOut actual = response.then()
                .log().all()
                .statusCode(200)
                .and()
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(StoreOut.class);

        StoreOut expected = StoreOut.builder()
                .id(actual.getId())
                .quantity(0)
                .petId(0)
                .shipDate("2022-05-27T12:02:21.155+0000")
                .status("Placed")
                .complete(true)
                .build();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getStoreOrderIdTest(){
        String id = "3";

        Response response = StoreApi.getStoreOrderId(id);

        StoreOut actual = response.then()
                .log().all()
                .statusCode(200)
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(StoreOut.class);

        StoreOut expected = StoreOut.builder()
                .id(id)
                .quantity(3)
                .petId(3)
                .shipDate("2125-03-23T01:23:44.009+0000")
                .complete(true)
                .status("placed")
                .build();

        Assertions.assertEquals(expected, actual);



    }
    @Test
    public void deleteStoreOrderId(){
        String id = "4637282031";
        Response response = StoreApi.deleteStoreOrderId(id);

        StoreOut actual = response.then()
                .log().all()
                .statusCode(200)
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(StoreOut.class);

        StoreOut expected = StoreOut.builder()
                .code(200)
                .message("4637282031")
                .type("unknown")
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getStoreInventoryTest(){

        Response response = StoreApi.getStoreInventory();
        response.then()
                .log().all()
                .statusCode(200);

        //        StoreOut actual = response.then()
//                .log().all()
//                .statusCode(200)
//                .time(lessThan(4000L))
//                .extract()
//                .body()
//                .as(StoreOut.class);

//        StoreOut expected = StoreOut.builder()
//                .code(200)
//                .message("")
//                .type("")
//                .build();
//
//        Assertions.assertEquals(expected, actual);

    }
}
