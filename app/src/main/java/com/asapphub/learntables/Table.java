package com.asapphub.learntables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Table extends AppCompatActivity {

    ArrayList<TableItem> exampleList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Intent intent=getIntent();
//        String tableof= intent.getStringExtra("tableNo");
        int tableof =intent.getIntExtra("tableNo",0);

        exampleList= new ArrayList<TableItem>();

        generateData(tableof);
        recyclerViewConfigs();
    }



    public void generateData(int tableof){

        exampleList= new ArrayList<TableItem>();


        for(int i=0;i<=20;i++) {
            String s1= tableof+" x "+i+" = ";
            String s2= String.valueOf((tableof*i));

            exampleList.add(new TableItem(s1,s2));
        }


    }

    public void recyclerViewConfigs(){
        //Config for rv

        recyclerView=findViewById(R.id.recyclerView);
        //performance
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        adapter= new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

}
