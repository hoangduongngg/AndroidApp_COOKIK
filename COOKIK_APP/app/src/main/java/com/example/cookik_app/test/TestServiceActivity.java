package com.example.cookik_app.test;

import androidx.appcompat.app.AppCompatActivity;
import lombok.Data;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookik_app.API.APIService;
import com.example.cookik_app.R;
import com.example.cookik_app.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestServiceActivity extends AppCompatActivity {
    Product product;

    TextView text_service;
    Button bt_testCallAPI;
    String responseBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
        text_service = findViewById(R.id.text_service);
        bt_testCallAPI = findViewById(R.id.bt_testCallAPI);
//        callAPI();

        bt_testCallAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    callAPI();
                } catch (Exception e) {
                    System.out.println(e);
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//    private void callAPI() {
//        APIService.apiService.getProductById(3).enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                Toast.makeText(getApplicationContext(), "Call API Success", Toast.LENGTH_SHORT).show();
//                if (response.body()!= null) {
//                    product = response.body();
//                    text_service.setText(product.getName());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Call API Error", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}

