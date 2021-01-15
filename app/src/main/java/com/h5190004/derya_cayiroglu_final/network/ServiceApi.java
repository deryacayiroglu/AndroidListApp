package com.h5190004.derya_cayiroglu_final.network;

import com.h5190004.derya_cayiroglu_final.model.BilimKadiniModel;
import com.h5190004.derya_cayiroglu_final.utils.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET(Constants.SERVIS_API)
    Observable<List<BilimKadiniModel>> bilimKadinlariniGetir();
}
