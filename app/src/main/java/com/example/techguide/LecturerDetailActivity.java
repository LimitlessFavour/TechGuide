package com.example.techguide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.techguide.common.Common;
import com.example.techguide.model.LecturerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LecturerDetailActivity extends AppCompatActivity {

    TextView name, email, phone, level, degree, office;

    ImageView imageView;

    FirebaseDatabase database;
    DatabaseReference postrefHome;

    String deptS="", postId = "";

    //TODO: done the detail, do the UI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_detail);

        init();


        if (getIntent() != null){
            deptS = getIntent().getStringExtra(Common.DEPARTMENT);
            postId = getIntent().getStringExtra("postid");
        }

        if (!postId.isEmpty() && postId != null) {
            if (Common.isConnectedToInternet(this)) {

                loadData(postId);

            }else {
                Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show();

            }

        }


    }

    private void init() {
        name = findViewById(R.id.lecturer_name);
        email = findViewById(R.id.lecturer_email);
        phone = findViewById(R.id.lecturer_phone);
        level = findViewById(R.id.lecturer_level);
        degree = findViewById(R.id.lecturer_degree);
        office = findViewById(R.id.lecturer_office);

        imageView = findViewById(R.id.lecturer_image);

        database = FirebaseDatabase.getInstance();
        postrefHome = database.getReference(Common.NODE_LECTURERS);
    }

    private void loadData(String postId){
        postrefHome.child(deptS).child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LecturerModel lecturerModel = dataSnapshot.getValue(LecturerModel.class);

                name.setText(lecturerModel.getName());
                email.setText(lecturerModel.getEmail());
                phone.setText(lecturerModel.getPhoneNumber());
                office.setText(lecturerModel.getOfficeAddress());
                degree.setText(lecturerModel.getDegree());
                level.setText(lecturerModel.getLevel());

                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.ic_menu_gallery);

                Glide.with(getBaseContext())
                        .applyDefaultRequestOptions(requestOptions)
                        .setDefaultRequestOptions(requestOptions)
                        .load(lecturerModel.getImageUrl())
                        .into(imageView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
