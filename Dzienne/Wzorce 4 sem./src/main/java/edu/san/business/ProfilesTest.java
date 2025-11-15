// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.business;

import java.lang.reflect.InvocationTargetException;

public class ProfilesTest {

  public static Profile createProfileWithEmail(
      ProfileFactory profileFactory,
      String email) {
    return profileFactory.createProfileWithEmail(email);
  }

  public static void sendEmailToKafka(Profile profile) {
    IO.println("->Kafka : " + profile.getEmail());
  }

  public static void main(String[] args) throws ClassNotFoundException,
      InstantiationException, IllegalAccessException, IllegalArgumentException,
      InvocationTargetException, NoSuchMethodException {

    final var profileFactoryClassName = args[0];
    final var cl = Class.forName(profileFactoryClassName);

    final var profileFactory = (ProfileFactory) cl
        .getDeclaredConstructor().newInstance();

    final var profile = createProfileWithEmail(profileFactory,
        "john.smith@gmail.com");

    sendEmailToKafka(profile);

    IO.println(profile);
  }

}
