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
   * Comment: More specifically, these are the capabilities corresponding to some specific quality
   * of service.
   * 
   * @return the provided capabilities as String-String key-value pairs. Non-string values e.g.
   *         numeric or array have to be parsed from the String value.
   */
  Map<String, String> capabilities();

  /**
   * Starts a CDMI object transition to the specified capabilities URI.
   * 
   * This operation
   * 
   * Comment: There should be the possiblity for this method to throw an exception; e.g., to
   * indicate that the capabilitiesUri is not known/supported; the specific transition is not
   * supported; the user is not authorised to make this transition, the path does not exist, ... The
   * transition is performed by the implementing back-end
   * 
   * @param path the path to the data object or container as it can be queried via the CDMI
   *        interface
   * @param capabilitiesUri the target capabilities URI
   */
  void updateCdmiObject(String path, String capabilitiesUri) throws RuntimeException;

  /**
   * Gets the current transition status of the CDMI object.
   * 
   * @param path the path of the data object or container
   * @return the {@link TransitionStatus}
   */
  TransitionStatus getCurrentStatus(String path);

  /**
   * Gets the monitored attributes of the back-end, e.g. "cdmi_latency_provided", for the object
   * specified by path.
   * 
   * @param path the path of the data object or container
   * @return the monitored attributes of the back-end as String-String key-value pairs. Non-string
   *         values e.g. numeric or array have to be parsed from the String value.
   */
  Map<String, String> getMonitoringAttributes();
}
