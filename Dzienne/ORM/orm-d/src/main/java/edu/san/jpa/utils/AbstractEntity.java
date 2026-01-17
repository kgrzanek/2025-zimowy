// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.jpa.utils;

import java.util.Objects;

public abstract class AbstractEntity<I, T extends AbstractEntity<I, T>> {

  public abstract I getId();

  @Override
  public final int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public final boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!getClass().isInstance(obj))
      return false;

    @SuppressWarnings("unchecked")
    final var other = (T) obj;
    return Objects.equals(getId(), other.getId());
  }

}
