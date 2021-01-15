package com.h5190004.derya_cayiroglu_final.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.Toast;

import com.h5190004.derya_cayiroglu_final.utils.AlertDialogUtil;
import com.h5190004.derya_cayiroglu_final.utils.Constants;
import com.h5190004.derya_cayiroglu_final.utils.NetworkUtil;
import com.h5190004.derya_cayiroglu_final.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init(){
        imgLogo = findViewById(R.id.imgLogo);
        countDownTimeriBaslat();
    }

    private void countDownTimeriBaslat(){
        CountDownTimer countDownTimer = new CountDownTimer(Constants.TIMER_SANIYE,Constants.TIMER_ARALIK) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                internetKontrolEt();
            }
        };
        countDownTimer.start();
    }

    private void internetKontrolEt(){
        if(NetworkUtil.internetVarMi(getApplicationContext())){
            ekranGecisiYap();
        }else{
            AlertDialogUtil.alertDialogGoster(
                    SplashActivity.this,
                    getString(R.string.alert_dialog_internet_title),
                    getString(R.string.alert_dialog_internet_message),
                    Constants.INTERNET_YOK_DIALOG);
        }
    }

    private void ekranGecisiYap(){
        startActivity(new Intent(SplashActivity.this, ListeActivity.class));
        finish();
    }

}