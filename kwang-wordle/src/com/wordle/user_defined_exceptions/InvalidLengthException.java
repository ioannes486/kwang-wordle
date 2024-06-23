package com.wordle.user_defined_exceptions;

public class InvalidLengthException extends Exception {

  public InvalidLengthException(String message) {
    super(message);
  }
}
