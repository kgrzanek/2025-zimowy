// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.builder;

public class LargeOneTest {

  public static void main(String[] args) {
    final var large1 = LargeOne.builder()
        .age(27)
        .email("john@altalavista.com")
        .firstName("John")
        .build();

    IO.print(large1);
  }
}
