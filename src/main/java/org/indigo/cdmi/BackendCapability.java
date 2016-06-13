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

public class BackendCapability {

  public enum CapabilityType {
    CONTAINER, DATAOBJECT
  }

  private String name;
  private CapabilityType type;

  private Map<String, String> capabilities;
  private Map<String, String> metadata;


  public BackendCapability(String name, CapabilityType type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CapabilityType getType() {
    return type;
  }


  public void setType(CapabilityType type) {
    this.type = type;
  }


  public Map<String, String> getCapabilities() {
    return capabilities;
  }


  public void setCapabilities(Map<String, String> capabilities) {
    this.capabilities = capabilities;
  }


  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
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
