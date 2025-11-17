// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san;

class Program61 {

  static Thread test1() {
    return new Thread(() -> {
      Threads.sleep(2000);
      Program6.isRunning = false;
    });
  }

}
