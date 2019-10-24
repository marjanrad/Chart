package com.example.chart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowFragment extends AppCompatActivity {

    Button fragmentpie , fragmentliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fragment);


        fragmentpie=findViewById(R.id.pieChart);
        fragmentliner=findViewById(R.id.lineChart);

        fragmentpie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                f2 frg2 = new f2();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragmentDynamic, frg2);
//                ft.commit();
            }
        });
        fragmentliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                f1 frg1 = new f1();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragmentDynamic, frg1);
//                ft.commit();
            }
        });

    }
}
