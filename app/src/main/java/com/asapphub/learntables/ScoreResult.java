package com.asapphub.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreResult extends AppCompatActivity {

    Button home;
    TextView score;
    MediaPlayer m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_result);

        Intent intent = getIntent();
        String res=intent.getStringExtra("Result");

        int r=Integer.parseInt(res);
        if(r>5){
            m1= MediaPlayer.create(this,R.raw.roll);
            m1.start();
        }


        home =findViewById(R.id.home);
        score=findViewById(R.id.result);

        score.setText(res);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
