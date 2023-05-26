package com.example.cookik_app.activity.home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import com.example.cookik_app.API.APIService;
import com.example.cookik_app.R;
import com.example.cookik_app.activity.fragment.FragmentHome;
import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Shelf;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    EditText name, img, author, review;
    Button bt_add;
    Book book;
    private void init() {
        bt_add = findViewById(R.id.bt_add);
        name = findViewById(R.id.name);
        img = findViewById(R.id.img);
        author = findViewById(R.id.author);
        review = findViewById(R.id.review);
    }

    private void init_book() {
        book = new Book();
        book.setName(name.getText().toString());
        book.setImg("https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1412173185i/23293728.jpg");
        book.setRate(null);
        book.setAuthor(author.getText().toString());
        book.setCreate_date(null);
        book.setRead_date(null);
        book.setReview(review.getText().toString());
        book.setShelf(new Shelf("Read"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init_book();
                APIService.apiService.addBook(book).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Add book successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}