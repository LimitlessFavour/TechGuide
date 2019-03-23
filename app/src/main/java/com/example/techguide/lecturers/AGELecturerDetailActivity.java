package com.example.techguide.lecturers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.techguide.R;
import com.example.techguide.common.Common;

public class AGELecturerDetailActivity extends AppCompatActivity {

    ImageView lecturerImage;

    TextView name, post, email, phone, degree, area;

    String nameS, profS = "Professor", snrLec = "Senior Lecturer", areaSAWR = "Soil and Water Resources Engineering";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agelecturer_detail);

        init();

        if (getIntent() != null){
            nameS = getIntent().getStringExtra(Common.AGE_LECTURERS);
            switch (nameS){

                case Common.JIMMY_NAME:
                    loadJimmy();
                    break;
                case Common.MOSES_NAME:
                    loadMoses();
                    break;
                case Common.AJAYI_NAME:
                    loadAjayi();
                    break;
                case Common.OKUNADE_NAME:
                    loadOkunade();
                    break;
                case Common.OMOTAYO_NAME:
                    loadOmotayo();
                    break;
                case Common.GBOLABO_NAME:
                    loadGbolabo();
                    break;
                case Common.SANNI_NAME:
                    loadSanni();
                    break;
                case Common.SALAMI_NAME:
                    loadSalami();
                    break;
                case Common.OSUNADE_NAME:
                    loadOsunade();
                    break;
                case Common.OWOLARAFE_NAME:
                    loadOwolarafe();
                    break;
            }
            name.setText(nameS);
        }
    }

    private void loadOwolarafe() {
        lecturerImage.setImageResource(R.drawable.owolarafe);
        name.setText("Prof Oseni Kehinde Owolarafe");
        post.setText(profS);
        email.setText("owolarafe@gmail.com");
        phone.setText("08056509073, 08095843531, 08089385410");
        degree.setText("B.Sc (1989), M.Sc (1999), Ph.D. (2007) MNSE, MASAE, \nMNIAE, Reg. Engr. COREN R- 7820 (1998)");
        area.setText("Farm Machinery and Agricultural Materials Processing");
    }

    private void loadOsunade() {
        lecturerImage.setImageResource(R.drawable.osunade);

        name.setText("Prof J.A. Osunade");
        post.setText(profS);
        email.setText("jasunade@oauife.edu.ng");
        phone.setText("08033736207");
        degree.setText("B.Sc (1981), M.Sc (1985), Ph.D. (1992) MNSE, \nMNIAE, Reg. Engr. COREN R- 2984 (1988)");
        area.setText("Farm Structure and Environmental Engineering");
    }

    private void loadSalami() {
        lecturerImage.setImageResource(R.drawable.salami);

        name.setText("Mr Adams Abiodun Salami");
        post.setText("Higher Technical Officer");
        email.setText("admaslink@gmail.com");
        phone.setText("07031368681");
        degree.setText("OND (2006), HND (2009)");
        area.setText(" ");
    }

    private void loadSanni() {
        lecturerImage.setImageResource(R.drawable.sanni);

        name.setText("Dr Lateef Ayodele Sanni");
        post.setText(snrLec);
        email.setText("Idsanni@yahoo.com");
        phone.setText("08062756778");
        degree.setText("B.Sc (1989), M.Sc (1999), MBA (2001), \nPh.D. (2014) MNSE, MNIAE, Reg. Engr. COREN R- 9238 (2002)");
        area.setText("Bioprocess Engineering and Machine Design");
    }

    private void loadGbolabo() {
        lecturerImage.setImageResource(R.drawable.ogunwande);

        name.setText("Dr Gbolabo Abidemi Ogunwande");
        post.setText(snrLec);
        email.setText("gbolawande@gmail.com");
        phone.setText("08034007128");
        degree.setText("B.Sc (1997), M.Sc (2007), Ph.D. (2010) MNSE, \nMNIAE, AWMgr, Reg. Engr. COREN R- 12741 (2006)");
        area.setText("Farm Structures and Environmental Engineering");
    }

    private void loadOmotayo() {
        lecturerImage.setImageResource(R.drawable.aregbesola);

        name.setText("Dr Omotayo Adeteju Aregbesola");
        post.setText(snrLec);
        email.setText("tttaregbs@yahoo.com");
        phone.setText("08033740386");
        degree.setText("B.Sc (1994), M.Sc (2001), Ph.D. (2011) MNSE, \nMNIAE, MASAE, Reg. Engr. COREN R- 9534 (2002)");
        area.setText("Food Processing and Storage");
    }

    private void loadOkunade() {
        lecturerImage.setImageResource(R.drawable.okunade);

        name.setText("Dr David Adebimpe Okunade");
        post.setText(snrLec);
        email.setText("odokunade@oauife.edu.ng");
        phone.setText("08033567534");
        degree.setText("B.Sc (1995), M.Sc (2004), Ph.D. (2015) MNSE, \nMNIAE, Reg. Engr. COREN R- 8997 (2002)");
        area.setText(areaSAWR);
    }

    private void loadAjayi() {
        lecturerImage.setImageResource(R.drawable.ajayi);

        name.setText("Prof Omolayo Ademola Ajayi");
        post.setText(profS);
        email.setText("oajayi2002@yahoo.co.uk");
        phone.setText(" ");
        degree.setText("B.Sc (1976), Ph.D. (1983) MNSE, \nMNIAE, Reg. Engr. COREN R- 2425 (1985)");
        area.setText("Farm Machinery and Crop Processing");
    }

    private void loadMoses() {
        lecturerImage.setImageResource(R.drawable.ige);

        name.setText("Prof Moses Toye Ige");
        post.setText(profS);
        email.setText("mige@oauife.edu.ng");
        phone.setText("08022334455");
        degree.setText("B.Sc (1969), M.Sc (1973), Ph.D. (1975) FNSE, \nFASAE, Reg. Engr. COREN R- 0966 (1977)");
        area.setText("Farm Power and Crop Processing");
    }

    private void loadJimmy() {

        lecturerImage.setImageResource(R.drawable.osunbitan);

        name.setText("Prof Jimmy Akinfemi Osunbitan");
        post.setText(profS);
        email.setText("osunbit@oauife.edu.ng");
        phone.setText("08036705604");
        degree.setText("B.Sc (1992), M.Sc (1999), Ph.D. (2007) MNSE, \nMNIAE, Reg. Engr. COREN R- 8145 (2000)");
        area.setText(areaSAWR);
    }

    private void init() {
        lecturerImage = findViewById(R.id.age_lec_image);

        name = findViewById(R.id.lecturer_name_detail);
        post = findViewById(R.id.lecturer_post_detail);
        email = findViewById(R.id.lecturer_email_detail);
        phone = findViewById(R.id.lecturer_phone_detail);
        degree = findViewById(R.id.lecturer_degree_detail);
        area = findViewById(R.id.lecturer_area_detail);

    }
}
