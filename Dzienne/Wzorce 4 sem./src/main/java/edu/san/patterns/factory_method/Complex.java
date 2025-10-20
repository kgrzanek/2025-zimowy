// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns.factory_method;

import java.util.HashMap;
import java.util.Map;

class Complex {

  // To jest static factory method
  public static Complex of(double re, double im) {
    return cache.computeIfAbsent(new CacheEntry(re, im), Complex::new);
  }

  // To jest static factory method
  public static Complex of(double d) {
    return of(d, 0);
  }

  private static final Map<CacheEntry, Complex> cache = new HashMap<>();

  private static record CacheEntry(double re, double im) {}

  final double re;

  final double im;

  private Complex(CacheEntry e) {
    this(e.re, e.im);
  }

  private Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  @Override
  public String toString() {
    return "Complex [re=" + re + ", im=" + im + "]";
  }

}
