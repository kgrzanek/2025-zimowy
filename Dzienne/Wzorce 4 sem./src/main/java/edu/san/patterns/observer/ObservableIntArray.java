// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObservableIntArray {

  public static ObservableIntArray of(int[] array) {
    return new ObservableIntArray(array.clone());
  }

  private final int[] array;

  private final List<IntArrayObserver> observers = new ArrayList<>();

  private ObservableIntArray(int[] array) {
    Objects.requireNonNull(array);
    this.array = array;
  }

  public ObservableIntArray registerObserver(IntArrayObserver observer) {
    observers.add(observer);
    return this;
  }

  private void notifyObservers(int i, int oldValue, int newValue) {
    observers.forEach(o -> o.arrayChanged(i, oldValue, newValue));
  }

  public int length() {
    return array.length;
  }

  public int set(int i, int newValue) {
    final var oldValue = array[i];
    if (oldValue != newValue) {
      array[i] = newValue;
      notifyObservers(i, oldValue, newValue);
    }
    return oldValue;
  }

  public int get(int i) {
    return array[i];
  }

  @Override
  public String toString() {
    return Arrays.toString(array);
  }


}
