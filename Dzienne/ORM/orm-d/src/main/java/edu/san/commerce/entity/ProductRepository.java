// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.entity;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product, UUID> {

}
