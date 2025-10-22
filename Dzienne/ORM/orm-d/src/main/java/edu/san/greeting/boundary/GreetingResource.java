package edu.san.greeting.boundary;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;

import edu.san.ExInfo;
import io.agroal.api.AgroalDataSource;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

  private final AgroalDataSource defaultDataSource;

  private static final Logger LOG = System
      .getLogger(GreetingResource.class.getName());

  GreetingResource(AgroalDataSource defaultDataSource) {
    this.defaultDataSource = defaultDataSource;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @RunOnVirtualThread
  public String hello() {
    try (var conn = defaultDataSource.getConnection()) {
      LOG.log(Level.INFO, "conn is " + conn);
      return "Hello from Quarkus REST";
    } catch (SQLException e) {
      throw new ExInfo(e);
    }
  }
}
