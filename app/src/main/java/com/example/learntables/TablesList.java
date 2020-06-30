package com.example.learntables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TablesList extends AppCompatActivity {

//    AdLoader.Builder builder;
//    AdLoader adLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);



//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//        builder = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110");
//
//        new LoadAds().execute();
////

    }
    public void tapped(View v) {

                int tappedBtn= Integer.parseInt(v.getTag().toString());
                Intent intent=new Intent(getApplicationContext(),Table.class);
                intent.putExtra("tableNo",tappedBtn);
                startActivity(intent);
    }


//
//    public class LoadAds extends AsyncTask{
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//
//
//                builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//
//                        TemplateView template1 = (TemplateView) findViewById(R.id.my_template1);
//
//                        template1.setNativeAd(unifiedNativeAd);
//
//                    }
//                });
//
//            adLoader= builder.build();
//
//            adLoader.loadAd(new AdRequest.Builder().build());

//
//
//
//
//                builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//
//                        TemplateView template2 = (TemplateView) findViewById(R.id.my_template2);
//                        template2.setNativeAd(unifiedNativeAd);
//
//                    }
//                });
//
//
//             adLoader = builder.build();
//
//            adLoader.loadAd(new AdRequest.Builder().build());
//
//
//                builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
//                    @Override
//                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
//
//                        TemplateView template3 = (TemplateView) findViewById(R.id.my_template3);
//                        template3.setNativeAd(unifiedNativeAd);
//
//                    }
//                });
//
//
//             adLoader = builder.build();
//
//            adLoader.loadAd(new AdRequest.Builder().build());
//
//            return null;
//        }
//    }


}

