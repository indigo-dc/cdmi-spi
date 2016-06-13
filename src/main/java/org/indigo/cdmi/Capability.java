/*
 * Copyright (c) 2010, Sun Microsystems, Inc. Copyright (c) 2010, The Storage Networking Industry
 * Association.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 * 
 * Neither the name of The Storage Networking Industry Association (SNIA) nor the names of its
 * contributors may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.indigo.cdmi;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Representation of a CDMI <em>Capability</em>.
 * </p>
 */
public class Capability {

  // Container representation fields
  private String objectName;
  private String objectType;
  private String objectId;
  private String parentUri;
  private String parentId;
  private Map<String, String> capabilities = new HashMap<String, String>();
  private String childrenrange;
  private List<String> children = new ArrayList<String>();
  // QoS extension
  private Map<String, String> metadata = new HashMap<String, String>();

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public String getChildrenrange() {
    return childrenrange;
  }

  public void setChildrenrange(String childrenrange) {
    this.childrenrange = childrenrange;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public String getParentUri() {
    return parentUri;
  }

  public void setParentUri(String parentUri) {
    this.parentUri = parentUri;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public Map<String, String> getCapabilities() {
    return capabilities;
  }

  public List<String> getChildren() {
    return children;
  }

  public void setChildren(List<String> children) {
    this.children = children;
  }

  public Capability getByPath(String path) {
    return this;
  }

  /**
   * Serialize as Object as JSON.
   * 
   * @return {@link JSONObject}
   */
  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("capabilities", this.capabilities);
    json.put("children", this.children);
    json.put("childrenrange", this.childrenrange);
    json.put("objectID", this.objectId);
    json.put("objectName", this.objectName);
    json.put("objectType", this.objectType);
    json.put("parentID", this.parentId);
    json.put("parentURI", this.parentUri);
    json.put("capabilities", this.capabilities);
    json.put("childrenrange", this.childrenrange);
    json.put("children", this.children);
    json.put("metadata", this.metadata);
    return json;
  }
}
