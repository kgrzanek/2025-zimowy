// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

public class Program5 {

  public static void main(String[] args) {
    IO.println("main starts");

    final var monitor = new Object();

    final var t1 = new Thread(() -> {
      IO.println("t1 starts");
      synchronized (monitor) {
        IO.println("t1 calls monitor.wait()");
        Threads.run(monitor::wait);
      }
      IO.println("t1 ends");
    });
    // t1.setDaemon(true);
    t1.start();

    Threads.sleep(1000);

    synchronized (monitor) {
      IO.println("main calls monitor.notify()");
      monitor.notifyAll();
    }

    Threads.run(t1::join);
    IO.println("main ends");
  }

}
