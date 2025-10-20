// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.factory_method;

interface TestComplex {

  public static void main(String... args) {
    var z = Complex.of(1, 2);
    IO.println(z);
  }

}
