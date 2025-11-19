package edu.san.greeting.boundary;

import java.lang.System.Logger;

import edu.san.MyEntity;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

  static final Logger LOG = System
      .getLogger(GreetingResource.class.getName());

  GreetingResource() {}

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Transactional
  @RunOnVirtualThread
  public String hello() {
    MyEntity myEntity = new MyEntity("Test-1");
    myEntity.persist();
    // myEntity.setField("Test-1");
    // myEntity.flush();
    // myEntity.delete();

    return "Hello from Quarkus REST, id: " + myEntity.getId() + ", version: "
        + myEntity.getVersion();
  }
}
