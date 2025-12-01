// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san;

public final class ScopedVar<T> {

  public static <T> ScopedVar<T> initially(T defaultValue) {
    return new ScopedVar<>(defaultValue);
  }

  private final ScopedValue<T> scopedValue;

  private final T defaultValue;

  private ScopedVar(T defaultValue) {
    scopedValue = ScopedValue.newInstance();
    this.defaultValue = defaultValue;
  }

  public T value() {
    return scopedValue.orElse(defaultValue);
  }

  public void binding(T value, Runnable body) {
    ScopedValue.where(scopedValue, value).run(body);

  }

}
