package com.example.techguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.techguide.common.Common;
import com.example.techguide.interfaces.ItemClickListener;
import com.example.techguide.model.Faculty;
import com.example.techguide.model.LecturerModel;
import com.example.techguide.viewHolder.FacultyViewHolder;
import com.example.techguide.viewHolder.LecturersViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FacultyActivity extends AppCompatActivity {

    private static final String TAG = "Lecturer";
    DatabaseReference databaseReference, byActivityRef;
    FirebaseDatabase database;

    FirebaseRecyclerAdapter<Faculty, FacultyViewHolder> adapter;
    String deptS="";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        init();

        loadFacultyExecs();
    }

    private void loadFacultyExecs() {
        Query query = databaseReference.orderByChild("name");
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<LecturerModel>()
                .setQuery(query,LecturerModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Faculty, FacultyViewHolder>(options) {


            @Override
            protected void onBindViewHolder(@NonNull FacultyViewHolder holder, int position, @NonNull Faculty model) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.image_processing);
                requestOptions.error(R.drawable.no_image);


                Glide.with(getBaseContext())
                        .applyDefaultRequestOptions(requestOptions)
                        .setDefaultRequestOptions(requestOptions)
                        .load(model.getImageUrl())
                        .into(holder.eachImage);

                Log.e(TAG, "onBindViewHolder: " + model.getImageUrl());

                holder.eachName.setText(model.getName());
                holder.eachDept.setText(model.getDepartment());
                holder.eachNumber.setText(model.getPhoneNumber());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Intent intent = new Intent(FacultyActivity.this, FacultyDetailActivity.class);
                        intent.putExtra("postid", adapter.getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public FacultyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.each_faculty, viewGroup, false);

                return new FacultyViewHolder(itemView);
            }

        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference(Common.NODE_FACULTY_EXECS).child(Common.NODE_RAW_POST);

        recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getBaseContext(),2);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);
    }
}
