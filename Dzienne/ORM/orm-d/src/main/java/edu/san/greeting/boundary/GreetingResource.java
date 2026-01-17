package edu.san.greeting.boundary;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.UUID;

import edu.san.MyEntity;
import edu.san.addresses.Address;
import edu.san.employees.Administrator;
import edu.san.employees.AdministratorRole;
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

  @SuppressWarnings("static-access")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Transactional
  @RunOnVirtualThread
  public String hello() {
    final var myEntity = new MyEntity("Test-1");
    myEntity.persist();
    myEntity.setField("Test-1");

    final var employee = new Administrator();
    employee.setEmail("kgrzanek@san.edu.pl");
    employee.setRole(AdministratorRole.MANAGER);
    employee.persist();

    final var address = new Address();
    address.setCountry("Poland");
    address.setStreet("Piotrkowska");
    address.persist();

    employee.setMainAddress(address);

    LOG.log(Level.INFO, employee.getMainAddress());

    final var foundEmployee = (Administrator) Administrator
        .findById(UUID.randomUUID());

    LOG.log(Level.INFO, String.valueOf(foundEmployee));

    return "Hello from Quarkus REST, id: " + myEntity.getId() + ", version: "
        + myEntity.getVersion();
  }
}
