// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

import module java.base;

public class Program6 {

  static volatile boolean isRunning = true;

  public static void main(String[] args) {
    final var threads = new ArrayList<Thread>();

    final var start = System.currentTimeMillis();

    final var n = new AtomicLong(0L);

    final var thread1 = new Thread(() -> {
      IO.println("thread1.start()");
      while (isRunning) {
        n.incrementAndGet();
      }
      IO.println("thread1 ends");
    });

    threads.add(thread1);
    thread1.start();

//    final var thread2 = new Thread(() -> {
//      IO.println("thread2.sleep(2000L)");
//      Threads.sleep(2000L);
//      isRunning = false;
//      IO.println("thread2 ends");
//    });

    final var thread2 = Program61.test1();
    threads.add(thread2);
    thread2.start();

    Threads.joinAll(threads);
    IO.println("Finished with n = " + n.get() + " in " +
        (System.currentTimeMillis() - start) + " msecs.");

  }

}
