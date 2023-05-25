package com.example.cookik_app.API;

import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    String url = "https://d35a-2405-4802-1d79-87e0-68ea-166b-e199-1076.ngrok-free.app/";
    Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(APIService.class);
//    @GET("product")
//    Call<Product> getProductById(
//            @Query("id") int id
//        );

    @GET("api/book")
    Call<List<Book>> getListBook (
    );

    @GET("api/book/name")
    Call<List<Book>> getListBookByName (
            @Query("name") String name
    );
}
