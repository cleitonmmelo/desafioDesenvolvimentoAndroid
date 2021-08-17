package cleiton.example.com.brazukas.service;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class BrazukasRequest<T> extends Request<T> {
    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Listener<T> listener;
    private  Object _body;
    private Map<String, String> headers = new HashMap<>();

    public BrazukasRequest(Integer metod, String url, Object body, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
        super(metod, url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
        this._body = body;
        this.setRetryPolicy(new DefaultRetryPolicy(0,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    public BrazukasRequest(Integer metod, String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
        super(metod,  url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
        this.setRetryPolicy(new DefaultRetryPolicy(0,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        //this.headers.put("Content-Type", "application/json");
        return this.headers;
    }



    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    @Override
    public String getBodyContentType() {
        return "application/json";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return parserBody(this._body);
    }

    private  byte[] parserBody(Object object){
        if(object != null){
            Gson gson = new Gson();
            return gson.toJson(object).getBytes(Charset.forName("UTF-8"));
        }
        return null;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        super.deliverError(error);
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }


}