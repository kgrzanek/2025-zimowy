// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns;

// Zadanie. Doprowadź do sytuacji, w której będzie istniał co najwyżej 1 obiekt poniższej klasy.
// Wzorzec: Singleton
public final class TheOnlyOne implements Cloneable {

  private static class Holder {
    private static final TheOnlyOne INSTANCE = new TheOnlyOne();
  }

  public static TheOnlyOne getInstance() {
    return Holder.INSTANCE;
  }

  private TheOnlyOne() {
    IO.println("TheOnlyOne::TheOnlyOne()");
  }

  @SuppressWarnings("static-method")
  private Object readResolve() {
    return getInstance();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

}
