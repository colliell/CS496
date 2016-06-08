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
 * on 2016-06-08 at 05:46:51 UTC 
 * Modify at your own risk.
 */

package com.google.app.backend.myApi;

/**
 * Service definition for MyApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MyApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class MyApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the myApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://forrent-1310.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "myApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public MyApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  MyApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "calcStats".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link CalcStats#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public CalcStats calcStats() throws java.io.IOException {
    CalcStats result = new CalcStats();
    initialize(result);
    return result;
  }

  public class CalcStats extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "calcStats";

    /**
     * Create a request for the method "calcStats".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link CalcStats#execute()} method to invoke the remote operation. <p>
     * {@link
     * CalcStats#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected CalcStats() {
      super(MyApi.this, "POST", REST_PATH, null, com.google.app.backend.myApi.model.JsonMap.class);
    }

    @Override
    public CalcStats setAlt(java.lang.String alt) {
      return (CalcStats) super.setAlt(alt);
    }

    @Override
    public CalcStats setFields(java.lang.String fields) {
      return (CalcStats) super.setFields(fields);
    }

    @Override
    public CalcStats setKey(java.lang.String key) {
      return (CalcStats) super.setKey(key);
    }

    @Override
    public CalcStats setOauthToken(java.lang.String oauthToken) {
      return (CalcStats) super.setOauthToken(oauthToken);
    }

    @Override
    public CalcStats setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (CalcStats) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public CalcStats setQuotaUser(java.lang.String quotaUser) {
      return (CalcStats) super.setQuotaUser(quotaUser);
    }

    @Override
    public CalcStats setUserIp(java.lang.String userIp) {
      return (CalcStats) super.setUserIp(userIp);
    }

    @Override
    public CalcStats set(String parameterName, Object value) {
      return (CalcStats) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "createGroup".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link CreateGroup#execute()} method to invoke the remote operation.
   *
   * @param groupName
   * @param pass
   * @return the request
   */
  public CreateGroup createGroup(java.lang.String groupName, java.lang.String pass) throws java.io.IOException {
    CreateGroup result = new CreateGroup(groupName, pass);
    initialize(result);
    return result;
  }

  public class CreateGroup extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "createGroup/{groupName}/{pass}";

    /**
     * Create a request for the method "createGroup".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link CreateGroup#execute()} method to invoke the remote operation. <p>
     * {@link
     * CreateGroup#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param groupName
     * @param pass
     * @since 1.13
     */
    protected CreateGroup(java.lang.String groupName, java.lang.String pass) {
      super(MyApi.this, "POST", REST_PATH, null, com.google.app.backend.myApi.model.JsonMap.class);
      this.groupName = com.google.api.client.util.Preconditions.checkNotNull(groupName, "Required parameter groupName must be specified.");
      this.pass = com.google.api.client.util.Preconditions.checkNotNull(pass, "Required parameter pass must be specified.");
    }

    @Override
    public CreateGroup setAlt(java.lang.String alt) {
      return (CreateGroup) super.setAlt(alt);
    }

    @Override
    public CreateGroup setFields(java.lang.String fields) {
      return (CreateGroup) super.setFields(fields);
    }

    @Override
    public CreateGroup setKey(java.lang.String key) {
      return (CreateGroup) super.setKey(key);
    }

    @Override
    public CreateGroup setOauthToken(java.lang.String oauthToken) {
      return (CreateGroup) super.setOauthToken(oauthToken);
    }

    @Override
    public CreateGroup setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (CreateGroup) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public CreateGroup setQuotaUser(java.lang.String quotaUser) {
      return (CreateGroup) super.setQuotaUser(quotaUser);
    }

    @Override
    public CreateGroup setUserIp(java.lang.String userIp) {
      return (CreateGroup) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String groupName;

    /**

     */
    public java.lang.String getGroupName() {
      return groupName;
    }

    public CreateGroup setGroupName(java.lang.String groupName) {
      this.groupName = groupName;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pass;

    /**

     */
    public java.lang.String getPass() {
      return pass;
    }

    public CreateGroup setPass(java.lang.String pass) {
      this.pass = pass;
      return this;
    }

    @Override
    public CreateGroup set(String parameterName, Object value) {
      return (CreateGroup) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "createProp".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link CreateProp#execute()} method to invoke the remote operation.
   *
   * @param group
   * @param pass
   * @param content the {@link com.google.app.backend.myApi.model.JsonMap}
   * @return the request
   */
  public CreateProp createProp(java.lang.String group, java.lang.String pass, com.google.app.backend.myApi.model.JsonMap content) throws java.io.IOException {
    CreateProp result = new CreateProp(group, pass, content);
    initialize(result);
    return result;
  }

  public class CreateProp extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "createProp/{group}/{pass}";

    /**
     * Create a request for the method "createProp".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link CreateProp#execute()} method to invoke the remote operation. <p>
     * {@link
     * CreateProp#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param group
     * @param pass
     * @param content the {@link com.google.app.backend.myApi.model.JsonMap}
     * @since 1.13
     */
    protected CreateProp(java.lang.String group, java.lang.String pass, com.google.app.backend.myApi.model.JsonMap content) {
      super(MyApi.this, "POST", REST_PATH, content, com.google.app.backend.myApi.model.JsonMap.class);
      this.group = com.google.api.client.util.Preconditions.checkNotNull(group, "Required parameter group must be specified.");
      this.pass = com.google.api.client.util.Preconditions.checkNotNull(pass, "Required parameter pass must be specified.");
    }

    @Override
    public CreateProp setAlt(java.lang.String alt) {
      return (CreateProp) super.setAlt(alt);
    }

    @Override
    public CreateProp setFields(java.lang.String fields) {
      return (CreateProp) super.setFields(fields);
    }

    @Override
    public CreateProp setKey(java.lang.String key) {
      return (CreateProp) super.setKey(key);
    }

    @Override
    public CreateProp setOauthToken(java.lang.String oauthToken) {
      return (CreateProp) super.setOauthToken(oauthToken);
    }

    @Override
    public CreateProp setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (CreateProp) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public CreateProp setQuotaUser(java.lang.String quotaUser) {
      return (CreateProp) super.setQuotaUser(quotaUser);
    }

    @Override
    public CreateProp setUserIp(java.lang.String userIp) {
      return (CreateProp) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String group;

    /**

     */
    public java.lang.String getGroup() {
      return group;
    }

    public CreateProp setGroup(java.lang.String group) {
      this.group = group;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pass;

    /**

     */
    public java.lang.String getPass() {
      return pass;
    }

    public CreateProp setPass(java.lang.String pass) {
      this.pass = pass;
      return this;
    }

    @Override
    public CreateProp set(String parameterName, Object value) {
      return (CreateProp) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "deleteProp".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link DeleteProp#execute()} method to invoke the remote operation.
   *
   * @param group
   * @param pass
   * @param id
   * @return the request
   */
  public DeleteProp deleteProp(java.lang.String group, java.lang.String pass, java.lang.Long id) throws java.io.IOException {
    DeleteProp result = new DeleteProp(group, pass, id);
    initialize(result);
    return result;
  }

  public class DeleteProp extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "prop/{group}/{pass}/{id}";

    /**
     * Create a request for the method "deleteProp".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link DeleteProp#execute()} method to invoke the remote operation. <p>
     * {@link
     * DeleteProp#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param group
     * @param pass
     * @param id
     * @since 1.13
     */
    protected DeleteProp(java.lang.String group, java.lang.String pass, java.lang.Long id) {
      super(MyApi.this, "DELETE", REST_PATH, null, com.google.app.backend.myApi.model.JsonMap.class);
      this.group = com.google.api.client.util.Preconditions.checkNotNull(group, "Required parameter group must be specified.");
      this.pass = com.google.api.client.util.Preconditions.checkNotNull(pass, "Required parameter pass must be specified.");
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public DeleteProp setAlt(java.lang.String alt) {
      return (DeleteProp) super.setAlt(alt);
    }

    @Override
    public DeleteProp setFields(java.lang.String fields) {
      return (DeleteProp) super.setFields(fields);
    }

    @Override
    public DeleteProp setKey(java.lang.String key) {
      return (DeleteProp) super.setKey(key);
    }

    @Override
    public DeleteProp setOauthToken(java.lang.String oauthToken) {
      return (DeleteProp) super.setOauthToken(oauthToken);
    }

    @Override
    public DeleteProp setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (DeleteProp) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public DeleteProp setQuotaUser(java.lang.String quotaUser) {
      return (DeleteProp) super.setQuotaUser(quotaUser);
    }

    @Override
    public DeleteProp setUserIp(java.lang.String userIp) {
      return (DeleteProp) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String group;

    /**

     */
    public java.lang.String getGroup() {
      return group;
    }

    public DeleteProp setGroup(java.lang.String group) {
      this.group = group;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pass;

    /**

     */
    public java.lang.String getPass() {
      return pass;
    }

    public DeleteProp setPass(java.lang.String pass) {
      this.pass = pass;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public DeleteProp setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public DeleteProp set(String parameterName, Object value) {
      return (DeleteProp) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "doNothing".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link DoNothing#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public DoNothing doNothing() throws java.io.IOException {
    DoNothing result = new DoNothing();
    initialize(result);
    return result;
  }

  public class DoNothing extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "donNothing";

    /**
     * Create a request for the method "doNothing".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link DoNothing#execute()} method to invoke the remote operation. <p>
     * {@link
     * DoNothing#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected DoNothing() {
      super(MyApi.this, "GET", REST_PATH, null, com.google.app.backend.myApi.model.JsonMap.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public DoNothing setAlt(java.lang.String alt) {
      return (DoNothing) super.setAlt(alt);
    }

    @Override
    public DoNothing setFields(java.lang.String fields) {
      return (DoNothing) super.setFields(fields);
    }

    @Override
    public DoNothing setKey(java.lang.String key) {
      return (DoNothing) super.setKey(key);
    }

    @Override
    public DoNothing setOauthToken(java.lang.String oauthToken) {
      return (DoNothing) super.setOauthToken(oauthToken);
    }

    @Override
    public DoNothing setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (DoNothing) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public DoNothing setQuotaUser(java.lang.String quotaUser) {
      return (DoNothing) super.setQuotaUser(quotaUser);
    }

    @Override
    public DoNothing setUserIp(java.lang.String userIp) {
      return (DoNothing) super.setUserIp(userIp);
    }

    @Override
    public DoNothing set(String parameterName, Object value) {
      return (DoNothing) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getProps".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link GetProps#execute()} method to invoke the remote operation.
   *
   * @param group
   * @param pass
   * @return the request
   */
  public GetProps getProps(java.lang.String group, java.lang.String pass) throws java.io.IOException {
    GetProps result = new GetProps(group, pass);
    initialize(result);
    return result;
  }

  public class GetProps extends MyApiRequest<com.google.app.backend.myApi.model.PropEntityCollection> {

    private static final String REST_PATH = "propentitycollection/{group}/{pass}";

    /**
     * Create a request for the method "getProps".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link GetProps#execute()} method to invoke the remote operation. <p>
     * {@link
     * GetProps#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param group
     * @param pass
     * @since 1.13
     */
    protected GetProps(java.lang.String group, java.lang.String pass) {
      super(MyApi.this, "GET", REST_PATH, null, com.google.app.backend.myApi.model.PropEntityCollection.class);
      this.group = com.google.api.client.util.Preconditions.checkNotNull(group, "Required parameter group must be specified.");
      this.pass = com.google.api.client.util.Preconditions.checkNotNull(pass, "Required parameter pass must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetProps setAlt(java.lang.String alt) {
      return (GetProps) super.setAlt(alt);
    }

    @Override
    public GetProps setFields(java.lang.String fields) {
      return (GetProps) super.setFields(fields);
    }

    @Override
    public GetProps setKey(java.lang.String key) {
      return (GetProps) super.setKey(key);
    }

    @Override
    public GetProps setOauthToken(java.lang.String oauthToken) {
      return (GetProps) super.setOauthToken(oauthToken);
    }

    @Override
    public GetProps setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetProps) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetProps setQuotaUser(java.lang.String quotaUser) {
      return (GetProps) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetProps setUserIp(java.lang.String userIp) {
      return (GetProps) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String group;

    /**

     */
    public java.lang.String getGroup() {
      return group;
    }

    public GetProps setGroup(java.lang.String group) {
      this.group = group;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pass;

    /**

     */
    public java.lang.String getPass() {
      return pass;
    }

    public GetProps setPass(java.lang.String pass) {
      this.pass = pass;
      return this;
    }

    @Override
    public GetProps set(String parameterName, Object value) {
      return (GetProps) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getStats".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link GetStats#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public GetStats getStats() throws java.io.IOException {
    GetStats result = new GetStats();
    initialize(result);
    return result;
  }

  public class GetStats extends MyApiRequest<com.google.app.backend.myApi.model.JsonMap> {

    private static final String REST_PATH = "mybean";

    /**
     * Create a request for the method "getStats".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link GetStats#execute()} method to invoke the remote operation. <p>
     * {@link
     * GetStats#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected GetStats() {
      super(MyApi.this, "GET", REST_PATH, null, com.google.app.backend.myApi.model.JsonMap.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetStats setAlt(java.lang.String alt) {
      return (GetStats) super.setAlt(alt);
    }

    @Override
    public GetStats setFields(java.lang.String fields) {
      return (GetStats) super.setFields(fields);
    }

    @Override
    public GetStats setKey(java.lang.String key) {
      return (GetStats) super.setKey(key);
    }

    @Override
    public GetStats setOauthToken(java.lang.String oauthToken) {
      return (GetStats) super.setOauthToken(oauthToken);
    }

    @Override
    public GetStats setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetStats) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetStats setQuotaUser(java.lang.String quotaUser) {
      return (GetStats) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetStats setUserIp(java.lang.String userIp) {
      return (GetStats) super.setUserIp(userIp);
    }

    @Override
    public GetStats set(String parameterName, Object value) {
      return (GetStats) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateProp".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link UpdateProp#execute()} method to invoke the remote operation.
   *
   * @param group
   * @param pass
   * @param id
   * @param timestamp
   * @param content the {@link com.google.app.backend.myApi.model.JsonMap}
   * @return the request
   */
  public UpdateProp updateProp(java.lang.String group, java.lang.String pass, java.lang.Long id, java.lang.Long timestamp, com.google.app.backend.myApi.model.JsonMap content) throws java.io.IOException {
    UpdateProp result = new UpdateProp(group, pass, id, timestamp, content);
    initialize(result);
    return result;
  }

  public class UpdateProp extends MyApiRequest<com.google.app.backend.myApi.model.PropEntity> {

    private static final String REST_PATH = "propentity/{group}/{pass}/{id}/{timestamp}";

    /**
     * Create a request for the method "updateProp".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link UpdateProp#execute()} method to invoke the remote operation. <p>
     * {@link
     * UpdateProp#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param group
     * @param pass
     * @param id
     * @param timestamp
     * @param content the {@link com.google.app.backend.myApi.model.JsonMap}
     * @since 1.13
     */
    protected UpdateProp(java.lang.String group, java.lang.String pass, java.lang.Long id, java.lang.Long timestamp, com.google.app.backend.myApi.model.JsonMap content) {
      super(MyApi.this, "PUT", REST_PATH, content, com.google.app.backend.myApi.model.PropEntity.class);
      this.group = com.google.api.client.util.Preconditions.checkNotNull(group, "Required parameter group must be specified.");
      this.pass = com.google.api.client.util.Preconditions.checkNotNull(pass, "Required parameter pass must be specified.");
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      this.timestamp = com.google.api.client.util.Preconditions.checkNotNull(timestamp, "Required parameter timestamp must be specified.");
    }

    @Override
    public UpdateProp setAlt(java.lang.String alt) {
      return (UpdateProp) super.setAlt(alt);
    }

    @Override
    public UpdateProp setFields(java.lang.String fields) {
      return (UpdateProp) super.setFields(fields);
    }

    @Override
    public UpdateProp setKey(java.lang.String key) {
      return (UpdateProp) super.setKey(key);
    }

    @Override
    public UpdateProp setOauthToken(java.lang.String oauthToken) {
      return (UpdateProp) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateProp setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateProp) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateProp setQuotaUser(java.lang.String quotaUser) {
      return (UpdateProp) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateProp setUserIp(java.lang.String userIp) {
      return (UpdateProp) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String group;

    /**

     */
    public java.lang.String getGroup() {
      return group;
    }

    public UpdateProp setGroup(java.lang.String group) {
      this.group = group;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pass;

    /**

     */
    public java.lang.String getPass() {
      return pass;
    }

    public UpdateProp setPass(java.lang.String pass) {
      this.pass = pass;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public UpdateProp setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Long timestamp;

    /**

     */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    public UpdateProp setTimestamp(java.lang.Long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    @Override
    public UpdateProp set(String parameterName, Object value) {
      return (UpdateProp) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link MyApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link MyApi}. */
    @Override
    public MyApi build() {
      return new MyApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link MyApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMyApiRequestInitializer(
        MyApiRequestInitializer myapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(myapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
