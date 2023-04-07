package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Wallet extends BaseEntity {
    private int idWallet;
    private int account;
    private String cin;

    public Wallet() {
    }

    public Wallet(String cin,int account) {
        this.account = account;
        this.cin = cin;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public int getAccount() {
        return account;
    }

    public String getCin() {
        return cin;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "idWallet=" + idWallet +
                ", account=" + account +
                ", cin='" + cin + '\'' +
                '}';
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
