// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.parser;

import java.util.Objects;
import java.util.Optional;

public class ParserTest {

  static record NonBlank(String value) {
    NonBlank {
      Objects.requireNonNull(value);
    }
  }

  static Optional<NonBlank> parseNonBlank(String s) {
    if (s == null || s.isBlank())
      return Optional.empty();

    return Optional.of(new NonBlank(s));
  }

  public static void main(String[] args) {

  }

}
