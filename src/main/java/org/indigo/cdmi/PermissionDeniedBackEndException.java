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
 * This exception indicates that a user made a requested for which that user is not authorised. That
 * user reissuing the request will (very likely) yield the same result. A different user issuing
 * this request may succeed.
 */
public class PermissionDeniedBackEndException extends BackEndException {
  private static final long serialVersionUID = 1L;

  public PermissionDeniedBackEndException() {
    super();
  }

  public PermissionDeniedBackEndException(String message) {
    super(message);
  }

  public PermissionDeniedBackEndException(Throwable cause) {
    super(cause);
  }

  public PermissionDeniedBackEndException(String message, Throwable cause) {
    super(message, cause);
  }
}
