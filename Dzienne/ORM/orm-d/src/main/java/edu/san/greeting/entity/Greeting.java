// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.greeting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Version;

@Entity
@IdClass(GreetingPK.class)
public class Greeting {

  @Id
  private long pk1;

  @Id
  private long pk2;

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

}
