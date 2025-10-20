// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.abstract_factory;

import java.util.Objects;

record Profile(ProfileId profileId, Email email) {

  static <T> Profile of(ProfileIdFactory<T> profileIdFactory, T arg, Email email) {
    return new Profile(profileIdFactory.createProfileId(arg), email);
  }

  Profile {
    Objects.requireNonNull(profileId);
    Objects.requireNonNull(email);

    if (email.value.isBlank())
      throw new IllegalArgumentException();
  }
}
