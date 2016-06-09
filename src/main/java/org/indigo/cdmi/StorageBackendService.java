/*
 * Copyright 2016 Karlsruhe Institute of Technology (KIT)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

import org.indigo.cdmi.spi.StorageBackend;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class StorageBackendService {

  private static StorageBackendService service;
  private ServiceLoader<StorageBackend> loader;

  private StorageBackendService() {
    loader = ServiceLoader.load(StorageBackend.class);
  }

  public static synchronized StorageBackendService getInstance() {
    if (service == null) {
      service = new StorageBackendService();
    }
    return service;
  }


  public Map<String, String> getCapabilities() {
    Map<String, String> capabilities = null;
    try {
      Iterator<StorageBackend> storageBackends = loader.iterator();
      while (capabilities == null && storageBackends.hasNext()) {
        // TODO: handle multiple back-ends?
        StorageBackend backend = storageBackends.next();
        capabilities = backend.capabilities();
      }
    } catch (ServiceConfigurationError error) {
      capabilities = null;
      error.printStackTrace();
    }
    return capabilities;
  }
}
