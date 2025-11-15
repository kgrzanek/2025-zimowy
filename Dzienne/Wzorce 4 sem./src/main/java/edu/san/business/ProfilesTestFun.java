// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.business;

import java.util.function.Function;

public class ProfilesTestFun {

  public static Profile createProfileWithEmail(
      Function<String, Profile> profileConstructor,
      String email) {
    return profileConstructor.apply(email);
  }

  public static void sendEmailToKafka(Profile profile) {
    IO.println("->Kafka : " + profile.getEmail());
  }

  public static void main(String[] args) throws IllegalArgumentException {
    Function<String, Profile> profileConstructor = null;

    final var profile = createProfileWithEmail(
        profileConstructor,
        "john.smith@gmail.com");

    sendEmailToKafka(profile);

    IO.println(profile);
  }

}
