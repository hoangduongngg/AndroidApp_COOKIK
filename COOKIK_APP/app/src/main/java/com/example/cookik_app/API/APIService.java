package com.example.cookik_app.API;

import com.example.cookik_app.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    String url = "http://localhost:8081/";
    Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(APIService.class);
    @GET("product")
    Call<Product> getProductById(
            @Query("id") Integer id
        );
}
