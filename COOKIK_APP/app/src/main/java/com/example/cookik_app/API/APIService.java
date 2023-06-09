package com.example.cookik_app.API;

import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    String url = "https://01d3-2405-4802-1d79-87e0-f98d-2498-e2ef-f53.ngrok-free.app/";
    Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(APIService.class);

    @GET("api/book")
    Call<List<Book>> getListBook (
    );

    @GET("api/book/name")
    Call<List<Book>> getListBookByName (
            @Query("name") String name
    );

    @POST("api/book/add")
    Call<Book> addBook(
            @Body Book book
    );
}
