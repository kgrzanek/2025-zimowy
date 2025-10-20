// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.threads_basics;

class My1stThread extends Thread {

  @Override
  public void run() {
    super.run();
    IO.println("My1stThread::run()");
  }

}
