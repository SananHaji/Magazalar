package com.example.sqliteoyrenmeozumduzeltdiyim;

public class Magazalar {
    private int magaza_id;
    private String magaza_ad;
    private String magaza_sahibi;
    private String magaza_elaqe_nomresi;

    public Magazalar() {
    }

    public Magazalar(int magaza_id, String magaza_ad, String magaza_sahibi, String magaza_elaqe_nomresi) {
        this.magaza_id = magaza_id;
        this.magaza_ad = magaza_ad;
        this.magaza_sahibi = magaza_sahibi;
        this.magaza_elaqe_nomresi = magaza_elaqe_nomresi;
    }

    public int getMagaza_id() {
        return magaza_id;
    }

    public void setMagaza_id(int magaza_id) {
        this.magaza_id = magaza_id;
    }

    public String getMagaza_ad() {
        return magaza_ad;
    }

    public void setMagaza_ad(String magaza_ad) {
        this.magaza_ad = magaza_ad;
    }

    public String getMagaza_sahibi() {
        return magaza_sahibi;
    }

    public void setMagaza_sahibi(String magaza_sahibi) {
        this.magaza_sahibi = magaza_sahibi;
    }

    public String getMagaza_elaqe_nomresi() {
        return magaza_elaqe_nomresi;
    }

    public void setMagaza_elaqe_nomresi(String magaza_elaqe_nomresi) {
        this.magaza_elaqe_nomresi = magaza_elaqe_nomresi;
    }

}
