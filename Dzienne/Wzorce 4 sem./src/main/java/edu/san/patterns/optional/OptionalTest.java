// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OptionalTest {

  static Optional<Long> safeDiv(long n, long d) {
    return d == 0 ? Optional.empty() : Optional.of(n / d);
  }

  static long inc(long n) {
    return n + 1;
  }

  static <T> Function<T, Optional<T>> liftM(UnaryOperator<T> f) {
    return n -> Optional.of(f.apply(n));
  }

  public static void main(String[] args) {
    final Optional<String> something = Optional.ofNullable(null);
    IO.println(something);
    IO.println(safeDiv(4, 0));

    IO.println(safeDiv(5, 3).flatMap(liftM(OptionalTest::inc)));
  }

}
