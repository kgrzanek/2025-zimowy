// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

import module java.base;

public class Program1 {

  static long n;

  static final Semaphore s = new Semaphore(1, true);

  public static void main(String[] args) {
    n = 0;
    final var threads = new ArrayList<Thread>();

    final var start = System.currentTimeMillis();
    for (var i = 0; i < 100; i++) {
      final var thread = new Thread(() -> {
        for (var j = 0; j < 10_000; j++) {
//          Threads.run(s::acquire);
//          try {
//            // n++;
//            final var n1 = n;
//            final var n2 = n1 + 1;
//            n = n2;
//          } finally {
//            s.release();
//          }

          Threads.acquiring(s, () -> {
            final var n1 = n;
            final var n2 = n1 + 1;
            n = n2;
          });

        }
      });

      threads.add(thread);
      thread.start();
    }

    Threads.joinAll(threads);
    IO.println("Finished with n = " + n + " in " +
        (System.currentTimeMillis() - start) + " msecs.");

    // * RACE CONDITION(S)
    // * NOT RE-ENTRANT

    foo(5);

  }

  static void foo(int i) {
    if (i == 0)
      return;

    Threads.acquiring(s, () -> {
      IO.println("foo(" + i + ")");
      foo(i-1);
    });

  }

}
