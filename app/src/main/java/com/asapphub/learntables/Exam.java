package com.asapphub.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Exam extends AppCompatActivity {

    private int first,second;
    private String eqn;
    private int answer,ansByUser,scoreGlobal,ques,numberOfQuestions;
    private boolean isCorrect;
    private Set set1,set2;
    private InterstitialAd mInterstitialAd;

    CountDownTimer countDownTimer;

    Integer[] s1,s2;

    String range,tables;
    EditText ans;
    TextView quesEqn,correctAns,score,quesNo;
    ImageView resImage;
    Button next,submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Intent intent=getIntent();

        tables=intent.getStringExtra("Tables");
        range=intent.getStringExtra("Range");

        numberOfQuestions=10;


        mInterstitialAd = new InterstitialAd(getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-9868666530260111/8846278217");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                endExamHelper();
            }
        });

        ans=findViewById(R.id.ans);
        quesEqn=findViewById(R.id.ques);
        submit=findViewById(R.id.submit);
        resImage=findViewById(R.id.resImage);
        correctAns=findViewById(R.id.correctAns);
        score=findViewById(R.id.score);
        next=findViewById(R.id.next);
        quesNo=findViewById(R.id.questionNo);

        ques=1;
        generateData(Integer.parseInt(tables),Integer.parseInt(range));
        initialSet(ques);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(countDownTimer!=null){
                    countDownTimer.cancel();
                }


                String s = ans.getText().toString();

                if(s.length()!=0) {
                    try {
                        ansByUser = Integer.parseInt(s);
                        if (ansByUser < 0) {
                            throw new Exception();
                        }
                        if (ansByUser > 20000) {
                            throw new Exception();
                        }
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Enter valid answer", Toast.LENGTH_LONG).show();
                        initialSet(ques);
                        return;
                    }

                    if (ansByUser == answer) {
                        isCorrect = true;
                    }
                }


                imageSet(isCorrect);
                setScore(isCorrect);
                setCorrectAns(isCorrect);

                next.setVisibility(View.VISIBLE);
                submit.setVisibility(View.INVISIBLE);
                ans.setEnabled(false);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(countDownTimer!=null){
                    countDownTimer.cancel();
                }
                if(ques<numberOfQuestions){
                    initialSet(++ques);
                }else{

                    endExam();
                }

            }
        });

        ans.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    hideKeyboard();
                }
            }
        });


    }



    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(ans.getWindowToken(), 0);
    }

    boolean leave=false;
    @Override
    public void onBackPressed() {
        if(leave){
            finish();
        }else{

            Toast.makeText(getApplicationContext(),"Press back button again to leave the test",Toast.LENGTH_LONG).show();
            leave=true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    leave = false;
                }
            }, 3 * 1000);
        }

    }

    void endExam(){


        if(countDownTimer!=null){
            countDownTimer.cancel();
        }



        if (mInterstitialAd.isLoaded()) {
//            Toast.makeText(getApplicationContext(),"loaded",Toast.LENGTH_SHORT).show();
            mInterstitialAd.show();
        }else{
//            Toast.makeText(getApplicationContext(),"not loaded",Toast.LENGTH_SHORT).show();
            endExamHelper();
        }


    }

    void endExamHelper(){
        Intent intent = new Intent(getApplicationContext(),ScoreResult.class);
        intent.putExtra("Result",Integer.toString(scoreGlobal));
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    void timerControl(){

        final TextView timer=findViewById(R.id.timer);


        countDownTimer=new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timer.setText("Time "+ String.valueOf(l/1000)+"sec");
            }

            @Override
            public void onFinish() {

                Toast.makeText(getApplicationContext(),"Time over",Toast.LENGTH_SHORT).show();
                submit.performClick();


            }
        }.start();
    }

    void generateData(int tables,int range){

        Random random = new Random();

        set1 = new HashSet<Integer>(numberOfQuestions);

        while(set1.size()< numberOfQuestions) {
            while (set1.add(random.nextInt(tables+1)) != true);
        }
        assert set1.size() == numberOfQuestions;

       s1= (Integer[]) set1.toArray(new Integer[numberOfQuestions]);

        Collections.shuffle(Arrays.asList(s1));

        set2 = new HashSet<Integer>(numberOfQuestions);

        while(set2.size()< numberOfQuestions) {
            while (set2.add(random.nextInt(range+1)) != true);
        }
        assert set2.size() == numberOfQuestions;

        s2= (Integer[]) set2.toArray(new Integer[numberOfQuestions]);

        Collections.shuffle(Arrays.asList(s2));




    }

    void initialSet(int i){

        quesNo.setText("Question: "+i);
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.VISIBLE);
        ans.setEnabled(true);
        ans.setText("");
        ans.setHint("ans:");
        resImage.setImageResource(R.drawable.question);
        correctAns.setText("");
        first=s1[i-1];
        second=s2[i-1];
        eqn=first+" x "+second+" = ";
        quesEqn.setText(eqn);
        answer=first*second;
        isCorrect=false;
        timerControl();

    }


    void setCorrectAns(boolean isCorrect){
        if(!isCorrect){
            correctAns.setText(Integer.toString(answer));
        }
    }

    void setScore(boolean isCorrect){
        if(isCorrect){
            scoreGlobal+=1;
            score.setText(scoreGlobal+"/"+numberOfQuestions);
        }
    }

    void imageSet(boolean isCorrect){

        if(isCorrect){
            resImage.setImageResource(R.drawable.tick);
        }else{
            resImage.setImageResource(R.drawable.cross);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }

    }
}


class loadAds extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] objects) {

        return null;
    }
}