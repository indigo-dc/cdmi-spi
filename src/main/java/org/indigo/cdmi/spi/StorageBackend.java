/*
 * Copyright 2016 Karlsruhe Institute of Technology (KIT)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi.spi;

import org.indigo.cdmi.TransitionStatus;

import java.util.Map;

public interface StorageBackend {

  /**
   * Provides the available capabilities of the back-end.
   * 
   * @return the provided capabilities
   */
  Map<String, Object> capabilities();

  /**
   * Starts a data object transition to the specified capabilities URI.
   * 
   * @param path the path to the data object
   * @param capabilitiesUri the target capabilities URI
   */
  void updateDataObject(String path, String capabilitiesUri);

  /**
   * Starts a container transition to the specified capabilities URI.
   * 
   * @param path the path to the data object
   * @param capabilitiesUri the target capabilities URI
   */
  void updateContainerObject(String path, String capabilitiesUri);

  /**
   * Gets the current transition status of the CDMI object.
   * 
   * @param path the path of the data object or container
   * @return the {@link TransitionStatus}
   */
  TransitionStatus getCurrentStatus(String path);

  /**
   * Gets the monitored attributes of the back-end, e.g. "cdmi_latency_provided".
   * 
   * @return the monitored attributes of the back-end
   */
  Map<String, Object> getMonitoringAttributes();
}
