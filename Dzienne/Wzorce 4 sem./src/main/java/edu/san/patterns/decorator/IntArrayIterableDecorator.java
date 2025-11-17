// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.decorator;

import java.util.Iterator;
import java.util.Objects;

import edu.san.patterns.iterator.IntArrayIterator;

public final class IntArrayIterableDecorator implements Iterable<Integer> {

  public static IntArrayIterableDecorator of(int[] array) {
    return new IntArrayIterableDecorator(array);
  }

  private final int[] array;

  private IntArrayIterableDecorator(int[] array) {
    Objects.requireNonNull(array);
    this.array = array;
  }

  @Override
  public Iterator<Integer> iterator() {
    return IntArrayIterator.of(array);
  }

}
