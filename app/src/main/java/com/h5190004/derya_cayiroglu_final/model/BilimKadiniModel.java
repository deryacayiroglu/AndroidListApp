package com.h5190004.derya_cayiroglu_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BilimKadiniModel {
    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Alani")
    @Expose
    private String alani;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("OlumTarihi")
    @Expose
    private String olumTarihi;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAlani() {
        return alani;
    }

    public void setAlani(String alani) {
        this.alani = alani;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getOlumTarihi() {
        return olumTarihi;
    }

    public void setOlumTarihi(String olumTarihi) {
        this.olumTarihi = olumTarihi;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
