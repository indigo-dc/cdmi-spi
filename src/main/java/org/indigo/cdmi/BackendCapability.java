/*
 * Copyright 2016 Karlsruhe Institute of Technology (KIT)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

import java.util.Map;

/**
 * Representation of the QoS capabilities of a storage back-end.
 */
public class BackendCapability {

  public enum CapabilityType {
    CONTAINER, DATAOBJECT
  }

  private String name;
  private CapabilityType type;

  private Map<String, Object> capabilities;
  private Map<String, Object> metadata;

  /**
   * Creates a new {@link BackendCapability} object.
   * 
   * @param name the name of the object
   * @param type the {@link CapabilityType}, e.g. container or data object
   */
  public BackendCapability(String name, CapabilityType type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Gets the name of this back-end capability object, e.g. "silver".
   * 
   * @return the name of this back-end capability object
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this back-end capability object, e.g. "silver".
   * 
   * @param name the name of this back-end capability object
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the {@link CapabilityType} of this back-end capability object, e.g. container or data
   * object.
   * 
   * @return the {@link CapabilityType} of this back-end capability object
   */
  public CapabilityType getType() {
    return type;
  }

  /**
   * Sets the {@link CapabilityType} of this back-end capability object, e.g. container or data
   * object.
   * 
   * @param type the {@link CapabilityType} of this back-end capability object
   */
  public void setType(CapabilityType type) {
    this.type = type;
  }

  /**
   * Gets a {@link Map} with the provided capabilities of this object as key-value pairs, e.g.
   * "cdmi_capabilities_templates", "true".
   * 
   * @return a {@link Map} with the provided capabilities
   */
  public Map<String, Object> getCapabilities() {
    return capabilities;
  }

  /**
   * Sets the provided capabilities for this object as key-value pairs, e.g.
   * "cdmi_capabilities_templates", "true".
   * 
   * @param capabilities a {@link Map} with the provided capabilities
   */
  public void setCapabilities(Map<String, Object> capabilities) {
    this.capabilities = capabilities;
  }

  /**
   * Gets a {@link Map} with the provided QoS meta-data of this object as key-value pairs, e.g.
   * "cdmi_latency", "100".
   * 
   * @return a {@link Map} with the objects QoS meta-data
   */
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  /**
   * Sets the provided QoS meta-data for this object as key-value pairs, e.g. "cdmi_latency", "100".
   * 
   * @param metadata a {@link Map} with the objects QoS meta-data
   */
  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return "BackendCapability [" + (name != null ? "name=" + name + ", " : "")
        + (type != null ? "type=" + type + ", " : "")
        + (capabilities != null ? "capabilities=" + capabilities + ", " : "")
        + (metadata != null ? "metadata=" + metadata : "") + "]";
  }
}
