package com.example.cookik_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cookik_app.R;
import com.example.cookik_app.model.Book;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<Book> list;
    private ItemListener itemListener;

    private Context context;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public RecycleViewAdapter(List<Book> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Book getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Book book = list.get(position);
//        holder.img.setImageResource(Integer.parseInt(book.getImg()));
        Glide.with(context)
                        .load(book.getImg())
                                .into(holder.img);
        holder.name.setText(book.getName());
        holder.author.setText(book.getAuthor());
        if (book.getRate()!=null) {
            holder.rate.setText(book.getRate() + " Start");
        }
        else {
            holder.rate.setText(" ");

        }
        holder.shelf.setText(book.getShelf().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView name, author, shelf, rate;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            init(view);
            view.setOnClickListener(this);
        }

        private void init(View view) {
            img = view.findViewById(R.id.img);
            name = view.findViewById(R.id.name);
            author = view.findViewById(R.id.author);
            shelf = view.findViewById(R.id.shelf);
            rate = view.findViewById(R.id.rate);
        }

        @Override
        public void onClick(View view) {
            if (itemListener != null) {
                itemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemListener {
        void onItemClick(View view, int position);
    }
}
