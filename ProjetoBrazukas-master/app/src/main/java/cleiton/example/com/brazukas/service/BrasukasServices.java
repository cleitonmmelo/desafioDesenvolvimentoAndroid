package cleiton.example.com.brazukas.service;

import com.android.volley.Request;
import com.android.volley.Response;

import cleiton.example.com.brazukas.model.BrazukasModel;

/**
 * Created by Cleiton on 09/10/2017.
 */

public class BrasukasServices {

    public static void get(final Response.Listener<BrazukasModel> result, Response.ErrorListener error ){
        String url ="https://api.cartolafc.globo.com/partidas";
        BrazukasRequest<BrazukasModel> request = new BrazukasRequest<BrazukasModel>(Request.Method.GET, url, BrazukasModel.class,
                result, error);
        request.addHeader("User-agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        BrazukasQueueService.getInstance().addToRequestQueue(request);
    }
}
