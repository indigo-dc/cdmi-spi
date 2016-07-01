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
import org.indigo.cdmi.spi.StorageBackendFactory;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * A StorageBackend that wraps acts as a proxy to some other StorageBackend that is discovered via
 * SPI.
 */
public class ConfigurableStorageBackend extends WrappedStorageBackend {
  /**
   * Produces a new storage back-end specified by the given type with given properties.
   * 
   * @param type the type of the storage back-end to produce, can not be null
   * @param properties the properties for the back-end to produce, can not be null
   * @return a {@link StorageBackend} specified by the given type
   */
  public static StorageBackend createStorageBackend(String type, Map<String, String> properties) {
    ServiceLoader<StorageBackendFactory> loader = ServiceLoader.load(StorageBackendFactory.class);

    for (StorageBackendFactory factory : loader) {
      if (factory.getType().equals(type)) {
        return factory.createStorageBackend(requireNonNull(properties));
      }
    }

    throw new IllegalArgumentException("No QoS plugin supports " + type);
  }

  private ConfigurableStorageBackend(String type, Map<String, String> properties) {
    super(createStorageBackend(requireNonNull(type), requireNonNull(properties)));
  }
}
