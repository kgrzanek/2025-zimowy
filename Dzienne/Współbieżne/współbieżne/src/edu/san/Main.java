// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

import module java.base;

public class Main {

  private static final ExecutorService pool = Executors.newFixedThreadPool(10);

  private static long n;

  public static void main(String[] args) {
    n = 0;
    for (var i = 0; i < 100; i++) {
      pool.execute(() -> {
        for (var j = 0; j < 1_000; j++) {
          n++;
        }
      });
    }

    pool.shutdown();

    Threads.sleep(Duration.of(3, ChronoUnit.SECONDS));
    IO.println("n = " + n);
  }

}
