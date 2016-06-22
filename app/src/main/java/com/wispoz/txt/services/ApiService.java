package com.wispoz.txt.services;

import android.util.Log;

import com.wispoz.txt.models.Artists;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wispoz on 13.06.16.
 */
public class ApiService {
    public static final String API_URL = "http://api.wispoz.com";

    public interface RestApi {
        @Headers( "Content-Type: application/json" )
        @GET("/artists/")
        Call<JSONResponse> getJSON();

        @GET("/artists/")
        Call<JSONResponse> getMore(@Query("page") int page);
    }
}
