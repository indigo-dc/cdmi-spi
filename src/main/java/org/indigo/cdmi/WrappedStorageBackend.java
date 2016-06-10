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

import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * A StorageBackend that delegates all operations to some other StorageBackend
 * implementation.
 */
public class WrappedStorageBackend implements StorageBackend
{
    private final StorageBackend inner;

    public WrappedStorageBackend(StorageBackend inner)
    {
        this.inner = requireNonNull(inner);
    }

    @Override
    public Map<String, String> capabilities()
    {
        return inner.capabilities();
    }

    @Override
    public void updateCdmiObject(String path, String capabilitiesUri) throws RuntimeException
    {
        inner.updateCdmiObject(path, capabilitiesUri);
    }

    @Override
    public TransitionStatus getCurrentStatus(String path)
    {
        return inner.getCurrentStatus(path);
    }

    @Override
    public Map<String, String> getMonitoringAttributes()
    {
        return inner.getMonitoringAttributes();
    }
}
