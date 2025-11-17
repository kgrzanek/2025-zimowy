// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.business;

public interface ProfileFactory {

  Profile createProfile();

  Profile createProfileWithEmail(String email);

}
