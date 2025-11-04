// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.builder;

public class OneLargeTest {

  public static void main(String[] args) {
    var onelarge = OneLarge.builder()
      .petName("Doggo")
      .age(28)
      .build();

    IO.println(onelarge);
  }

}
