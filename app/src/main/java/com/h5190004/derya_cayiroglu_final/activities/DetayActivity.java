package com.h5190004.derya_cayiroglu_final.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu_final.R;
import com.h5190004.derya_cayiroglu_final.model.BilimKadiniModel;
import com.h5190004.derya_cayiroglu_final.utils.Constants;
import com.h5190004.derya_cayiroglu_final.utils.GlideUtil;
import com.h5190004.derya_cayiroglu_final.utils.ObjectUtil;

public class DetayActivity extends AppCompatActivity {

    ImageView imgKapakDetay;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        init();
    }

    private void init(){
        String tasinanBilimKadiniString = getIntent().getStringExtra(Constants.TIKLANAN_BILIM_KADINI_TASINANIN_BASLIGI);
        BilimKadiniModel bilimKadiniModel = ObjectUtil.jsonStringToBilimKadini(tasinanBilimKadiniString);

        imgKapakDetay = findViewById(R.id.imgKapakDetay);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(bilimKadiniModel.getAdi());
        GlideUtil.resimIndiripGoster(getApplicationContext(),bilimKadiniModel.getKapakFotoUrl(),imgKapakDetay);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtDetay.setText(Html.fromHtml(bilimKadiniModel.getAciklama(),Html.FROM_HTML_MODE_LEGACY));
        }
        else{
            txtDetay.setText(Html.fromHtml(bilimKadiniModel.getAciklama()));}

    }

}