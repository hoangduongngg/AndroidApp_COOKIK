package com.example.cookik_app.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cookik_app.API.APIService;
import com.example.cookik_app.R;
import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Shelf;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    EditText name, img, author, rate, review;
    Spinner sp_shelf;
    Button bt_update;
    Book book;
    private void init() {
        bt_update = findViewById(R.id.bt_update);
        name = findViewById(R.id.name);
//        img = findViewById(R.id.img);
        author = findViewById(R.id.author);
        rate = findViewById(R.id.rate);
        review = findViewById(R.id.review);
        sp_shelf = findViewById(R.id.sp_shelf);
    }

    private void getBook() {
        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("book");

        name.setText(book.getName());
        author.setText(book.getAuthor());

        sp_shelf.setSelection(book.getShelf().getId()-1);

        try {
            rate.setText(book.getRate().toString());
            review.setText(book.getReview());
        }
        catch (Exception e) {
            rate.setText("");
            review.setText("");
        }
    }

    private void setBook() {
        book.setName(name.getText().toString());
        book.setShelf(new Shelf(sp_shelf.getSelectedItem().toString()));
        book.setAuthor(author.getText().toString());

//        book.setImg("https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1412173185i/23293728.jpg");

        try {
            book.setRate(Integer.parseInt(rate.getText().toString()));
            book.setReview(review.getText().toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            book.setRate(null);
            book.setReview(null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        init();
        getBook();

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBook();

                APIService.apiService.updateBook(book).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Update book successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateActivity.this, HomeActivity.class);
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