/*
 * Copyright 2016 Deutsches Elektronen-Synchrotron (DESY)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi.spi;

import java.util.Map;

/**
 * Plugins interface with some backend storage system, allowing control over the
 * Quality of Service (QoS) of data stored within that system and providing
 * some monitoring capabilities.  Such QoS plugins must provide one or more
 * classes that implement StorageBackendFactory.
 * <p>
 * Plugins must also register their StorageBackendFactory classes by including
 * the file
 * {@literal META-INF/services/org.indigo.cdmi.spi.StorageBackendFactory} within
 * their jar file.  This file must provide a simple list the fully qualified
 * class name of the classes that implement StorageBackendFactory; e.g.,
 * <pre>
 * org.example.cdmi.FooStorageFactory
 * org.example.cdmi.BarStorageFactory
 * </pre>
 */
public interface StorageBackendFactory
{
    /**
     * Factory method. Creates a new instance of StorageBackend for this
     * storage system.
     * @throws IllegalArgumentException if the properties are insufficient or
     * wrong.
     */
    StorageBackend createStorageBackend(Map<String,String> properties) throws IllegalArgumentException;

    /**
     * Provide a short (one line) description of the storage backend.  This is
     * intended to provide more meaningful messages for human consumption
     * compared to the response to {@link #getType()}.
     */
    String getDescription();

    /**
     * Returns a string identifier for this storage backend type.  This is
     * intended to allow the admin to configure which StorageBackend is
     * required.
     */
    String getType();
}
