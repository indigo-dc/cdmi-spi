/*
 * Copyright 2016 Karlsruhe Institute of Technology (KIT)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

public class BackEndException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7571457631290115062L;

  public BackEndException() {
    super();
  }

  public BackEndException(String message) {
    super(message);
  }

  public BackEndException(Throwable cause) {
    super(cause);
  }

  public BackEndException(String message, Throwable cause) {
    super(message, cause);
  }

}
