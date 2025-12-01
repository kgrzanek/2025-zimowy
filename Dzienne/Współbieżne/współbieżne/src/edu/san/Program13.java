// © 2024 Konrad Grzanek <kongra@gmail.com>
package edu.san;

public class Program13 {

  public static void main(String[] args) {
    try (DynVar<Long> number = DynVar.initially(0L)) {
      IO.println("--1 " + number.value());

      number.binding(5L, () -> {
        IO.println("--2 " + number.value());
        number.binding(7L, () -> {
          IO.println("--3 " + number.value());
        });
      });

    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

}
