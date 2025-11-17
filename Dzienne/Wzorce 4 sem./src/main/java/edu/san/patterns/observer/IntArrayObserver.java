// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.observer;

@FunctionalInterface
public interface IntArrayObserver {

  void arrayChanged(int i, int oldValue, int newValue);

}
