/*
 * Copyright 2016 Deutsches Elektronen-Synchrotron (DESY)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

import static java.util.Objects.requireNonNull;

import org.indigo.cdmi.spi.StorageBackend;

import java.util.List;

/**
 * A StorageBackend that delegates all operations to some other StorageBackend implementation.
 */
public class WrappedStorageBackend implements StorageBackend {
  private final StorageBackend inner;

  public WrappedStorageBackend(StorageBackend inner) {
    this.inner = requireNonNull(inner);
  }

  @Override
  public List<BackendCapability> getCapabilities() throws BackEndException {
    return inner.getCapabilities();
  }

  @Override
  public void updateCdmiObject(String path, String currentCapabilitiesUri,
      String targetCapabilitiesUri) throws BackEndException {
    inner.updateCdmiObject(path, currentCapabilitiesUri, targetCapabilitiesUri);
  }

  @Override
  public CdmiObjectStatus getCurrentStatus(String path) throws BackEndException {
    return inner.getCurrentStatus(path);
  }
}
