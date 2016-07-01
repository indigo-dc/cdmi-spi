/*
 * Copyright 2016 Deutsches Elektronen-Synchrotron (DESY)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

/**
 * Indicates that the supplied request cannot be satisfied with the supplied arguments. Repeating
 * the same request is (very unlikely) to succeed. Subsequent requests may succeed if the arguments
 * are modified.
 */
public class InvalidArgumentBackEndException extends BackEndException {
  private static final long serialVersionUID = 1L;

  public InvalidArgumentBackEndException() {
    super();
  }

  public InvalidArgumentBackEndException(String message) {
    super(message);
  }

  public InvalidArgumentBackEndException(Throwable cause) {
    super(cause);
  }

  public InvalidArgumentBackEndException(String message, Throwable cause) {
    super(message, cause);
  }
}
