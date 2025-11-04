// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.builder;

import java.util.UUID;

public class LargeOne {

  public static Builder builder() {
    return new Builder();
  }

  private final UUID uuid;

  private final String email;

  private final String firstName;

  private final String lastName;

  private final int age;

  private final String postalCode;

  private final String street;

  private final String city;

  private final String county;

  private final String petName;

  public LargeOne(UUID uuid, String email, String firstName, String lastName,
      int age, String postalCode, String street, String city, String county,
      String petName) {
    this.uuid = uuid;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.postalCode = postalCode;
    this.street = street;
    this.city = city;
    this.county = county;
    this.petName = petName;
  }

  @Override
  public String toString() {
    return "LargeOne [uuid=" + uuid + ", email=" + email + ", firstName="
        + firstName + ", lastName=" + lastName + ", age=" + age
        + ", postalCode=" + postalCode + ", street=" + street + ", city=" + city
        + ", county=" + county + ", petName=" + petName + "]";
  }

  public static final class Builder {

    private UUID uuid = UUID.randomUUID();

    private String email;

    private String firstName;

    private String lastName;

    private int age = 18;

    private String postalCode;

    private String street;

    private String city;

    private String county = "Łódź";

    private String petName;

    private Builder() {}

    public LargeOne build() {
      return new LargeOne(uuid, email, firstName, lastName, age, postalCode,
          street, city, county, petName);
    }

    public Builder uuid(UUID uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    public Builder street(String street) {
      this.street = street;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder county(String county) {
      this.county = county;
      return this;
    }

    public Builder petName(String petName) {
      this.petName = petName;
      return this;
    }

  }

  public UUID getUuid() {
    return uuid;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getCounty() {
    return county;
  }

  public String getPetName() {
    return petName;
  }

}
