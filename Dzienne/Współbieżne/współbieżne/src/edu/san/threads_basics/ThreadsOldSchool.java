// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.threads_basics;

class ThreadsOldSchool {

  static int foo(String s) {
    IO.println("foo(" + s + ")");
    return 5;
  }

  public static void main(String... args) {
    IO.println("Działa program");
    foo("xyz");

    final var t1 = new My1stThread();
    t1.start();

    final var t2 = new Thread(() -> IO.println("t2.run()"));
    t2.start();

    final var t3 = new Thread(() -> IO.println("t3.run()"));
    t3.start();

    IO.println("main is done");
  }

}
