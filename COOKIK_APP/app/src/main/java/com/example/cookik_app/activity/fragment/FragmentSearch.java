package com.example.cookik_app.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookik_app.API.APIService;
import com.example.cookik_app.API.BookController;
import com.example.cookik_app.R;
import com.example.cookik_app.activity.home.DetailActivity;
import com.example.cookik_app.activity.home.HomeActivity;
import com.example.cookik_app.adapter.RecycleViewAdapter;
import com.example.cookik_app.model.Book;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearch extends Fragment implements RecycleViewAdapter.ItemListener{
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private BookController controller;
//    SearchView search;
    EditText search;
    Button bt_search;
    List<Book> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_search, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search = view.findViewById(R.id.search);
        bt_search = view.findViewById(R.id.bt_search);
        recyclerView = view.findViewById(R.id.recycleView);
        adapter = new RecycleViewAdapter();


        bt_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String txt_search = search.getText().toString();
                Toast.makeText(getContext(), txt_search, Toast.LENGTH_SHORT).show();

                APIService.apiService.getListBookByName(txt_search).enqueue(new Callback<List<Book>>() {
                    @Override
                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "Search book successful.", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getContext(), HomeActivity.class);
//                            startActivity(intent);
                            list = response.body();

                            adapter.setList(list);
                            adapter.setContext(requireContext());
                            LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                            recyclerView.setLayoutManager(manager);
                            recyclerView.setAdapter(adapter);
                            adapter.setItemListener(FragmentSearch.this);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Book>> call, Throwable t) {
                        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Book book = adapter.getItem(position);
        intent.putExtra("book", book);
        startActivity(intent);
    }
}
