package com.example.jonel.appzing.model;

/**
 * Created by jonel on 10/8/2017.
 */

public class Login {
    private int ID;
    private String maVung;
    private String SDT;

    public Login(String maVung, String SDT) {
        this.maVung = maVung;
        this.SDT = SDT;
    }

    public Login(int ID, String maVung, String SDT) {
        this.ID = ID;
        this.maVung = maVung;
        this.SDT = SDT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaVung() {
        return maVung;
    }

    public void setMaVung(String maVung) {
        this.maVung = maVung;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
