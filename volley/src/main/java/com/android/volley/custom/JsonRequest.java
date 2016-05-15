package com.android.volley.custom;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created with Android Studio by 王金 on 2016-05-15 上午11:20.
 *
 * @author 王金
 * @version 1.0
 */
public class JsonRequest extends Request<String> {

    private Response.Listener<String> listener;
    private Map<String, String> params;

    public JsonRequest(int method, String url, Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.params = params;
    }

    public JsonRequest(String url, Map<String, String> params, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.listener = listener;
        this.params = params;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(new String(response.data, "utf-8"), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        this.listener.onResponse(response);
    }
}
