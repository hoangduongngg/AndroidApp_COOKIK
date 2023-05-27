package com.example.cookik_app.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cookik_app.R;
import com.example.cookik_app.activity.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentInfo extends Fragment {
    private TextView name, gmail, shelf, review;
    private ImageView img;
    private RatingBar rate;
    private Button bt_logout;

    FirebaseAuth auth;
    FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_info, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setValue();

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init(View view) {
        bt_logout = view.findViewById(R.id.bt_logout);

        name = view.findViewById(R.id.name);
        gmail = view.findViewById(R.id.gmail);

//        img = view.findViewById(R.id.img);
//        review = view.findViewById(R.id.review);
//        shelf = view.findViewById(R.id.shelf);
//        rate = view.findViewById(R.id.rate);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }

    private void setValue () {
        name.setText(user.getDisplayName());
        gmail.setText(user.getEmail());
    }
}
