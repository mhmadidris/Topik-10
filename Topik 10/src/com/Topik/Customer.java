package com.Topik;

public class Customer {
    public String nik, nama, telepon;
    public int saldo;

    Customer (String nik, String nama, String telepon) {
        this.nik = nik;
        this.nama = nama;
        this.telepon = telepon;
    }

    public void setSaldo (int saldo){
        this.saldo = saldo;
    }

    public int getSaldo(){
        return saldo;
    }

    @Override
    public String toString(){
        return "NIK : " + nik +
                " | Nama : " + nama +
                " | Nomor Telepon : " + telepon;
    }
}
