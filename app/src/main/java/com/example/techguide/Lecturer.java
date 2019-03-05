package com.example.techguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.techguide.common.Common;
import com.example.techguide.interfaces.ItemClickListener;
import com.example.techguide.model.LecturerModel;
import com.example.techguide.viewHolder.LecturersViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Lecturer extends AppCompatActivity {

    private static final String TAG = "Lecturer";
    DatabaseReference databaseReference, byActivityRef;
    FirebaseDatabase database;

    FirebaseRecyclerAdapter<LecturerModel, LecturersViewHolder> adapter;
    String deptS="";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    TextView departmentTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);


        init();

        if (getIntent() != null){
            deptS = getIntent().getStringExtra(Common.KEY);
            Toast.makeText(this, ""+ deptS, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: " + deptS);
        }

        if (!deptS.equals("")){
            Log.d(TAG, "onCreate: " + deptS);
            departmentTxt.setText(deptS);
            loadLecturers(deptS);
            loadRead(deptS);
            if (Common.isConnectedToInternet(getBaseContext())){

            }else {
                Toast.makeText(this, "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loadRead(String deptS) {

        byActivityRef.child(deptS).orderByChild("name")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void init() {
        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference(Common.NODE_LECTURERS).child(Common.NODE_RAW_POST);

        byActivityRef = database.getReference(Common.NODE_LECTURERS);

        recyclerView = findViewById(R.id.recycler_view);


        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getBaseContext(),2);

        recyclerView.setLayoutManager(layoutManager);

        departmentTxt = findViewById(R.id.text_department);

        recyclerView.setAdapter(adapter);

    }



    private void loadLecturers(String department) {
//        Query query = databaseReference.orderByChild("department").equalTo(department);

        Query query = byActivityRef.child(department).orderByChild("name");
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<LecturerModel>()
                .setQuery(query,LecturerModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<LecturerModel, LecturersViewHolder>(options) {
            @NonNull
            @Override
            public LecturersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View itemview = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.lecturer_item,viewGroup,false);
                return new LecturersViewHolder(itemview);
            }

            @Override
            protected void onBindViewHolder(@NonNull LecturersViewHolder holder, int position, @NonNull LecturerModel model) {

                holder.lecturerName.setText(model.getName());
                holder.lecturerPhone.setText(model.getPhoneNumber());

                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.ic_menu_gallery);

                Glide.with(getBaseContext())
                        .applyDefaultRequestOptions(requestOptions)
                        .setDefaultRequestOptions(requestOptions)
                        .load(model.getImageUrl())
                        .into(holder.lecturerImage);

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent intent = new Intent(Lecturer.this, LecturerDetailActivity.class );
                        intent.putExtra("postid", adapter.getRef(position).getKey());

                        startActivity(intent);

                    }
                });

            }

        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null){
            adapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null){
            adapter.stopListening();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adapter != null){
            adapter.stopListening();
        }

    }
}
