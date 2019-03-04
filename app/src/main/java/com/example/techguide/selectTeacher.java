package com.example.techguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.techguide.common.Common;

public class selectTeacher extends AppCompatActivity {

CardView age,che,csc,cve,eee,fst,mee,mse ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teacher);

        age=findViewById(R.id.age_card_view);
        che=findViewById(R.id.che_card_view);
        csc=findViewById(R.id.CSC_card_view);
        cve=findViewById(R.id.cve_card_view);
        eee=findViewById(R.id.eee_card_view);
        fst=findViewById(R.id.fst_card_view);
        mee=findViewById(R.id.mee_card_view);
        mse=findViewById(R.id.mse_card_view);

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.AGE);
                startActivity(intent);
            }
        });

        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.CHE);
                startActivity(intent);
            }
        });

        csc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.CSC);
                startActivity(intent);
            }
        });
        cve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.CVE);
                startActivity(intent);
            }
        });
        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.EEE);
                startActivity(intent);
            }
        });
        fst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.FST);
                Toast.makeText(selectTeacher.this, ""+Common.FST, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        mee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.MEE);
                Toast.makeText(selectTeacher.this, "" + Common.MEE, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        mse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(selectTeacher.this, Lecturer.class);
                intent.putExtra(Common.KEY, Common.MSE);
                Toast.makeText(selectTeacher.this, ""+Common.MSE, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
