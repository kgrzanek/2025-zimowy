// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.abstract_factory;

import java.util.Objects;

interface TestProfile {

  public static void main(String... args) {
    record SimpleProfileId(String s) implements ProfileId {
      SimpleProfileId {
        Objects.requireNonNull(s);
      }
    }

    var profile1 = Profile.of(SimpleProfileId::new, "profile-1",
        new Email("kgrzanek@san.edu.pl"));
    IO.println(profile1);
  }

}
