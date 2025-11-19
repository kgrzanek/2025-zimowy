package edu.san;

import org.junit.jupiter.api.Test;

import edu.san.greeting.entity.Greeting;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {

  @Test
  void testHelloEndpoint() {
    var greeting1 = new Greeting();
    IO.println(greeting1.getText());

//    given()
//        .when().get("/hello")
//        .then()
//        .statusCode(200)
//        .body(is("Hello from Quarkus REST"));
  }

}