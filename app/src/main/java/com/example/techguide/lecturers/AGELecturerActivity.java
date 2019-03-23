package com.example.techguide.lecturers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.techguide.R;
import com.example.techguide.common.Common;

public class AGELecturerActivity extends AppCompatActivity {

    CardView jimmy, moses, ajayo, okunade, omotayo, gbolabo, sanni, osunade,
        owolarafe, salami;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agelecturer);

        jimmy = findViewById(R.id.jimmy);
        moses = findViewById(R.id.moses);
        ajayo = findViewById(R.id.ajayi);
        okunade = findViewById(R.id.okunade);
        omotayo = findViewById(R.id.omotayo);
        gbolabo = findViewById(R.id.gbolabo);
        osunade = findViewById(R.id.osunade);
        sanni = findViewById(R.id.sanni);
        owolarafe = findViewById(R.id.owolarafe);
        salami = findViewById(R.id.salami);

        setClickListeners();

    }

    private void setClickListeners() {
        salami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.SALAMI_NAME);
                startActivity(intent);

            }
        });
        owolarafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.OWOLARAFE_NAME);
                startActivity(intent);

            }
        });
        sanni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.SANNI_NAME);
                startActivity(intent);

            }
        });
        osunade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.OSUNADE_NAME);
                startActivity(intent);

            }
        });
        gbolabo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.GBOLABO_NAME);
                startActivity(intent);

            }
        });
        omotayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.OMOTAYO_NAME);
                startActivity(intent);

            }
        });
        okunade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.OKUNADE_NAME);
                startActivity(intent);

            }
        });
        ajayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.AJAYI_NAME);
                startActivity(intent);

            }
        });
        moses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.MOSES_NAME);
                startActivity(intent);

            }
        });

        jimmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AGELecturerActivity.this, AGELecturerDetailActivity.class);
                intent.putExtra(Common.AGE_LECTURERS, Common.JIMMY_NAME);
                startActivity(intent);

            }
        });
    }
}
