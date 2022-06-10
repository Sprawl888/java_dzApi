package usersApi;

import DTO.User;
import DTO.UserOut;
import services.dataGenerator.UserGenerator;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import services.UserApi;

import java.util.ArrayList;

import static org.hamcrest.Matchers.lessThan;

public class usersApiTest {
    private UserApi userApi = new UserApi();

    @Test
    public void createValidUserTest(){
      User user = UserGenerator.getUser();

      Response response = userApi.createOneUser(user);

      UserOut actual = response.then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .time(lessThan(3000L))
                .extract()
                .body()
                .as(UserOut.class);

      UserOut expected = UserOut.builder()
                .code(200)
                .message(user.getId().toString())
                .type("unknown")
                .build();

      Assertions.assertEquals(expected, actual);


    }
    @Test
    public void createArrayUser(){
        User[] users = {UserGenerator.getUser(), UserGenerator.getUser()};
        Response response = UserApi.createArrayUser(users);

        UserOut actual = response.then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .time(lessThan(3000L))
                .extract()
                .body()
                .as(UserOut.class);

        UserOut expected = UserOut.builder()
                .code(200)
                .message("ok")
                .type("unknown")
                .build();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void createListUserTest(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(UserGenerator.getUser());
        users.add(UserGenerator.getUser());
        users.add(UserGenerator.getUser());

        Response response = UserApi.createListUser(users);

        UserOut actual = response.then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .time(lessThan(3000L))
                .extract()
                .body()
                .as(UserOut.class);

        UserOut expected = UserOut.builder()
                .code(200)
                .message("ok")
                .type("unknown")
                .build();

        Assertions.assertEquals(expected, actual);

    }


    @ParameterizedTest
    @ValueSource(strings = {"admin", "name", "user"})
    public void getUserTest(String name){
//        name = "USER NAME";

        Response response = UserApi.getUserByName(name);

        UserOut actual = response.then()
                .log().all()
                .statusCode(404)
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(UserOut.class);

        UserOut expected = UserOut.builder()
                .code(1)
                .message("User not found")
                .type("error")
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest(){
    User user = UserGenerator.getExistUser();
    String name = "admin";

    Response response = userApi.updateUserByName(name, user);

    UserOut actual = response.then()
            .log().all()
            .statusCode(200)
            .time(lessThan(4000L))
            .extract()
            .body()
            .as(UserOut.class);

    UserOut expected = UserOut.builder()
            .code(200)
            .message("")
            .type("unknown")
            .build();

    Assertions.assertEquals(expected, actual);

    }
    @Test
    public void deleteUserTest(){

    User user = UserGenerator.getExistUser();
    String name = "USER NAME";

    Response response = userApi.deleteUserByName(name, user);

    UserOut actual = response.then()
            .log().all()
            .statusCode(200)
            .time(lessThan(4000L))
            .extract()
            .body()
            .as(UserOut.class);

    UserOut expected = UserOut.builder()
            .code(200)
            .message("USER NAME")
            .type("unknown")
            .build();

    Assertions.assertEquals(expected, actual);
    }


    @Test
    public  void loginUserTest(){

        String name = "USER NAME";
        String password = "PASSWORD";

        Response response = userApi.getLoginUser(name, password);

        UserOut actual = response.then()
                .log().all()
                .statusCode(200)
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(UserOut.class);

        UserOut expected = UserOut.builder()
                .code(200)
                .message("")
                .type("unknown")
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void loginOutTest(){
        Response response = userApi.getLoginOut();

        UserOut actual = response.then()
                .log().all()
                .statusCode(200)
                .time(lessThan(4000L))
                .extract()
                .body()
                .as(UserOut.class);

        UserOut expected = UserOut.builder()
                .code(200)
                .message("ok")
                .type("unknown")
                .build();

        Assertions.assertEquals(expected, actual);

    }
}







