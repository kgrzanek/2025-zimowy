// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.observer;

public class ObserversTest {

  public static void main(String[] args) {
    var tab1 = ObservableIntArray.of(new int[] { 1, 4, 5, 2, 3, 7, 0 });
    tab1.registerObserver((i, oldValue, newValue) -> {
      IO.println("tab1 has changed " + i + ", " + oldValue + ", " + newValue);
    });

    IO.println(tab1);
    tab1.set(0, 8);
    IO.println(tab1);
  }

}
