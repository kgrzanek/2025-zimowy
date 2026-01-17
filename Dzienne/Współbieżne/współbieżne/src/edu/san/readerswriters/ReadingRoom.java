// © 2026 Konrad Grzanek <kongra@gmail.com>
package edu.san.readerswriters;

import java.util.concurrent.Semaphore;

import edu.san.Threads;

public class ReadingRoom {

  private final Semaphore semaphore = new Semaphore(Integer.MAX_VALUE, true);

  public void enterForReading() {
    Threads.run(() -> semaphore.acquire(1));
  }

  public void exitAfterReading() {
    semaphore.release(1);
  }

  public void enterForWriting() {
    Threads.run(() -> semaphore.acquire(Integer.MAX_VALUE));
  }

  public void exitAfterWriting() {
    semaphore.release(Integer.MAX_VALUE);
  }

}
