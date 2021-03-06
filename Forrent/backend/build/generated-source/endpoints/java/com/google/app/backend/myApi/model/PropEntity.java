/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-05-27 16:00:31 UTC)
 * on 2016-06-08 at 19:06:06 UTC 
 * Modify at your own risk.
 */

package com.google.app.backend.myApi.model;

/**
 * Model definition for PropEntity.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class PropEntity extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String addr;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String bathrooms;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String email;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String groupName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String link;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String pets;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String phone;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String price;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String rank;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String rooms;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String sqft;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long timestamp;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddr() {
    return addr;
  }

  /**
   * @param addr addr or {@code null} for none
   */
  public PropEntity setAddr(java.lang.String addr) {
    this.addr = addr;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBathrooms() {
    return bathrooms;
  }

  /**
   * @param bathrooms bathrooms or {@code null} for none
   */
  public PropEntity setBathrooms(java.lang.String bathrooms) {
    this.bathrooms = bathrooms;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public PropEntity setDate(java.lang.String date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEmail() {
    return email;
  }

  /**
   * @param email email or {@code null} for none
   */
  public PropEntity setEmail(java.lang.String email) {
    this.email = email;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName groupName or {@code null} for none
   */
  public PropEntity setGroupName(java.lang.String groupName) {
    this.groupName = groupName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public PropEntity setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLink() {
    return link;
  }

  /**
   * @param link link or {@code null} for none
   */
  public PropEntity setLink(java.lang.String link) {
    this.link = link;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPets() {
    return pets;
  }

  /**
   * @param pets pets or {@code null} for none
   */
  public PropEntity setPets(java.lang.String pets) {
    this.pets = pets;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPhone() {
    return phone;
  }

  /**
   * @param phone phone or {@code null} for none
   */
  public PropEntity setPhone(java.lang.String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPrice() {
    return price;
  }

  /**
   * @param price price or {@code null} for none
   */
  public PropEntity setPrice(java.lang.String price) {
    this.price = price;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getRank() {
    return rank;
  }

  /**
   * @param rank rank or {@code null} for none
   */
  public PropEntity setRank(java.lang.String rank) {
    this.rank = rank;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getRooms() {
    return rooms;
  }

  /**
   * @param rooms rooms or {@code null} for none
   */
  public PropEntity setRooms(java.lang.String rooms) {
    this.rooms = rooms;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSqft() {
    return sqft;
  }

  /**
   * @param sqft sqft or {@code null} for none
   */
  public PropEntity setSqft(java.lang.String sqft) {
    this.sqft = sqft;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * @param timestamp timestamp or {@code null} for none
   */
  public PropEntity setTimestamp(java.lang.Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  @Override
  public PropEntity set(String fieldName, Object value) {
    return (PropEntity) super.set(fieldName, value);
  }

  @Override
  public PropEntity clone() {
    return (PropEntity) super.clone();
  }

}
