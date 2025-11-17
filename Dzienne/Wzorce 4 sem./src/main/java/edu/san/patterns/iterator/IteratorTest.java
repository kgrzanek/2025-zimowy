// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.iterator;

public class IteratorTest {

  public static void main(String[] args) {
    final int[] tab1 = { 5, 4, 7, 9, 3, 2 };
    IO.println();
    for (var i = 0; i < tab1.length;) {
      final var e = tab1[i];
      i++;
      IO.println(e);
    }

    IO.println();
    final var it = IntArrayIterator.of(tab1);
    while (it.hasNext()) {
      IO.println(it.next());
    }

    IO.println();
    Arr.iterable(tab1).forEach(IO::println);

    IO.println();
    for (final var e : Arr.iterable(tab1)) {
      IO.println(e);
    }

  }

}
