// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.greeting.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Greeting {

  @Id
  private UUID id;

  @Version
  private long version;

  private String whoToGreet;

  private String text;

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  public String getWhoToGreet() {
    return whoToGreet;
  }

  public void setWhoToGreet(String whoToGreet) {
    this.whoToGreet = whoToGreet;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public UUID getId() {
    return id;
  }

}
