// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.control;

import java.util.Optional;
import java.util.UUID;

import edu.san.commerce.entity.Product;
import edu.san.commerce.entity.ProductFolderRepository;
import edu.san.commerce.entity.ProductRepository;
import edu.san.commerce.entity.SKURepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommerceController {

  private final ProductFolderRepository productFolderRepository;

  private final ProductRepository productRepository;

  private final SKURepository skuRepository;

  public CommerceController(
      ProductFolderRepository productFolderRepository,
      ProductRepository productRepository,
      SKURepository skuRepository) {
    this.productFolderRepository = productFolderRepository;
    this.productRepository = productRepository;
    this.skuRepository = skuRepository;
  }

  public Optional<Product> findProductById(UUID id) {
    return productRepository.findByIdOptional(id);
  }

}
