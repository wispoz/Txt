package com.wispoz.txt.views.artists;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.wispoz.txt.R;
import com.wispoz.txt.models.Artists;
import com.wispoz.txt.models.ArtistsAdapter;
import com.wispoz.txt.services.ApiService;
import com.wispoz.txt.services.JSONResponse;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

/**
 * Created by wispoz on 12.06.16.
 */
public class ArtistsView extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<Artists> data;
    private ArtistsAdapter adapter;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 20;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.artists, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.card_recycler_view);
        View view = inflater.inflate(R.layout.artists, container, false);
        recyclerView.setHasFixedSize(true);
        layoutManager =  new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        /*
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerViews, int dx, int dy) {
                super.onScrolled(recyclerViews, dx, dy);

                visibleItemCount = recyclerViews.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    // End has been reached
                    Log.i("Yaeye!", "end called");

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(ApiService.API_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ApiService.RestApi request = retrofit.create(ApiService.RestApi.class);
                    Call<JSONResponse> call = request.getMore(2);
                    call.enqueue(new Callback<JSONResponse>() {
                        @Override
                        public void  onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                            JSONResponse jsonResponse = response.body();
                            data = new ArrayList<>(Arrays.asList(jsonResponse.getArtist()));
                            adapter =  new ArtistsAdapter(data);
                            recyclerView.setAdapter(adapter);

                        }
                        @Override
                        public void onFailure(Call<JSONResponse> call, Throwable t) {
                            Log.d("Error", t.getMessage());
                        }
                    });

                    loading = true;
                }
            }
        });
        */
        loadJSON();
        return rootView;
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService.RestApi request = retrofit.create(ApiService.RestApi.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void  onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                Headers headers = response.headers();
                String currentPage = headers.get("X-Pagination-Current-Page");
                String totalPages = headers.get("X-Pagination-Page-Count");
                data = new ArrayList<>(Arrays.asList(jsonResponse.getArtist()));
                adapter =  new ArtistsAdapter(data);
                recyclerView.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
