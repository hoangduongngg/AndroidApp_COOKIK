package com.example.cookik_app.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cookik_app.API.APIService;
import com.example.cookik_app.R;
import com.example.cookik_app.model.Book;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView name, author, shelf, review;
    private ImageView img;
    private RatingBar rate;
    private Button bt_update, bt_delete;
//    private Button bt_back;
    Book book = new Book();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();

        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("book");

        setValue();

        bt_update.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
//        bt_back.setOnClickListener(this);

    }

    private void init() {
        bt_update = findViewById(R.id.bt_update);
        bt_delete = findViewById(R.id.bt_delete);
//        bt_back = findViewById(R.id.bt_back);

        name = findViewById(R.id.name);
        img = findViewById(R.id.img);
        author = findViewById(R.id.author);
        review = findViewById(R.id.review);
        shelf = findViewById(R.id.shelf);
        rate = findViewById(R.id.rate);
    }

    private void setValue() {
        name.setText(book.getName());
        author.setText(book.getAuthor());
        shelf.setText(book.getShelf().getName());

        if (book.getReview()!=null) {
            review.setText(book.getReview());
        }
        if (book.getRate()!=null) {
            Float rate_book = (float)book.getRate();
            rate.setRating(rate_book );
        }

        Glide.with(this)
                .load(book.getImg())
                .into(img);

    }

    @Override
    public void onClick(View view) {
        if (view==bt_update) {
            Intent intent = new Intent(this, UpdateActivity.class);
            intent.putExtra("book", book);
            startActivity(intent);
        }
        if (view==bt_delete) {
            APIService.apiService.deleteBook(book).enqueue(new Callback<Book>() {
                @Override
                public void onResponse(Call<Book> call, Response<Book> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Delete book successful.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Book> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
//        if (view==bt_back) {
//            Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, DetailActivity.class);
//            startActivity(intent);
//        }
    }
}