/*
 * Copyright 2016 Karlsruhe Institute of Technology (KIT)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package org.indigo.cdmi;

import java.util.List;
import java.util.Map;

/**
 * Immutable representation of the status of a CDMI object.
 *
 */
public final class CdmiObjectStatus {

  private final String currentCapabilitiesUri;
  private final String targetCapabilitiesUri;
  private final Map<String, Object> monitoredAttributes;
  private Map<String, Object> exportAttributes;
  private List<String> children;

  /**
   * Creates a new {@link CdmiObjectStatus}.
   * 
   * @param monitoredAttributes a {@link Map} with the monitored attributes for this object, e.g.
   *        "cdmi_latency_provided", "100"
   * @param currentCapabilitiesUri the current capabilitiesUri (reference to set of QoS attributes)
   * @param targetCapabilitiesUri the target capabilitiesUri (reference to set of QoS attributes),
   *        if a transition from the current capabilitiesUri to the target capabilitiesUri has been
   *        requested if no transition has been requested the value should be null.
   */
  public CdmiObjectStatus(Map<String, Object> monitoredAttributes, String currentCapabilitiesUri,
      String targetCapabilitiesUri) {
    this.monitoredAttributes = monitoredAttributes;
    this.currentCapabilitiesUri = currentCapabilitiesUri;
    this.targetCapabilitiesUri = targetCapabilitiesUri;
  }

  /**
   * Gets the children for a CDMI object.
   *
   * @return the children
   */
  public List<String> getChildren() {
    return children;
  }

  /**
   * Gets the children for a CDMI object.
   *
   * @param children the children to set
   */
  public void setChildren(List<String> children) {
    this.children = children;
  }

  /**
   * Gets the attributes for alternative protocols exported via CDMI.
   *
   * @return the exportAttributes
   */
  public Map<String, Object> getExportAttributes() {
    return exportAttributes;
  }

  /**
   * Gets the attributes for alternative protocols exported via CDMI.
   *
   * @param exportAttributes the exportAttributes to set
   */
  public void setExportAttributes(Map<String, Object> exportAttributes) {
    this.exportAttributes = exportAttributes;
  }

  /**
   * Gets the current capablitiesUri (reference to set of QoS attributes) for this object.
   * 
   * @return the current capabilitiesUri
   */
  public String getCurrentCapabilitiesUri() {
    return currentCapabilitiesUri;
  }

  /**
   * Gets the target capablitiesUri (reference to set of QoS attributes) for this object.
   * 
   * @return the target capabilitiesUri, if a transition from the current capabilitiesUri to the
   *         target capabilitiesUri has been requested, else null
   */
  public String getTargetCapabilitiesUri() {
    return targetCapabilitiesUri;
  }

  /**
   * Gets the monitored attributes of this object, e.g. "cdmi_latency_provided", "100".
   * 
   * @return a {@link Map} of monitored attribute for this object, e.g. the current provided latency
   *         as key-value pairs ("cdmi_latency_provided", "100")
   */
  public Map<String, Object> getMonitoredAttributes() {
    return monitoredAttributes;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CdmiObjectStatus ["
        + (currentCapabilitiesUri != null
            ? "currentCapabilitiesUri=" + currentCapabilitiesUri + ", " : "")
        + (targetCapabilitiesUri != null ? "targetCapabilitiesUri=" + targetCapabilitiesUri + ", "
            : "")
        + (monitoredAttributes != null ? "monitoredAttributes=" + monitoredAttributes + ", " : "")
        + (exportAttributes != null ? "exportAttributes=" + exportAttributes : "") + "]";
  }
}
