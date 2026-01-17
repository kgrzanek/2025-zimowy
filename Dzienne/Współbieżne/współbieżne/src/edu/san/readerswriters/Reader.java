// © 2026 Konrad Grzanek <kongra@gmail.com>
package edu.san.readerswriters;

import edu.san.Threads;

public class Reader implements Runnable {

  private final ReadingRoom readingRoom;

  public Reader(ReadingRoom readingRoom) {
    super();
    this.readingRoom = readingRoom;
  }

  @Override
  public void run() {
    while (true) {
      IO.print("Czytelnik: odpoczywam");
      Threads.sleep(Threads.randomMillis(1000L));
      IO.print("Czytelnik: wchodzę");
      readingRoom.enterForReading();
      IO.print("Czytelnik: czytam");
      Threads.sleep(Threads.randomMillis(2000L));
      IO.print("Czytelnik: wychodzę");
      readingRoom.exitAfterReading();
    }
  }

}
