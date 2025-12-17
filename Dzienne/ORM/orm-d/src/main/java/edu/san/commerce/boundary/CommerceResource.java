// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.boundary;

import edu.san.commerce.control.CommerceController;
import edu.san.commerce.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("commerce/")
public class CommerceResource {

  private final CommerceController commerceController;

  public CommerceResource(CommerceController commerceController) {
    super();
    this.commerceController = commerceController;
  }

  public ProductByIdResponse getProductById(ProductByIdQuery query) {
    Product product = commerceController
        .findProductById(query.id())
        .orElseThrow(IllegalArgumentException::new);
    return new ProductByIdResponse(product);
  }

}
