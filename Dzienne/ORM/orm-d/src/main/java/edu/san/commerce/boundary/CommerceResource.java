// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.boundary;

import java.util.UUID;

import edu.san.commerce.control.CommerceController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("commerce/")
public class CommerceResource {

  private final CommerceController commerceController;

  public CommerceResource(CommerceController commerceController) {
    this.commerceController = commerceController;
  }

  @GET
  @Path("products/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ProductByIdResponse getProductById(@PathParam("id") UUID id) {
    final var product = commerceController
        .findProductById(id)
        .orElseThrow(NotFoundException::new);
    return new ProductByIdResponse(product);
  }

}
