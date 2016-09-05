/*
 * Copyright 2016 Deutsches Elektronen-Synchrotron (DESY)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

import org.indigo.cdmi.spi.StorageBackend;

import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.List;

import javax.security.auth.Subject;

/**
 * JAAS provides a standard mechanism to hold information about a logged in user: the Subject class.
 * This class wraps an existing StorageBackend and provides information about the logged in user.
 * <p>
 * This class is not thread safe, in particular, the caller is responsible for ensuring a
 * happens-before relationship between {@code #setSubject} and any subsequent call to a
 * StorageBackend method.
 * </p>
 */
public class SubjectBasedStorageBackend extends WrappedStorageBackend {
  private Subject subject;

  public SubjectBasedStorageBackend(StorageBackend inner) {
    super(inner);
  }

  /**
   * Specify the subject for subsequent operations.
   * 
   * @param subject the identity of the user.
   */
  public void setSubject(Subject subject) {
    if (subject == null || subject.isReadOnly()) {
      this.subject = subject;
    } else {
      this.subject = new Subject();
      this.subject.getPrincipals().addAll(subject.getPrincipals());
      this.subject.getPublicCredentials().addAll(subject.getPublicCredentials());
      this.subject.getPrivateCredentials().addAll(subject.getPrivateCredentials());
      this.subject.setReadOnly();
    }
  }

  @Override
  public List<BackendCapability> getCapabilities() throws BackEndException {
    try {
      return Subject.doAs(subject,
          (PrivilegedExceptionAction<List<BackendCapability>>) super::getCapabilities);
    } catch (PrivilegedActionException ex) {
      Throwable th = ex.getCause();
      if (th instanceof BackEndException) {
        throw (BackEndException) th;
      }
      if (th instanceof RuntimeException) {
        throw (RuntimeException) th;
      }
      if (th instanceof Error) {
        throw (Error) th;
      }
      throw new RuntimeException("Received unexpected exception: " + th.toString(), th);
    } catch (RuntimeException | Error ex) {
      throw ex;
    }
  }

  @Override
  public void updateCdmiObject(String path, String targetCapabilitiesUri) throws BackEndException {
    try {
      Subject.doAs(subject, (PrivilegedExceptionAction<Void>) () -> {
        super.updateCdmiObject(path, targetCapabilitiesUri);
        return null;
      });
    } catch (PrivilegedActionException ex) {
      Throwable th = ex.getCause();
      if (th instanceof BackEndException) {
        throw (BackEndException) th;
      }
      if (th instanceof RuntimeException) {
        throw (RuntimeException) th;
      }
      if (th instanceof Error) {
        throw (Error) th;
      }
      throw new RuntimeException("Received unexpected exception: " + th.toString(), th);
    } catch (RuntimeException | Error ex) {
      throw ex;
    }
  }

  @Override
  public CdmiObjectStatus getCurrentStatus(String path) throws BackEndException {
    try {
      return Subject.doAs(subject, (PrivilegedExceptionAction<CdmiObjectStatus>) () -> {
        return super.getCurrentStatus(path);
      });
    } catch (PrivilegedActionException ex) {
      Throwable th = ex.getCause();
      if (th instanceof BackEndException) {
        throw (BackEndException) th;
      }
      if (th instanceof RuntimeException) {
        throw (RuntimeException) th;
      }
      if (th instanceof Error) {
        throw (Error) th;
      }
      throw new RuntimeException("Received unexpected exception: " + th.toString(), th);
    } catch (RuntimeException | Error ex) {
      throw ex;
    }
  }
}
