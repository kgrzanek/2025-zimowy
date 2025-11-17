// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.builder;

public class OneLargeTest {

  public static void main(String[] args) {
    final var oneLarge = OneLarge.builder()
        .city("Łódź")
        .petName("Azorek")
        .build();

    IO.println(oneLarge);
  }

}
