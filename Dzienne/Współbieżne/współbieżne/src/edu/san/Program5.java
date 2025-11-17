// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

public class Program5 {

  public static void main(String[] args) {
    System.out.println("main starts");

    final var monitor = new Object();

    final var t1 = new Thread(() -> {
      System.out.println("t1 starts");
      synchronized (monitor) {
        System.out.println("t1 calls monitor.wait()");
        Threads.run(monitor::wait);
      }
      System.out.println("t1 ends");
    });
    // t1.setDaemon(true);
    t1.start();

    Threads.sleep(1000);

    synchronized (monitor) {
      System.out.println("main calls monitor.notify()");
      monitor.notify();
    }

    Threads.run(t1::join);
    System.out.println("main ends");
  }

}
