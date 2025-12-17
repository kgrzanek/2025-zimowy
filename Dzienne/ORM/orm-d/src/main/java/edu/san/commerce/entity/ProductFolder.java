// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.commerce.entity;

import java.util.UUID;

import edu.san.jpa.utils.AbstractEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductFolder extends AbstractEntity<UUID, ProductFolder> {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @Override
  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}