// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san;

public class ExInfo extends RuntimeException {

  public ExInfo() {}

  public ExInfo(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ExInfo(String message, Throwable cause) {
    super(message, cause);
  }

  public ExInfo(String message) {
    super(message);
  }

  public ExInfo(Throwable cause) {
    super(cause);
  }

}
