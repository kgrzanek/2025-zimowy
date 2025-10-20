// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.abstract_factory;

@FunctionalInterface
public interface ProfileIdFactory<T> {

  ProfileId createProfileId(T arg);

}
