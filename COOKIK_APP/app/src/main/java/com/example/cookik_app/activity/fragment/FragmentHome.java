package com.example.cookik_app.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookik_app.API.APIService;
import com.example.cookik_app.API.BookController;
import com.example.cookik_app.R;
import com.example.cookik_app.activity.home.DetailActivity;
import com.example.cookik_app.adapter.RecycleViewAdapter;
import com.example.cookik_app.model.Book;
import com.example.cookik_app.model.Product;
import com.example.cookik_app.model.Shelf;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private BookController controller;
    List<Book> list = new ArrayList<>();
    TextView txtHome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleView);
        txtHome = view.findViewById(R.id.txtHome);
        adapter = new RecycleViewAdapter();

        APIService.apiService.getListBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.body()!= null) {
                    list = response.body();

                    adapter.setList(list);
                    adapter.setContext(requireContext());
                    LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    adapter.setItemListener(FragmentHome.this);

                    TextView txtHome = view.findViewById(R.id.txtHome);
                    txtHome.setText("Bạn có " + list.size() + " sách trong bộ sưu tập.");
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getContext(), "Call API Fail", Toast.LENGTH_SHORT).show();
            }
        });
        //End of get

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Book book = adapter.getItem(position);
        intent.putExtra("book", book);
        startActivity(intent);
//        Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();
    }
}



