// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.greeting.entity;

public record GreetingPK(long pk1, long pk2) {

  public GreetingPK {
    if ((pk1 < 0) || (pk2 < 0))
      throw new IllegalArgumentException();
  }

}
