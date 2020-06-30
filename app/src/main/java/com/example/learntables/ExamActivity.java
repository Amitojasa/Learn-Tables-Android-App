package com.example.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {

    ArrayList<String> list1,list2;
    ArrayAdapter<String> adapter1,adapter2;
    Button exam;
    Spinner spinner1,spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

//        Intent intent=getIntent();
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        for(int i=10;i<=100;i++){
            list1.add(String.valueOf(i));
        }

        list2.add(String.valueOf(10));
        list2.add(String.valueOf(20));

        spinner1=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);

        adapter1 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_item, list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        exam=findViewById(R.id.exam);
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String option1= (String) spinner1.getSelectedItem();
                String option2= (String) spinner2.getSelectedItem();

                Intent intent = new Intent(getApplicationContext(),Exam.class);
                intent.putExtra("Tables",option1);
                intent.putExtra("Range",option2);
                startActivity(intent);
            }
        });

    }
}
