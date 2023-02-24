package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Wallet extends BaseEntity {
    private int idWallet;
    private int account;
    private User owner;

    public Wallet() {
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public Wallet(User owner, int account) {
        this.account = account;
        this.owner = owner;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public int getAccount() {
        return account;
    }



    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "idWallet=" + idWallet +
                ", account=" + account +
                ", owner ='" + owner + '\'' +
                '}';
    }

    public void setAccount(int account) {
        this.account = account;
    }

}
