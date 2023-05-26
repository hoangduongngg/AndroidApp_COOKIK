package com.example.cookik_app.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cookik_app.R;
import com.example.cookik_app.model.Book;

public class DetailActivity extends AppCompatActivity {

    Book book = new Book();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("book");

    }
}