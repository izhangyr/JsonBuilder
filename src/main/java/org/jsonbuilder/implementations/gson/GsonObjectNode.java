/*
 * Copyright (C) Håkon Lindquist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jsonbuilder.implementations.gson;

import org.jsonbuilder.interfaces.ArrayNode;
import org.jsonbuilder.interfaces.NullNode;
import org.jsonbuilder.interfaces.ObjectNode;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

/**
 * @author Håkon Lindquist
 */
public class GsonObjectNode implements ObjectNode {

  private final JsonObject jsonObject;

  public GsonObjectNode() {
    this.jsonObject = new JsonObject();
  }

  @Override
  public void addProperty(String name, String value) {
    this.jsonObject.addProperty(name, value);
  }

  @Override
  public void addProperty(String name, Number value) {
    this.jsonObject.addProperty(name, value);
  }

  @Override
  public void addProperty(String name, Boolean value) {
    this.jsonObject.addProperty(name, value);
  }

  @Override
  public void addProperty(String name, Object value) {
    if (value != null) {
      this.jsonObject.addProperty(name, value.toString());
    } else {
      String nill = null;
      this.jsonObject.addProperty(name, nill);
    }
  }

  @Override
  public Object getNative() {
    return this.jsonObject;
  }

  @Override
  public void add(String name, ArrayNode node) {
    this.jsonObject.add(name, (JsonArray) node.getNative());
  }

  @Override
  public void add(String name, ObjectNode node) {
    this.jsonObject.add(name, (JsonObject) node.getNative());
  }

  @Override
  public void add(String name, NullNode node) {
    this.jsonObject.add(name, (JsonNull) node.getNative());
  }

  @Override
  public String toString() {
    return this.jsonObject.toString();
  }
}