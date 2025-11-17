// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.iterator;

import java.util.Iterator;

import edu.san.patterns.decorator.IntArrayIterableDecorator;

public final class Arr {

  public static Iterator<Integer> iterator(int[] array) {
    return IntArrayIterator.of(array);
  }

  public static Iterable<Integer> iterable(int[] array) {
    return IntArrayIterableDecorator.of(array);
  }

  private Arr() {}
}
