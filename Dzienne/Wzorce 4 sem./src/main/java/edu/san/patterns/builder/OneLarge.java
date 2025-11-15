// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.builder;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class OneLarge {

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

}
