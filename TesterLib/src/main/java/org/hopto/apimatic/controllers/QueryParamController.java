/*
 * TesterLib
 *
 * This file was automatically generated for Stamplay by APIMATIC v2.0 ( https://apimatic.io ).
 */
package org.hopto.apimatic.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.type.TypeReference;
import org.joda.time.LocalDate;
import org.joda.time.DateTime;

import org.hopto.apimatic.*;
import org.hopto.apimatic.models.*;
import org.hopto.apimatic.exceptions.*;
import org.hopto.apimatic.http.client.HttpClient;
import org.hopto.apimatic.http.client.HttpContext;
import org.hopto.apimatic.http.request.HttpRequest;
import org.hopto.apimatic.http.response.HttpResponse;
import org.hopto.apimatic.http.response.HttpStringResponse;
import org.hopto.apimatic.http.client.APICallBack;

public class QueryParamController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static QueryParamController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the QueryParamController class 
     */
    public static QueryParamController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new QueryParamController();
            }
        }
        return instance;
    }

    /**
     * TODO: type endpoint description here
     * @param    number    Required parameter: Example: 
     * @param    precision    Required parameter: Example: 
     * @param    string    Required parameter: Example: 
     * @param    url    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void multipleParamsAsync(
                final int number,
                final double precision,
                final String string,
                final String url,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == string) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"string\" is a required parameter and cannot be null."));
                    return;
                }

                if (null == url) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"url\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/multipleparams");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5667042323432938433L;
                    {
                        put( "number", number );
                        put( "precision", precision );
                        put( "string", string );
                        put( "url", url );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5305201988898316526L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    integers    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void numberArrayAsync(
                final List<Integer> integers,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == integers) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"integers\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/numberarray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 4716890245337375455L;
                    {
                        put( "integers", integers );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5364314565638403269L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    strings    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void stringArrayAsync(
                final List<String> strings,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == strings) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"strings\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/stringarray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5037816360687803728L;
                    {
                        put( "strings", strings );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5150073813064842282L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    mboolean    Required parameter: Example: 
     * @param    number    Required parameter: Example: 
     * @param    string    Required parameter: Example: 
     * @param    queryParameters    Additional optional query parameters are supported by this endpoint
     * @return    Returns the void response from the API call 
     */
    public void simpleQueryAsync(
                final boolean mboolean,
                final int number,
                final String string,
                final Map<String, Object> queryParameters,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == string) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"string\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5378090419128786233L;
                    {
                        put( "boolean", mboolean );
                        put( "number", number );
                        put( "string", string );
                    }});

                //append optional parameters to the query
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, queryParameters);
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5152539351218900198L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    days    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void stringEnumArrayAsync(
                final List<Days> days,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == days) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"days\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/stringenumarray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 4662692261741717884L;
                    {
                        put( "days", Days.toValue(days) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 4915324957295813712L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    suites    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void integerEnumArrayAsync(
                final List<SuiteCode> suites,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == suites) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"suites\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/integerenumarray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5624847857351858482L;
                    {
                        put( "suites", SuiteCode.toValue(suites) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5118407121781745289L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @return    Returns the void response from the API call 
     */
    public void noParamsAsync(
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/noparams");
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 4997946267523528061L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    string    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void stringParamAsync(
                final String string,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == string) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"string\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/stringparam");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5484166998204365320L;
                    {
                        put( "string", string );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5321514073648661638L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    url    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void urlParamAsync(
                final String url,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == url) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"url\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/urlparam");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5756106686639677476L;
                    {
                        put( "url", url );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5063274141857918872L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    dates    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void dateArrayAsync(
                final List<LocalDate> dates,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == dates) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"dates\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/datearray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5725411256710290952L;
                    {
                        put( "dates", DateTimeHelper.toSimpleDate(dates) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5564439775940281969L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * get optional dynamic query parameter
     * @param    name    Required parameter: Example: 
     * @param    queryParameters    Additional optional query parameters are supported by this endpoint
     * @return    Returns the void response from the API call 
     */
    public void optionalDynamicQueryParamAsync(
                final String name,
                final Map<String, Object> queryParameters,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == name) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"name\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/optionalQueryParam");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 4700402202621381129L;
                    {
                        put( "name", name );
                    }});

                //append optional parameters to the query
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, queryParameters);
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 4773867216328333829L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    date    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void dateAsync(
                final LocalDate date,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == date) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"date\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/date");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5253621452643455123L;
                    {
                        put( "date", DateTimeHelper.toSimpleDate(date) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 4670421850620406494L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetimes    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void unixDateTimeArrayAsync(
                final List<DateTime> datetimes,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetimes) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetimes\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/unixdatetimearray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 4717149572163601901L;
                    {
                        put( "datetimes", DateTimeHelper.toUnixTimestamp(datetimes) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5006300053224660810L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetime    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void unixDateTimeAsync(
                final DateTime datetime,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetime) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetime\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/unixdatetime");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5164628717348303560L;
                    {
                        put( "datetime", DateTimeHelper.toUnixTimestamp(datetime) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5161575075043550508L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetime    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void rfc1123DateTimeAsync(
                final DateTime datetime,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetime) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetime\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/rfc1123datetime");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5168190634764692568L;
                    {
                        put( "datetime", DateTimeHelper.toRfc1123DateTime(datetime) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 4991616009198831878L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetimes    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void rfc1123DateTimeArrayAsync(
                final List<DateTime> datetimes,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetimes) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetimes\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/rfc1123datetimearray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5084902557142053354L;
                    {
                        put( "datetimes", DateTimeHelper.toRfc1123DateTime(datetimes) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5123319500266505111L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetimes    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void rfc3339DateTimeArrayAsync(
                final List<DateTime> datetimes,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetimes) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetimes\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/rfc3339datetimearray");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 4933150531067476921L;
                    {
                        put( "datetimes", DateTimeHelper.toRfc8601DateTime(datetimes) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5003409949330549690L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * TODO: type endpoint description here
     * @param    datetime    Required parameter: Example: 
     * @return    Returns the void response from the API call 
     */
    public void rfc3339DateTimeAsync(
                final DateTime datetime,
                final APICallBack<ServerResponse> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                //validating required parameters
                if (null == datetime) {
                    callBack.onFailure(null, new NullPointerException("The parameter \"datetime\" is a required parameter and cannot be null."));
                    return;
                }

                //the base uri for api requests
                String _baseUri = Configuration.getBaseUri();

                //prepare query string for API call
                StringBuilder _queryBuilder = new StringBuilder(_baseUri);
                _queryBuilder.append("/query/rfc3339datetime");

                //process query parameters
                APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
                    private static final long serialVersionUID = 5746184200705390528L;
                    {
                        put( "datetime", DateTimeHelper.toRfc8601DateTime(datetime) );
                    }});
                //validate and preprocess url
                String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

                //load all headers for the outgoing API request
                Map<String, String> _headers = new HashMap<String, String>() {
                    private static final long serialVersionUID = 5677157399912919137L;
                    {
                        put( "user-agent", "Stamplay SDK" );
                        put( "accept", "application/json" );
                    }
                };

                //prepare and invoke the API call request to fetch the response
                final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

                //invoke the callback before request if its not null
                if (getHttpCallBack() != null)
                {
                    getHttpCallBack().OnBeforeRequest(_request);
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();

                            //return null on 404
                            if (_responseCode == 404)
                                callBack.onSuccess(_context, null);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            ServerResponse _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<ServerResponse>(){});

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (IOException ioException) {
                            //let the caller know of the caught IO Exception
                            callBack.onFailure(_context, ioException);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
                        {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}