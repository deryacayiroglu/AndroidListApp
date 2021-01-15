package com.h5190004.derya_cayiroglu_final.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190004.derya_cayiroglu_final.model.BilimKadiniModel;
import com.h5190004.derya_cayiroglu_final.R;
import com.h5190004.derya_cayiroglu_final.network.Service;
import com.h5190004.derya_cayiroglu_final.adapter.BilimKadiniAdaptor;
import com.h5190004.derya_cayiroglu_final.utils.AlertDialogUtil;
import com.h5190004.derya_cayiroglu_final.utils.Constants;
import com.h5190004.derya_cayiroglu_final.utils.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtAciklama;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogGoster(
                ListeActivity.this,
                getString(R.string.alert_dialog_geri_tusu_title),
                getString(R.string.alert_dialog_geri_tusu_message),
                Constants.CIKIS_DIALOG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }

    private void init(){
        imgKapak = findViewById(R.id.imgKapak);
        txtAciklama = findViewById(R.id.txtAciklama);
        progressDialogGoster();
        bilimKadinlariniGetir();
    }

    void  bilimKadinlariniGetir()
    {
        new Service().getServiceApi().bilimKadinlariniGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BilimKadiniModel>>() {
                    List<BilimKadiniModel> bilimKadinlari=new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(List<BilimKadiniModel> bilimKadiniList) {
                        bilimKadinlari=bilimKadiniList;
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete()
                    {
                        if(bilimKadinlari.size()>0) {
                            initRecycleView(bilimKadinlari);
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void initRecycleView(List<BilimKadiniModel> bilimKadiniList){
        recyclerView = findViewById(R.id.rcvBilimKadinlari);
        BilimKadiniAdaptor bilimKadiniAdaptor = new BilimKadiniAdaptor(bilimKadiniList, getApplicationContext(), new BilimKadiniAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                BilimKadiniModel tiklananBilimKadini = bilimKadiniList.get(position);
                ekranGecisiYap(tiklananBilimKadini);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(bilimKadiniAdaptor);
    }

    private void ekranGecisiYap(BilimKadiniModel tiklananBilimKadini){
        Intent detayActivityIntent = new Intent(getApplicationContext(),DetayActivity.class);
        String tiklananBilimKadiniString = ObjectUtil.bilimKadiniToJsonString(tiklananBilimKadini);
        detayActivityIntent.putExtra(Constants.TIKLANAN_BILIM_KADINI_TASINANIN_BASLIGI,tiklananBilimKadiniString);
        startActivity(detayActivityIntent);

    }

    private void progressDialogGoster(){
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getString(R.string.progress_dialog_message));
        progressDialog.show();
    }

}