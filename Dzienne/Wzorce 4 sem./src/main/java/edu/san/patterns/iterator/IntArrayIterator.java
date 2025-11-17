// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.iterator;

import java.util.Iterator;
import java.util.Objects;

public final class IntArrayIterator implements Iterator<Integer> {

  public static IntArrayIterator of(int[] array) {
    return new IntArrayIterator(array);
  }

  private final int[] array;

  private int i;

  private IntArrayIterator(int[] array) {
    Objects.requireNonNull(array);
    this.array = array;
  }

  @Override
  public boolean hasNext() {
    return i < array.length;
  }

  @Override
  public Integer next() {
    return array[i++];
  }

}
