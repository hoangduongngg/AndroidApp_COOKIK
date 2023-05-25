package com.example.cookik_app.API;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookik_app.R;
import com.example.cookik_app.activity.fragment.FragmentHome;
import com.example.cookik_app.adapter.RecycleViewAdapter;
import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookController {
    private List<Book> list;
    private Book book;

    RecycleViewAdapter adapter = new RecycleViewAdapter();
    RecyclerView recyclerView;


    public BookController() {
        list = new ArrayList<>();
        book = new Book();
    }

    public List<Book> getListBook (View view, Context context) {
        APIService.apiService.getListBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Toast.makeText(context, "Call API Success", Toast.LENGTH_SHORT).show();
                if (response.body()!= null) {
                    list = response.body();
                    recyclerView = view.findViewById(R.id.recycleView);
                    LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
//                    adapter.setItemListener();
                    TextView txtHome = view.findViewById(R.id.txtHome);
                    txtHome.setText("Bạn có " + list.size() + " sách trong bộ sưu tập.");

                    System.out.println("Controller" + list);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(context, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });

        return list;
    }

    public List<Book> getListBookByName (Context context, String name) {
        APIService.apiService.getListBookByName(name).enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Toast.makeText(context, "Call API Success", Toast.LENGTH_SHORT).show();
                if (response.body()!= null) {
                    list = response.body();
                    System.out.println("Controller" + list);

                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(context, "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });

        return list;
    }
}
