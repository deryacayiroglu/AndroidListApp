package com.h5190004.derya_cayiroglu_final.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    public static void resimIndiripGoster(Context context, String url, ImageView img){
        Glide.with(context)
                .load(url)
                .fitCenter()
                .into(img);
    }
}
