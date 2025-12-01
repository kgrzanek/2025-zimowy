// © 2023 Konrad Grzanek <kongra@gmail.com>
package edu.san;

import module java.base;

public class Program7 {

  public static void main(String[] args) {
    final var s1 = new Semaphore(1, false);
    new Thread(() -> Threads.acquiring(s1, () -> {})).start();
    new Thread(() -> Threads.acquiring(s1, () -> {})).start();
    IO.println("Done.");
  }

}
