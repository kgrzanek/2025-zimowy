// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.business;

public interface ProfileFactory {

  public Profile createProfile();

  public Profile createProfileWithEmail(String email);

}
