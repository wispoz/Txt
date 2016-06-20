package com.wispoz.txt.services;

import com.wispoz.txt.models.Artists;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by wispoz on 13.06.16.
 */
public class ApiService {
    public static final String API_URL = "http://api.wispoz.com";
    static class HttpBinResponse {
        // the request url
        String url;

        // the requester ip
        String origin;

        // all headers that have been sent
        Map headers;

        // url arguments
        Map args;

        // post form parameters
        Map form;

        // post body json
        Map json;
    }

    public interface RestApi {
        @Headers( "Content-Type: application/json" )
        @GET("/artists/")
        Call<RestApi> getArtistsList();
    }
}
