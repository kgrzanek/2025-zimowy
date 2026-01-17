// © 2026 Konrad Grzanek <kongra@gmail.com>
package edu.san.readerswriters;

import edu.san.Threads;

public class Writer implements Runnable {

  private final ReadingRoom readingRoom;

  public Writer(ReadingRoom readingRoom) {
    super();
    this.readingRoom = readingRoom;
  }

  @Override
  public void run() {
    while (true) {
      IO.print("Pisarz: odpoczywam");
      Threads.sleep(Threads.randomMillis(2000L));
      IO.print("Pisarz: wchodzę");
      readingRoom.enterForWriting();
      IO.print("Pisarz: piszę");
      Threads.sleep(Threads.randomMillis(3000L));
      IO.print("Pisarz: wychodzę");
      readingRoom.exitAfterWriting();
    }


  }

}
