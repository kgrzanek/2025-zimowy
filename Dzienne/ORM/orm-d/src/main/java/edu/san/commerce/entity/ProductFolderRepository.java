// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductFolderRepository implements PanacheRepository<ProductFolder> {

}
