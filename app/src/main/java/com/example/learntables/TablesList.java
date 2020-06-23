package com.example.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TablesList extends AppCompatActivity {

    LinearLayout linearLayoutVertical;
    String colorCollection[]={"#E44236","#2475B0","#10A881","#DFAF2B","#2F363F"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);
//        Intent intent=getIntent();
        linearLayoutVertical=findViewById(R.id.llv);
        int count=1;
        for(int j=0;j<20;j++) {
            LinearLayout parent = new LinearLayout(this);
            parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            params.setMarginEnd(5);

            parent.setOrientation(LinearLayout.HORIZONTAL);
            parent.setPadding(10,20,10,20);
            linearLayoutVertical.addView(parent);
            for (int i = 0; i < 5; i++) {
                GradientDrawable shape = new GradientDrawable();
                shape.setShape(GradientDrawable.RECTANGLE);
                shape.setColor(Color.parseColor(colorCollection[j%5]));
                shape.setCornerRadius(15);
                Button b1 = new Button(this);
                b1.setText(""+count);
                b1.setLayoutParams(params);
                b1.setTag(count);
                b1.setBackground(shape);
                b1.setTextColor(Color.WHITE);
                b1.setOnClickListener(handleClick(b1));
                parent.addView(b1);
                count++;
            }
        }

    }
    View.OnClickListener handleClick(final Button btn)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
//                Button btn=(Button)v;
                int tappedBtn= Integer.parseInt(btn.getTag().toString());
                Intent intent=new Intent(getApplicationContext(),Table.class);
                intent.putExtra("tableNo",tappedBtn);
                startActivity(intent);

            }
        };
    }
}

