package cleiton.example.com.brazukas.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import cleiton.example.com.brazukas.BrazukasApp;


public class BrazukasQueueService {

    private static BrazukasQueueService mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private BrazukasQueueService() {
        mCtx = BrazukasApp.getInstance().getApplicationContext();
        mRequestQueue = getRequestQueue();
    }

    public static synchronized BrazukasQueueService getInstance() {
        if (mInstance == null) {
            mInstance = new BrazukasQueueService();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}