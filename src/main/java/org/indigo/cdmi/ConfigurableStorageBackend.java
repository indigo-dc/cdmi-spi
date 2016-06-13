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
import org.indigo.cdmi.spi.StorageBackendFactory;

import java.util.Map;
import java.util.ServiceLoader;

import static java.util.Objects.requireNonNull;

/**
 * A StorageBackend that wraps acts as a proxy to some other StorageBackend that is discovered via
 * SPI.
 */
public class ConfigurableStorageBackend extends WrappedStorageBackend {
  private static StorageBackend createStorageBackend(String type, Map<String, String> properties) {
    ServiceLoader<StorageBackendFactory> loader = ServiceLoader.load(StorageBackendFactory.class);

    for (StorageBackendFactory factory : loader) {
      if (factory.getType().equals(type)) {
        return factory.createStorageBackend(properties);
      }
    }

    throw new IllegalArgumentException("No QoS plugin supports " + type);
  }

  private ConfigurableStorageBackend(String type, Map<String, String> properties) {
    super(createStorageBackend(requireNonNull(type), requireNonNull(properties)));
  }
}
